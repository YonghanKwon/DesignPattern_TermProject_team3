package com.holub.database;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class OrderVisitor implements Visitor {
    private LinkedHashMap<String, Boolean> order;
	public OrderVisitor(LinkedHashMap<String, Boolean> order) {
		this.order = order;
	}
    
    @Override
    public Table visit(ConcreteTable table) {
        Table res = TableFactory.create(table.gettableName(), table.getcolumnNames());
        LinkedList row = table.getrowSet();

        row.sort((row1, row2) -> {
            for(String key : order.keySet()) {
                int idx = table.indexOf(key);
                if (Double.parseDouble(((Object[]) row1)[idx].toString()) > Double.parseDouble(((Object[]) row2)[idx].toString())) {
                    return order.get(key) ? 1 : -1;
                } else {
                    return order.get(key) ? -1 : 1;
                }
            }
            return 0;
        });

        return table;
    }
    
	@Override
	public Table visit(UnmodifiableTable table) {
		return table.extract();
	}
}
