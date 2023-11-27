package com.holub.database;

public class AggregateFunction {
	private String functionName;
    private String columnName;
    
    public AggregateFunction(String functionName, String columnName) {
    	this.functionName = functionName;
    	this.columnName = columnName;
    }
    public String getFunctionName() {
    	return functionName;
    }
    public String getColumnName() {
    	return columnName;
    }
}
