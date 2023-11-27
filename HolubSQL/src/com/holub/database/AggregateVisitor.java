package com.holub.database;

import java.util.List;

public class AggregateVisitor implements Visitor {
	private List<String> aggregateColumns;
	public AggregateVisitor(List<String> aggregateColumns) {
		this.aggregateColumns = aggregateColumns;
	}
    @Override
    public Table visit(ConcreteTable table) {
        // Implementation for MAX function
    	return null;
    }
	@Override
	public Table visit(UnmodifiableTable table) {
		// TODO Auto-generated method stub
		return table.extract();
	}
}