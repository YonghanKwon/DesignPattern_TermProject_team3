package com.holub.database;

import java.io.*;
import java.util.*;

public class HTMLExporter  implements Table.Exporter{
	private final Writer out;
	public HTMLExporter(Writer out)
	{
		this.out=out;
	}

	public void storeMetadata( String tableName,
						   int width,
						   int height,
						   Iterator columnNames ) throws IOException

	{
		out.write(tableName == null ? "<anonymous>" : tableName +"</h2>\n");
	
		out.write("<table>\n");
		storeRow( columnNames );
	
	}
	
	public void storeRow( Iterator data ) throws IOException
	{
		out.write("<tr>\n");
		while(data.hasNext()) {
			Object datum = data.next();
			if(datum != null)
				out.write("<td>"+datum.toString()+"</td>\n");
			
		}
		out.write("</tr>\n");
	}

	public void startTable() throws IOException {
		out.write("<h2>");
	/*nothing to do*/}
	public void endTable()   throws IOException {
	/*nothing to do*/}
}
