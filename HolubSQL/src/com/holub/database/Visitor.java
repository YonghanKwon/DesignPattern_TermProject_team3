package com.holub.database;

public interface Visitor {
	Table visit(ConcreteTable table);
	Table visit(UnmodifiableTable table);
}