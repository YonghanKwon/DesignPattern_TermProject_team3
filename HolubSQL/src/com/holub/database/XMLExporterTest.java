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
        Writer out = new FileWriter("c:/dp2023/people.xml");
        XMLExporter builder1 = new XMLExporter(out);
        people.export(builder1);
        out.close();
        File file = new File("c:/dp2023/people.xml");
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
        
        Table bloodstorage = TableFactory.create("bloodstorage",
                new String[]{"Id", "Name", "Bloodtype", "Age", "Gender"});
        bloodstorage.insert(new String[]{"1", "Allen", "A", "20", "F"});
        bloodstorage.insert(new String[]{"2", "Troy", "B", "25", "M"});
        bloodstorage.insert(new String[]{"3", "Kevin", "AB", "40", "M"});
        bloodstorage.insert(new String[]{"4", "Goldie", "O", "30", "F"});
        bloodstorage.insert(new String[]{"5", "Chunsik", "B", "31", "M"});
        bloodstorage.insert(new String[]{"6", "Bob", "A", "27", "M"});
        Writer out1 = new FileWriter("c:/dp2023/bloodstorage.xml");
        XMLExporter builder2 = new XMLExporter(out1);
        bloodstorage.export(builder2);
        out1.close();
        File file2 = new File("c:/dp2023/bloodstorage.xml");
        StringBuffer stringBuffer2 = new StringBuffer();
        FileReader fileReader2 = new FileReader(file2);
        int index2 = 0;
        while ((index2 = fileReader2.read()) != -1) {
            stringBuffer2.append((char) index2);

        }
        
        assertEquals(stringBuffer2.toString(), "<?xml  version=\"1.0\"  encoding=\"UTF-8\" ?><Table><TableName>bloodstorage</TableName><Data><Id>1</Id><Name>Allen</Name><Bloodtype>A</Bloodtype><Age>20</Age><Gender>F</Gender></Data><Data><Id>2</Id><Name>Troy</Name><Bloodtype>B</Bloodtype><Age>25</Age><Gender>M</Gender></Data><Data><Id>3</Id><Name>Kevin</Name><Bloodtype>AB</Bloodtype><Age>40</Age><Gender>M</Gender></Data><Data><Id>4</Id><Name>Goldie</Name><Bloodtype>O</Bloodtype><Age>30</Age><Gender>F</Gender></Data><Data><Id>5</Id><Name>Chunsik</Name><Bloodtype>B</Bloodtype><Age>31</Age><Gender>M</Gender></Data><Data><Id>6</Id><Name>Bob</Name><Bloodtype>A</Bloodtype><Age>27</Age><Gender>M</Gender></Data></Table>");
        
        fileReader2.close();
        System.out.println("------------------------------------------");
        
        Table movie = TableFactory.create("movie",
                new String[]{"Title", "Releaseyear", "Runningtime", "Rating", "Genre"});
        movie.insert(new String[]{"The Shawshank Redemption", "1994", "142m", "9.3", "Drama"});
        movie.insert(new String[]{"The Godfather", "1972", "175m", "9.2", "Crime"});
        movie.insert(new String[]{"The Dark Knight", "2008", "152m", "9.0", "Action"});
        movie.insert(new String[]{"Forrest Gump", "1994", "142m", "8.8", "Drama"});
        movie.insert(new String[]{"Oppenheimer", "2023", "180m", "8.5", "Biography"});
        Writer out2 = new FileWriter("c:/dp2023/movie.xml");
        XMLExporter builder3 = new XMLExporter(out2);
        movie.export(builder3);
        out2.close();
        File file3 = new File("c:/dp2023/movie.xml");
        StringBuffer stringBuffer3 = new StringBuffer();
        FileReader fileReader3 = new FileReader(file3);
        int index3 = 0;
        while ((index3 = fileReader3.read()) != -1) {
            stringBuffer3.append((char) index3);

        }
//        HTMLExporter테스트
        assertEquals(stringBuffer3.toString(), "<?xml  version=\"1.0\"  encoding=\"UTF-8\" ?><Table><TableName>movie</TableName><Data><Title>The Shawshank Redemption</Title><Releaseyear>1994</Releaseyear><Runningtime>142m</Runningtime><Rating>9.3</Rating><Genre>Drama</Genre></Data><Data><Title>The Godfather</Title><Releaseyear>1972</Releaseyear><Runningtime>175m</Runningtime><Rating>9.2</Rating><Genre>Crime</Genre></Data><Data><Title>The Dark Knight</Title><Releaseyear>2008</Releaseyear><Runningtime>152m</Runningtime><Rating>9.0</Rating><Genre>Action</Genre></Data><Data><Title>Forrest Gump</Title><Releaseyear>1994</Releaseyear><Runningtime>142m</Runningtime><Rating>8.8</Rating><Genre>Drama</Genre></Data><Data><Title>Oppenheimer</Title><Releaseyear>2023</Releaseyear><Runningtime>180m</Runningtime><Rating>8.5</Rating><Genre>Biography</Genre></Data></Table>");
        
        fileReader3.close();
        System.out.println("------------------------------------------");
       
    }
}