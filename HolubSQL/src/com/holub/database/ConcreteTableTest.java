package com.holub.database;
import com.holub.text.ParseFailure;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;
public class ConcreteTableTest {
    Table people = TableFactory.create("name", new String[] { "first", "last", "addrId", "age" });
    Table address = TableFactory.create("address", new String[] { "addrId", "street", "city", "state", "zip" });
    Database database;

    private void setData(){
        try{
            people.insert(new Object[]{"firstA", "lastA", 1, 20});
            people.insert(new Object[]{"firstB", "lastB", 1, 30});
            people.insert(new Object[]{"firstC", "lastC", 0, 10});
            people.insert(new Object[]{"firstD", "lastD", 0, 15});

            address.insert(new Object[]{0, "streetA", "cityA", "stateA", "zipA"});
            address.insert(new Object[]{1, "streetB", "cityB", "stateB", "zipB"});

            database = new Database(new File("."));
        } catch (Exception e){}
    }	
//    @Test
//    public void selectWithDistinct() throws IOException, ParseFailure {
//        setData();
//        String query = "select distinct addrId from name";
//        Table result = database.execute(query);
//        System.out.println(result.toString());
//        String expected = "<anonymous>\n" +
//                 "addrId\t\n" +
//                 "----------------------------------------\n" +
//                 "1\t\n" +
//                 "0\t\n";
//         assertEquals(result.toString(), expected);
//    }
    @Test
    public void selectWithAggregate() throws IOException, ParseFailure {
        setData();
        String query = "select MAX(addrId), MIN(age) from name";
        Table result = database.execute(query);
        // String expected = "<anonymous>\n" +
        //         "MAX(addrID)\t\n" +
        //         "----------------------------------------\n" +
        //         "1\t\n";
        // assertEquals(result.toString(), expected);
    }
}
