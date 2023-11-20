package com.holub.database;

import java.io.*;
import java.util.*;

public class XMLExporter implements Table.Exporter {
	private final Writer out;
	private String tableName;
	private int width;
	private int height;
	private String[] colNames;
	
	XMLExporter(Writer out){
		this.out=out;
	}

	@Override
	public void startTable() throws IOException {
		// TODO Auto-generated method stub
		out.write("<?xml  version=\"1.0\"  encoding=\"UTF-8\" ?>");
		out.write("<Table>");
	}

	@Override
	public void storeMetadata(String tableName, int width, int height, Iterator columnNames) throws IOException {
		// TODO Auto-generated method stub
		this.tableName=tableName;
		this.width=width;
		this.height=height;
		colNames=new String[width];
		out.write("<TableName>"+tableName+"</TableName>");
		int idx=0;
		while(columnNames.hasNext()) {
			colNames[idx++]=columnNames.next().toString();
		}
	}

	@Override
	public void storeRow(Iterator data) throws IOException {
		int idx=0;
		out.write("<Data>");
		while(data.hasNext()) {
			Object datum = data.next();
			out.write("<"+colNames[idx]+">"+datum.toString()+"</"+colNames[idx]+">");
			idx++;
		}

		out.write("</Data>");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endTable() throws IOException {
		// TODO Auto-generated method stub
		out.write("</Table>");
	}
}
