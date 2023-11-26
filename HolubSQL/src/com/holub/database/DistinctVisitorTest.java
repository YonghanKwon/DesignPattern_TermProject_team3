package com.holub.database;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class DistinctVisitorTest {
	Table peopletemp=TableFactory.create("people",new String[]{"Last", "First", "Id"});

	@Test
	void testVisitConcreteTable() throws IOException {
		
        peopletemp.insert(new String[]{"Allen", "Holub", "1"});
        peopletemp.insert(new String[]{"Ichabod", "Crane", "2"});
        peopletemp.insert(new String[]{"Rip", "VanWinkle", "3"});
        peopletemp.insert(new String[]{"Goldie", "Locks", "4"});
        peopletemp.insert(new String[]{"Allen", "Holub", "1"});
        peopletemp.insert(new String[]{"Ichabod", "Crane", "2"});
        
        peopletemp=peopletemp.accept(new DistinctVisitor());
        Writer out = new FileWriter("c:/dp2023/peopletemp.html");
        HTMLExporter builder = new HTMLExporter(out);
        peopletemp.export(builder);
        out.close();
        File file = new File("c:/dp2023/peopletemp.html");
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
        System.out.println("------------------------------------------");

	}

}
