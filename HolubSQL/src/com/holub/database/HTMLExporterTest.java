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
        assertEquals(stringBuffer.toString(),"<h2>people</h2>\n<table>\n<tr>\n<td>Last</td>\n<td>First</td>\n<td>Id</td>\n</tr>\n" +
                "<tr>\n<td>Allen</td>\n<td>Holub</td>\n<td>1</td>\n</tr>\n<tr>\n<td>Ichabod</td>\n<td>Crane</td>\n<td>2</td>\n</tr>\n<tr>\n<td>Rip</td>\n<td>VanWinkle</td>\n<td>3</td>\n</tr>\n<tr>\n<td>Goldie</td>\n<td>Locks</td>\n<td>4</td>\n</tr>\n");

        fileReader.close();

        System.out.println("-------------------------------------------");

        Table bloodstorage = TableFactory.create("bloodstorage",
                new String[]{"Id", "Name", "Bloodtype", "Age", "Gender"});
        bloodstorage.insert(new String[]{"1", "Allen", "A", "20", "F"});
        bloodstorage.insert(new String[]{"2", "Troy", "B", "25", "M"});
        bloodstorage.insert(new String[]{"3", "Kevin", "AB", "40", "M"});
        bloodstorage.insert(new String[]{"4", "Goldie", "O", "30", "F"});
        bloodstorage.insert(new String[]{"5", "Chunsik", "B", "31", "M"});
        bloodstorage.insert(new String[]{"6", "Bob", "A", "27", "M"});
        Writer out1 = new FileWriter("c:/dp2023/bloodstorage");
        HTMLExporter builder2 = new HTMLExporter(out1);
        bloodstorage.export(builder2);
        out1.close();
        File file2 = new File("c:/dp2023/bloodstorage");
        StringBuffer stringBuffer2 = new StringBuffer();
        FileReader fileReader2 = new FileReader(file2);
        int index2 = 0;
        while ((index2 = fileReader2.read()) != -1) {
            stringBuffer2.append((char) index2);

        }
//        HTMLExporter테스트
        assertEquals(stringBuffer2.toString(), "<h2>bloodstorage</h2>\n<table>\n<tr>\n<td>Id</td>\n<td>Name</td>\n<td>Bloodtype</td>\n<td>Age</td>\n<td>Gender</td>\n</tr>\n" + "<tr>\n<td>1</td>\n<td>Allen</td>\n<td>A</td>\n<td>20</td>\n<td>F</td>\n</tr>\n<tr>\n<td>2</td>\n<td>Troy</td>\n<td>B</td>\n<td>25</td>\n<td>M</td>\n</tr>\n<tr>\n<td>3</td>\n<td>Kevin</td>\n<td>AB</td>\n<td>40</td>\n<td>M</td>\n</tr>\n<tr>\n<td>4</td>\n<td>Goldie</td>\n<td>O</td>\n<td>30</td>\n<td>F</td>\n</tr>\n<tr>\n<td>5</td>\n<td>Chunsik</td>\n<td>B</td>\n<td>31</td>\n<td>M</td>\n</tr>\n<tr>\n<td>6</td>\n<td>Bob</td>\n<td>A</td>\n<td>27</td>\n<td>M</td>\n</tr>\n");
        
        fileReader2.close();
        
        System.out.println("-------------------------------------------------");
       
        Table movie = TableFactory.create("movie",
                new String[]{"Title", "Releaseyear", "Runningtime", "Rating", "Genre"});
        movie.insert(new String[]{"The Shawshank Redemption", "1994", "142m", "9.3", "Drama"});
        movie.insert(new String[]{"The Godfather", "1972", "175m", "9.2", "Crime"});
        movie.insert(new String[]{"The Dark Knight", "2008", "152m", "9.0", "Action"});
        movie.insert(new String[]{"Forrest Gump", "1994", "142m", "8.8", "Drama"});
        movie.insert(new String[]{"Oppenheimer", "2023", "180", "8.5", "Biography"});
        Writer out2 = new FileWriter("c:/dp2023/movie");
        HTMLExporter builder3 = new HTMLExporter(out2);
        movie.export(builder3);
        out2.close();
        File file3 = new File("c:/dp2023/movie");
        StringBuffer stringBuffer3 = new StringBuffer();
        FileReader fileReader3 = new FileReader(file3);
        int index3 = 0;
        while ((index3 = fileReader3.read()) != -1) {
            stringBuffer3.append((char) index3);

        }
//        HTMLExporter테스트
        assertEquals(stringBuffer3.toString(), "<h2>movie</h2>\n<table>\n<tr>\n<td>Title</td>\n<td>Releaseyear</td>\n<td>Runningtime</td>\n<td>Rating</td>\n<td>Genre</td>\n</tr>\n" + "<tr>\n<td>The Shawshank Redemption</td>\n<td>1994</td>\n<td>142m</td>\n<td>9.3</td>\n<td>Drama</td>\n</tr>\n<tr>\n<td>The Godfather</td>\n<td>1972</td>\n<td>175m</td>\n<td>9.2</td>\n<td>Crime</td>\n</tr>\n<tr>\n<td>The Dark Knight</td>\n<td>2008</td>\n<td>152m</td>\n<td>9.0</td>\n<td>Action</td>\n</tr>\n<tr>\n<td>Forrest Gump</td>\n<td>1994</td>\n<td>142m</td>\n<td>8.8</td>\n<td>Drama</td>\n</tr>\n<tr>\n<td>Oppenheimer</td>\n<td>2023</td>\n<td>180</td>\n<td>8.5</td>\n<td>Biography</td>\n</tr>\n");
        
        fileReader3.close();
        
        System.out.println("-------------------------------------------------");
    }
}