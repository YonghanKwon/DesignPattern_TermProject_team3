package com.holub.database;

import java.util.Iterator;
import java.util.Arrays;

import com.holub.tools.ArrayIterator;

public class DistinctVisitor implements Visitor {

	@Override
	public Table visit(ConcreteTable table) {

		Table res = TableFactory.create(table.gettableName(), table.getcolumnNames());

		String[] colName = table.getcolumnNames();
		String[] temp_arr = new String[colName.length];
		String[][] Data = new String[table.getrowSet().size()][colName.length];
		int count = 0;
		boolean flag = true;
		int idx = 0;
		for (Iterator i = table.getrowSet().iterator(); i.hasNext();) {
			Iterator rows = new ArrayIterator((Object[]) i.next());
			while (rows.hasNext()) {
				for (int j = 0; j < colName.length; j++) {
					temp_arr[j] = rows.next().toString();
				}

					for(int k=0;k<idx;k++) {
						if(Arrays.deepEquals(temp_arr,Data[k])) {
							flag=false;							
							break;
						}
						else {
							flag=true;
						}					
					}
			
				if(flag)
				{	
					for(int j=0;j<colName.length;j++) {
						Data[idx][j]=temp_arr[j];
					}
					res.insert(temp_arr);
					idx++;
				}
			}
			count++;
		}

		return res;
	}

	public Table visit(UnmodifiableTable table) {
		return table.extract();
	}
}