package com.holub.database;

import com.holub.tools.ArrayIterator;
//for xml parsing
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.*;
import java.util.*;

public class XMLImporter implements Table.Importer{
	private BufferedReader  in;			// null once end-of-file reached
	private String[]        columnNames;
	private String          tableName;
	private Document 		document;
	private int 		idx=0;
	public XMLImporter( Reader in )
	{	this.in = in instanceof BufferedReader
						? (BufferedReader)in
                        : new BufferedReader(in)
	                    ;
	}

	@Override
	public void startTable() throws IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			try {
				document = builder.parse(new InputSource(new BufferedReader(in)));
				document.getDocumentElement().normalize();
				
				NodeList TagList=document.getElementsByTagName("TableName");
				tableName = TagList.item(0).getTextContent();
				
				TagList=document.getElementsByTagName("Data");
				NodeList childNodes=TagList.item(idx).getChildNodes();
				
				columnNames=new String[childNodes.getLength()];

				for(int i=0;i<childNodes.getLength();i++) {
					columnNames[i]=childNodes.item(i).getNodeName();
	
				}
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String loadTableName()		throws IOException
	{	return tableName;
	}
	public int loadWidth()			    throws IOException
	{	return columnNames.length;
	}
	public Iterator loadColumnNames()	throws IOException
	{	return new ArrayIterator(columnNames);  
	}

	@Override
	public Iterator loadRow() throws IOException {	//한줄씩 출력시켜주는듯
		
		NodeList TagList=document.getElementsByTagName("Data");
		
		if(idx>=TagList.getLength())
			return null;
		
		NodeList childNodes=TagList.item(idx).getChildNodes();


		ArrayList<String> data=new ArrayList();
		

		for(int i=0;i<childNodes.getLength();i++) {
			data.add(childNodes.item(i).getTextContent());			
		}
		idx++;

		Iterator<String> result=data.iterator();
		return result;
		
	}

	@Override
	public void endTable() throws IOException {}
}
