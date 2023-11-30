package DP_Application;

import java.io.IOException;
import java.util.Iterator;

import com.holub.database.ConcreteTable;
import com.holub.database.Database;
import com.holub.database.Table;
import com.holub.text.ParseFailure;
import com.holub.tools.ArrayIterator;

public class video {
	private String title;
	private String publisher;
	private String duration;
	private int count;
	private String classfication;
	public video(String title) throws IOException, ParseFailure {
		this.title=title;
		
		Database db = new Database("C:/dp2023");
		String query="select DISTINCT * from Video where title=\""+title+"\"";
		Table result = db.execute(query);
		
		Iterator rows=new ArrayIterator((Object[])((ConcreteTable)result).getrowSet().iterator().next()); 
			
		rows.next().toString();		//name
		this.publisher=rows.next().toString();
		this.duration=rows.next().toString();
		this.count=Integer.parseInt((rows.next().toString()));
		this.classfication=rows.next().toString();
	}
	public video(String title, String publisher, String duration, int count, String classfication) throws IOException, ParseFailure {//constructor for upload
		this.title=title;
		this.publisher=publisher;
		this.duration=duration;
		this.count=count;
		this.classfication=classfication;
		
		Database db = new Database("C:/DP2023");
		
		Table check=db.execute("select * from Video where title=\""+title+"\",publisher = \""+publisher+"\",duration=\""+duration+"\",count=\""+count+"\",classfication=\""+classfication+"\"");
		String[] temp_table = check.toString().split("\n");

		if(temp_table.length==3)   //check table is empty
		{
		   db.execute("insert into Video (title,publisher,duration,count,classfication) values (\""+title+"\",\""+publisher+"\",\""+duration+"\",\""+count+"\",\""+classfication+"\")");
		   db.execute("dump");
		   Table tempTable;
		   tempTable=db.execute("select vid_num from Channel where name = \""+publisher+"\"");

		   temp_table = tempTable.toString().split("\n");
		   String[] vid = temp_table[3].split("\\t");
		   int user_video_num=Integer.parseInt(vid[0]);
		   user_video_num++;
		   db.execute("update Channel set vid_num = \""+user_video_num+"\" where name = \""+publisher+"\"");
		   db.execute("dump");
		   System.out.println("Video "+title+" is inserted in Database");
		}
		else
			System.out.println("Video "+title+" already exists in Database");
		
	 }
}
