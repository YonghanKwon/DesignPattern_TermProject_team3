package DP_Application;

import java.io.IOException;
import java.util.Iterator;

import com.holub.database.*;
import com.holub.text.ParseFailure;
import com.holub.tools.ArrayIterator;

public class channel {
	Membership membership;
	State premiumState;
	State ordinaryState;
	State state;
	
	private String name;
	private int sub_num;
	private int video_num;
	public channel(Membership membership, String name) throws IOException, ParseFailure {
		this.membership = membership;
		this.name = name;
		premiumState = new PremiumState();
		ordinaryState = new OrdinaryState();
		Database db = new Database("C:/dp2023");
		
		String query="select DISTINCT * from Channel where name=\""+name+"\"";
		Table result = db.execute(query);
		if( ((ConcreteTable)result).getrowSet().size() == 0) {//data insert
			boolean premium = false;
			sub_num=0;
			video_num=0;
			state = ordinaryState;
			
			db.execute("insert into Channel (name,sub_num,vid_num,prem) values (\""+name+"\",\""+sub_num+"\",\""+video_num+"\",\""+premium+"\")");
			db.execute("dump");	
		}
		else {//data load
			Iterator rows=new ArrayIterator((Object[])((ConcreteTable)result).getrowSet().iterator().next()); 
			
			rows.next().toString();		//name
			this.sub_num=Integer.parseInt(rows.next().toString());
			this.video_num=Integer.parseInt(rows.next().toString());
			state = Boolean.parseBoolean((rows.next().toString())) ? premiumState : ordinaryState;
		}
		
		//if channel table doesn't have name, then insert.
		
	}
	public String getName() {
		return name;
	}
	public void mediate(String target) throws IOException, ParseFailure {
		new Membership().mediate(target, this.getName());
	}
	public void watch(channel channel, Table video) throws IOException, ParseFailure {
		state.watch(channel, video);
	}
}
