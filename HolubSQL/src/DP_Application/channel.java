package DP_Application;

import java.io.IOException;
import java.util.Iterator;
import java.util.Observable;

import com.holub.database.*;
import com.holub.text.ParseFailure;
import com.holub.tools.ArrayIterator;

public class channel {

	private Table channel;
	
	private String name;
	private int sub_num;
	private int video_num;
	private boolean premium;
	public channel(String name) throws IOException, ParseFailure {
		this.name=name;

		Database db = new Database("C:/DP2023"); 
		String query="select DISTINCT * from Channel where name=\""+name+"\"";
		Table result = db.execute(query);
		if( ((ConcreteTable)result).getrowSet().size() == 0) {//data insert
			

			sub_num=0;
			video_num=0;
			premium=false;
			
			db.execute("insert into Channel (name,sub_num,video_num,premium) values (\""+name+"\",\""+sub_num+"\",\""+video_num+"\",\""+premium+"\")");
			db.execute("dump");	//데이터 저장 위치.
		}
		else {//data load
			Iterator rows=new ArrayIterator((Object[])((ConcreteTable)result).getrowSet().iterator().next()); //한줄 전체
			
			rows.next().toString();		//name
			this.sub_num=Integer.parseInt(rows.next().toString());
			this.video_num=Integer.parseInt(rows.next().toString());
			this.premium=Boolean.parseBoolean((rows.next().toString()));
		}
		//if channel table doesn't have name, then insert.
		
	}
	public String getName() {
		return name;
	}


}
