package com.holub.database;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;

public class AggregateVisitor implements Visitor {
	private LinkedHashMap<String, Boolean> aggregateFunc;
	private List<String> alias;
	public AggregateVisitor(LinkedHashMap<String, Boolean> aggregateFunc, List<String> alias) {
		this.aggregateFunc = aggregateFunc;
		this.alias = alias;
	}
    @Override
    public Table visit(ConcreteTable table) {
		int idx;
    	List<Double> tmp_res = new ArrayList<>();
		for(String s : aggregateFunc.keySet()) {
			if (s.toUpperCase().equals("MAX")) {
				tmp_res.add(Double.MIN_VALUE);
			}
			if (s.toUpperCase().equals("MIN")) {
				tmp_res.add(Double.MAX_VALUE);
			}
			if (s.toUpperCase().equals("AVG") || s.toUpperCase().equals("SUM") || s.toUpperCase().equals("COUNT")) {
				tmp_res.add(0.0);
			}
		}
		Table res = TableFactory.create(table.gettableName(), alias.toArray(new String[alias.size()]));
    	
		HashSet<String> unique = new HashSet<>();
    	ListIterator start = table.getrowSet().listIterator();
    	Iterator iter = start;
    	while(iter.hasNext()) {
    		Object row = iter.next();
			StringBuilder key = new StringBuilder();
			for (Object column : (Object[]) row) {
				key.append(column + " ");
			}
			
			String[] row_tmp = key.toString().split(" ");
			idx = 0;
			for(String s : aggregateFunc.keySet()) {
				if(!(aggregateFunc.get(s) && unique.contains(row_tmp[idx]))) {
					if(aggregateFunc.get(s) && !unique.contains(row_tmp[idx])) {
						unique.add(row_tmp[idx]);
					}
					if (s.toUpperCase().equals("MAX")) {
						tmp_res.set(idx, tmp_res.get(idx) > Double.parseDouble(row_tmp[idx]) ? tmp_res.get(idx) : Double.parseDouble(row_tmp[idx]));
					}
					if (s.toUpperCase().equals("MIN")) {
						tmp_res.set(idx, tmp_res.get(idx) < Double.parseDouble(row_tmp[idx]) ? tmp_res.get(idx) : Double.parseDouble(row_tmp[idx]));
					}
					if (s.toUpperCase().equals("AVG") || s.toUpperCase().equals("SUM")) {
						tmp_res.set(idx, tmp_res.get(idx) + Double.parseDouble(row_tmp[idx]));
					}
					if (s.toUpperCase().equals("COUNT")) {
						tmp_res.set(idx, tmp_res.get(idx) + 1);
					}
				}
				idx++;
			}
    	}
		idx = 0;
		for(String s : aggregateFunc.keySet()) {
			if (s.toUpperCase().equals("AVG")) {
				tmp_res.set(idx, tmp_res.get(idx) / table.getrowSet().size());
			}
			idx++;
		}

		String[] cols = new String[aggregateFunc.size()];
    	for(int i = 0; i < aggregateFunc.size(); i++) {
    		cols[i] = String.format("%.2f", tmp_res.get(i));
    	}
    	res.insert(cols);
    	
    	return res;
    }
	@Override
	public Table visit(UnmodifiableTable table) {
		return table.extract();
	}
}