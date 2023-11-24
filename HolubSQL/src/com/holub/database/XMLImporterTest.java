package com.holub.database;

import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;


public class XMLImporterTest { //반드시 XMLExporterTest진행후 xml형식의 해당 파일이 만들어진 상태에서 테스트 해야함 . HTMLExporterTest 직후에 테스트하면 해당 파일내용이 html형식이라 오류발생
    @Test
    public void XMLImporter() throws IOException, ParserConfigurationException, SAXException {
       
        String file = "c:/dp2023/people"; //XMLExporter로 내보낸 people을 읽어보겠다.
        FileReader fr=new FileReader(file);
        XMLImporter builder1 = new XMLImporter(fr);
        builder1.startTable();
        assertEquals(builder1.loadTableName(), "people");
        assertEquals(builder1.loadWidth(), 3);
        Iterator row;
        row = builder1.loadRow();     
        String[][] expected={{"Allen", "Holub", "1"}, {"Ichabod", "Crane", "2"}, {"Rip", "VanWinkle", "3"}, {"Goldie", "Locks", "4"}};
        Iterator<String> expectedIterator=convertArrayToIterator(expected);
        
        int i=0;
        while(expectedIterator.hasNext()) {
           if(i!=0&&i%3==0) {
              row=builder1.loadRow();
           }
           assertEquals(expectedIterator.next(), row.next());
           i++;
        }
        
        
        
        
        //assertEquals(expectedIterator, row);
        
        /*String file2 = "c:/dp2020/university"; //XMLExporter로 내보낸 university을 읽어보겠다.
        XMLImporter builder2 = new XMLImporter(file2);
        builder2.startTable();
        assertEquals(builder2.loadTableName(), is(equalTo("university")));
        assertEquals(builder2.loadWidth(), 2);
        Iterator row2;
        row2 = builder2.loadRow();
        String[][] expected2 = {{"chungang", "seoul"}, {"seoul", "seoul"}, {"woosong", "daejeon"}};
        assertEquals(expected2, row2);
      */

    }

private static Iterator<String> convertArrayToIterator(String[][] array) {
        List<String> flattenedList = new ArrayList<>();
        for (String[] row : array) {
            flattenedList.addAll(Arrays.asList(row));
        }
        return flattenedList.iterator();
    }

}