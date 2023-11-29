package DP_Application;

import java.io.IOException;

import com.holub.database.Table;
import com.holub.database.TableFactory;

public class viewRecord {

	public Table viewRecord;
	public viewRecord() throws IOException {

		viewRecord=TableFactory.load("viewRecord.csv","C:/DP2023");
	}
}
