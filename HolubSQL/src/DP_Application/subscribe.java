package DP_Application;

import java.io.IOException;

import com.holub.database.Table;
import com.holub.database.TableFactory;

public class subscribe {

	public Table Subcribe;
	
	public subscribe() throws IOException {

		Subcribe=TableFactory.load("Subcribe.csv","C:/DP2023");
	}
}
