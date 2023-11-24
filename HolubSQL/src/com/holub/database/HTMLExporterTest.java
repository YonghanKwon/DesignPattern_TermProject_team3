package com.holub.database;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;


public class HTMLExporterTest {
    @Test
    public void HTML() throws IOException {
        Table people = TableFactory.create("people",
                new String[]{"Last", "First", "Id"});
        people.insert(new String[]{"Allen", "Holub", "1"});
        people.insert(new String[]{"Ichabod", "Crane", "2"});
        people.insert(new String[]{"Rip", "VanWinkle", "3"});
        people.insert(new String[]{"Goldie", "Locks", "4"});
        Writer out = new FileWriter("c:/dp2023/people");
        HTMLExporter builder1 = new HTMLExporter(out);
        people.export(builder1);
        out.close();
        File file = new File("c:/dp2023/people");
        StringBuffer stringBuffer = new StringBuffer();
        FileReader fileReader = new FileReader(file);
        int index = 0;
        while ((index = fileReader.read()) != -1) {
            stringBuffer.append((char) index);

        }
//        HTMLExporter테스트
        assertEquals(stringBuffer.toString(),"<h2>people</h2><table><tr><td>Last</td><td>First</td><td>Id</td></tr>" +
                "<tr><td>Allen</td><td>Holub</td></tr><tr><td>Ichabod</td><td>Crane</td><td>2</td></tr><tr><td>Rip</td><td>VanWinkle</td><td>3</td></tr><tr><td>Goldie</td><td>Locks</td><td>4</td></tr>");

        fileReader.close();

        System.out.println("-------------------------------------------");

        /*Table university = TableFactory.create("university",
                new String[]{"name", "location"});
        university.insert(new String[]{"chungang", "seoul"});
        university.insert(new String[]{"seoul", "seoul"});
        university.insert(new String[]{"woosong", "daejeon"});
        Writer out1 = new FileWriter("c:/dp2023/university");
        HTMLExporter builder2 = new HTMLExporter(out1);
        university.export(builder2);
        out1.close();
        File file2 = new File("c:/dp2023/university");
        StringBuffer stringBuffer2 = new StringBuffer();
        FileReader fileReader2 = new FileReader(file2);
        int index2 = 0;
        while ((index2 = fileReader2.read()) != -1) {
            stringBuffer2.append((char) index2);

        }
//        HTMLExporter테스트
        assertEquals(stringBuffer2.toString(), is(equalTo("<html><body>university<table border=\"1\"><th>name</th><th>location</th><tr><td>chungang</td><td>seoul</td></tr><tr><td>seoul</td><td>seoul</td>" +
                "</tr><tr><td>woosong</td><td>daejeon</td></tr></table></body></html>")));

       
        StringBuffer stringBuffer3 = new StringBuffer();
        File file3 = new File("c:/dp2023/university.html");
        FileReader fileReader3 = new FileReader(file3);
        int index3 = 0;
        while ((index3 = fileReader3.read()) != -1) {
            stringBuffer3.append((char) index3);

        }
//        getFileVisitor, decorateVisitor테스트
        assertEquals(stringBuffer3.toString(), is(equalTo("<html><body>university<table border=\"1\"><th>name</th><th>location</th><tr><td>chungang</td><td>seoul</td></tr><tr>" +
                "<td>seoul</td><td>seoul</td>" +
                "</tr><tr><td>woosong</td><td>daejeon</td></tr></table></body></html>")));

        fileReader2.close();
        fileReader3.close();
        */

    }

}