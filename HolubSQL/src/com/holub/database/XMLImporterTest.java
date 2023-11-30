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
       
        String file = "c:/dp2023/people.xml"; //XMLExporter로 내보낸 people을 읽어보겠다.
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
        
        String file2="c:/dp2023/bloodstorage.xml";
        FileReader fr2=new FileReader(file2);
        XMLImporter builder2=new XMLImporter(fr2);
        builder2.startTable();
        assertEquals(builder2.loadTableName(), "bloodstorage");
        assertEquals(builder2.loadWidth(), 5);
        Iterator row2;
        row2=builder2.loadRow();
        String[][] expected2= {{"1", "Allen", "A", "20", "F"}, {"2", "Troy", "B", "25", "M"},
        		{"3", "Kevin", "AB", "40", "M"}, {"4", "Goldie", "O", "30", "F"}, {"5", "Chunsik", "B", "31", "M"}, {"6", "Bob", "A", "27", "M"}};
        Iterator<String> expected2Iterator=convertArrayToIterator(expected2);
        
        i=0;
        while(expected2Iterator.hasNext()) {
        	if(i!=0&&i%5==0) {
        		row2=builder2.loadRow();
        	}
        	assertEquals(expected2Iterator.next(), row2.next());
        	i++;
        }
        
        String file3="c:/dp2023/movie.xml";
        FileReader fr3=new FileReader(file3);
        XMLImporter builder3=new XMLImporter(fr3);
        builder3.startTable();
        assertEquals(builder3.loadTableName(), "movie");
        assertEquals(builder3.loadWidth(), 5);
        Iterator row3;
        row3=builder3.loadRow();
        String[][] expected3= {{"The Shawshank Redemption", "1994", "142m", "9.3", "Drama"}, {"The Godfather", "1972", "175m", "9.2", "Crime"},
        		{"The Dark Knight", "2008", "152m", "9.0", "Action"}, {"Forrest Gump", "1994", "142m", "8.8", "Drama"},
        		{"Oppenheimer", "2023", "180m", "8.5", "Biography"}};
        Iterator<String> expected3Iterator=convertArrayToIterator(expected3);
        
        i=0;
        while(expected3Iterator.hasNext()) {
        	if(i!=0&&i%5==0) {
        		row3=builder3.loadRow();
        	}
        	assertEquals(expected3Iterator.next(), row3.next());
        	i++;
        }
       	
    }

private static Iterator<String> convertArrayToIterator(String[][] array) {
        List<String> flattenedList = new ArrayList<>();
        for (String[] row : array) {
            flattenedList.addAll(Arrays.asList(row));
        }
        return flattenedList.iterator();
    }

}