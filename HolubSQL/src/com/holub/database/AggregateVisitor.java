package com.holub.database;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.holub.tools.ArrayIterator;

public class AggregateVisitor implements Visitor {
	private List<String> aggregateFunc, alias;
	public AggregateVisitor(List<String> aggregateFunc, List<String> alias) {
		this.aggregateFunc = aggregateFunc;
		this.alias = alias;
	}
    @Override
    public Table visit(ConcreteTable table) {
    	double[] tmp_res = new double[aggregateFunc.size()];
		for(int i = 0; i < aggregateFunc.size(); i++) {
			if (aggregateFunc.get(i).toUpperCase().equals("MAX")) {
				tmp_res[i] = Double.MIN_VALUE;
			}
			if (aggregateFunc.get(i).toUpperCase().equals("MIN")) {
				tmp_res[i] = Double.MAX_VALUE;
			}
			if (aggregateFunc.get(i).toUpperCase().equals("AVG")) {
				tmp_res[i] = 0;
			}
		}
    	String[] cols = new String[aggregateFunc.size()];
		for(int i = 0; i < aggregateFunc.size(); i++) {
			cols[i] = alias.get(i);
		}
    	Table res = TableFactory.create(table.gettableName(), cols);
    	
    	ListIterator start = table.getrowSet().listIterator();
    	Iterator iter = start;
    	while(iter.hasNext()) {
    		Object row = iter.next();
			StringBuilder key = new StringBuilder();
			for (Object column : (Object[]) row) {
				key.append(column + " ");
			}
			String[] row_tmp = key.toString().split(" ");
			for (int i = 0; i < aggregateFunc.size(); i++) {
				if (aggregateFunc.get(i).toUpperCase().equals("MAX")) {
					tmp_res[i] = tmp_res[i] > Double.parseDouble(row_tmp[i]) ? tmp_res[i] : Double.parseDouble(row_tmp[i]);
				}
				if (aggregateFunc.get(i).toUpperCase().equals("MIN")) {
					tmp_res[i] = tmp_res[i] < Double.parseDouble(row_tmp[i]) ? tmp_res[i] : Double.parseDouble(row_tmp[i]);
				}
				if (aggregateFunc.get(i).toUpperCase().equals("AVG")) {
					tmp_res[i] += Double.parseDouble(row_tmp[i]);
				}
    		}
    	}
    	for(int i = 0; i < aggregateFunc.size(); i++) {
			if (aggregateFunc.get(i).toUpperCase().equals("AVG")) {
				tmp_res[i] /= table.getrowSet().size();
			}	
    	}
    	for(int i = 0; i < aggregateFunc.size(); i++) {
    		cols[i] = String.format("%.2f", tmp_res[i]);
    	}
    	res.insert(cols);
    	
    	return res;
    }
	@Override
	public Table visit(UnmodifiableTable table) {
		return table.extract();
	}
}