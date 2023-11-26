package com.holub.database;
import com.holub.text.ParseFailure;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;
public class ConcreteTableTest {
    Table people = TableFactory.create("name", new String[] { "first", "last", "addrId" });
    Table address = TableFactory.create("address", new String[] { "addrId", "street", "city", "state", "zip" });
    Database database;

    private void setData(){
        try{
            people.insert(new Object[]{"firstA", "lastA", 1});
            people.insert(new Object[]{"firstB", "lastB", 1});
            people.insert(new Object[]{"firstC", "lastC", 0});
            people.insert(new Object[]{"firstD", "lastD", 0});

            address.insert(new Object[]{0, "streetA", "cityA", "stateA", "zipA"});
            address.insert(new Object[]{1, "streetB", "cityB", "stateB", "zipB"});

            database = new Database(new File("."));
        } catch (Exception e){}
    }
    @Test
    public void selectWithDistinct() throws IOException, ParseFailure {
        setData();
        String query = "select MAX(addrId) from name";
        Table result = database.execute(query);
        // String expected = "<anonymous>\n" +
        //         "MAX(addrID)\t\n" +
        //         "----------------------------------------\n" +
        //         "1\t\n";
        // assertEquals(result.toString(), expected);
    }
}
