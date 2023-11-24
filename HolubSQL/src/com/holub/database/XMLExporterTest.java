package com.holub.database;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

public class XMLExporterTest {
    @Test
    public void XMLExporter() throws IOException {
        Table people = TableFactory.create("people",
                new String[]{"Last", "First", "Id"});
        people.insert(new String[]{"Allen", "Holub", "1"});
        people.insert(new String[]{"Ichabod", "Crane", "2"});
        people.insert(new String[]{"Rip", "VanWinkle", "3"});
        people.insert(new String[]{"Goldie", "Locks", "4"});
        Writer out = new FileWriter("c:/dp2023/people");
        XMLExporter builder1 = new XMLExporter(out);
        people.export(builder1);
        out.close();
        File file = new File("c:/dp2023/people");
        StringBuffer stringBuffer = new StringBuffer();
        FileReader fileReader = new FileReader(file);
        int index = 0;
        while ((index = fileReader.read()) != -1) {
            stringBuffer.append((char) index);

        }
//        XMLExporter테스트
        assertEquals(stringBuffer.toString(), "<?xml  version=\"1.0\"  encoding=\"UTF-8\" ?><Table><TableName>people</TableName><Data><Last>Allen</Last><First>Holub</First><Id>1</Id></Data><Data><Last>Ichabod</Last><First>Crane</First><Id>2</Id></Data><Data><Last>Rip</Last><First>VanWinkle</First><Id>3</Id></Data><Data><Last>Goldie</Last><First>Locks</First><Id>4</Id></Data></Table>");
        
        fileReader.close();
        System.out.println("------------------------------------------");
        /*

        StringBuffer stringBuffer1 = new StringBuffer();
        File file1 = new File("c:/dp2020/people.xml");
        FileReader fileReader1 = new FileReader(file1);
        int index1 = 0;
        while ((index1 = fileReader1.read()) != -1) {
            stringBuffer1.append((char) index1);

        }
//        getFileVisitor테스트
        assertEquals(stringBuffer.toString(), is(equalTo("<root><title>people</title><DATA><First>Allen</First><Last>Holub</Last><Id>1</Id></DATA><DATA><First>Ichabod</First><Last>Crane</Last>" +
                "<Id>2</Id></DATA><DATA><First>Rip</First><Last>VanWinkle</Last><Id>3</Id></DATA><DATA><First>Goldie</First><Last>Locks</Last><Id>4</Id></DATA></root>")));
        fileReader.close();
        fileReader1.close();

        System.out.println("------------------------------------------");

        Table university = TableFactory.create("university",
                new String[]{"name", "location",});
        university.insert(new String[]{"chungang", "seoul"});
        university.insert(new String[]{"seoul", "seoul"});
        university.insert(new String[]{"woosong", "daejeon"});
        Writer out1 = new FileWriter("c:/dp2020/university");
        XMLExporter builder2 = new XMLExporter(out1);
        university.export(builder2);
        out1.close();
        File file2 = new File("c:/dp2020/university");
        StringBuffer stringBuffer2 = new StringBuffer();
        FileReader fileReader2 = new FileReader(file2);
        int index2 = 0;
        while ((index2 = fileReader2.read()) != -1) {
            stringBuffer2.append((char) index2);

        }
//        XMLExporter테스트
        assertThat(stringBuffer2.toString(), is(equalTo("<root><title>university</title><DATA><name>chungang</name><location>seoul</location></DATA><DATA><name>seoul</name><location>seoul</location>" +
                "</DATA><DATA><name>woosong</name><location>daejeon</location></DATA></root>")));
        builder2.accept(new getFileVisitor("university", university));

        StringBuffer stringBuffer3 = new StringBuffer();
        File file3 = new File("c:/dp2020/university.xml");
        FileReader fileReader3 = new FileReader(file3);
        int index3 = 0;
        while ((index3 = fileReader3.read()) != -1) {
            stringBuffer3.append((char) index3);

        }
//        getFileVisitor테스트
        assertThat(stringBuffer3.toString(), is(equalTo("<root><title>university</title><DATA><name>chungang</name><location>seoul</location></DATA><DATA><name>seoul</name><location>seoul</location>" +
                "</DATA><DATA><name>woosong</name><location>daejeon</location></DATA></root>")));
        fileReader2.close();
        fileReader3.close();
    }*/
    }
}