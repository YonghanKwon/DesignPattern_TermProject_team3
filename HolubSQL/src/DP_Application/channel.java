package DP_Application;

import java.io.IOException;
import java.util.Observable;

import com.holub.database.Table;
import com.holub.database.TableFactory;

public class channel {

	public Table channel;
	private String name;
	public channel(String name) throws IOException {
		this.name=name;
		
		TableFactory.load("channel.csv","C:/DP2023");
		//if channel table doesn't have name, then insert.
		
	}
	public String getName() {
		return name;
	}
	public boolean iscontain(String name) {
		System.out.println("select name from channel where name=\""+name+"\"");
		//this query return null, return false else return true
		return true;
	}

}
