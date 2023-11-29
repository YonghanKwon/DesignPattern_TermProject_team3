package com.holub.database;
import com.holub.text.ParseFailure;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.io.*;
public class ConcreteTableTest{
	Table people=TableFactory.create("people",new String[]{"Last", "First", "Id"});
	Database database;
	
	private void setData() {
		try {
			people.insert(new String[]{"Allen", "Holub", "1"});
	     	people.insert(new String[]{"Ichabod", "Crane", "2"});
	     	people.insert(new String[]{"Rip", "VanWinkle", "3"});
	     	people.insert(new String[]{"Goldie", "Locks", "4"});
	     	database=new Database(new File("C:/dp2023"));
		}catch(Exception e) {}
	   
	}
	@Test
	 public void aggregateTest() throws IOException, ParseFailure {
	        setData();
	        String query = "select avg(Id) as ID from people";
	        Table result = database.execute(query);
	        String expected = "<anonymous>\n" +
	                "ID\t\n" +
	                "----------------------------------------\n" +
	                "2.50\t\n";
	        System.out.print(result.toString());
	        System.out.print(expected);
	        assertEquals(result.toString(), expected);
	    }
}
