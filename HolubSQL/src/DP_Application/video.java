package DP_Application;

import java.io.IOException;
import java.util.Iterator;

import com.holub.database.ConcreteTable;
import com.holub.database.Database;
import com.holub.database.Table;
import com.holub.database.TableFactory;
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
		
		Database db = new Database("C:/DP2023");
		String query="select DISTINCT * from Video where title=\""+title+"\"";
		Table result = db.execute(query);
		
		{//data load
			Iterator rows=new ArrayIterator((Object[])((ConcreteTable)result).getrowSet().iterator().next()); 
			
			rows.next().toString();		//name
			this.publisher=rows.next().toString();
			this.duration=rows.next().toString();
			this.count=Integer.parseInt((rows.next().toString()));
			this.classfication=rows.next().toString();
		}
	}
	public video(String title, String publisher, String duration, int count, String classfication) throws IOException, ParseFailure {//constructor for upload
		Database db = new Database("C:/DP2023");
		db.execute("insert into Video (title,publisher,duration,count,classfication) values (\""+title+"\",\""+publisher+"\",\""+duration+"\",\""+count+"\",\""+classfication+"\")");
		db.execute("dump");	
	}
	
}
