package com.holub.database;

import com.holub.text.ParseFailure;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.io.*;

public class ConcreteTableTest {
	Table people = TableFactory.create("people", new String[] { "Last", "First", "Id", "height" });
	Database database;

	private void setData() {
		try {
			people.insert(new String[] { "Allen", "Holub", "1", "177" });
			people.insert(new String[] { "Ichabod", "Crane", "2", "183" });
			people.insert(new String[] { "Rip", "VanWinkle", "3", "180" });
			people.insert(new String[] { "Goldie", "Locks", "4", "183" });
			people.insert(new String[] { "Goldie", "Locks", "4", "183" });
			people.insert(new String[] { "Allen", "Holub", "1", "155" });
			people.insert(new String[] { "Ichabod", "Crane", "2", "183" });
			database = new Database(new File("C:/DP2023"));
		} catch (Exception e) { }
	}

	@Test
	public void aggregateTest() throws IOException, ParseFailure {
		setData();
		String query = "select count(distinct Id) as unique, avg(height), max(height) as tallest from people";
		Table result = database.execute(query);
		String expected = "<anonymous>\n" + "unique\tavg(height)\ttallest\t\n"
				+ "----------------------------------------\n" +
				"4.00\t177.71\t183.00\t\n";
		System.out.print(result.toString());
		System.out.print(expected);
		assertEquals(result.toString(), expected);
	}

	@Test
	public void orderByTest() throws IOException, ParseFailure {
		setData();
		String query = "select distinct * from people order by height";
		Table result = database.execute(query);
		String expected = "<anonymous>\n" +
				"Last\tFirst\tId\theight\t\n" +
				"----------------------------------------\n" +
				"Ichabod\tCrane\t2\t183\t\n" +
				"Goldie\tLocks\t4\t183\t\n" +
				"Rip\tVanWinkle\t3\t180\t\n" +
				"Allen\tHolub\t1\t177\t\n" +
				"Allen\tHolub\t1\t155\t\n";
		System.out.print(result.toString());
		System.out.print(expected);
		assertEquals(result.toString(), expected);
	}
	@Test
	public void whereTest() throws IOException, ParseFailure {
		setData();
		String query = "select Last from people where Id = 1";
		Table result = database.execute(query);
		String expected = "<anonymous>\n" +
				"Last\t\n" +
				"----------------------------------------\n" +
				"Allen\t\n" +
				"Allen\t\n";
		System.out.print(result.toString());
		System.out.print(expected);
		assertEquals(result.toString(), expected);
	}
}
