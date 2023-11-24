package com.holub.database;

public interface TableAccepter {
	Table accept(Visitor visitor);
}
