package DP_Application;

import java.io.IOException;

import com.holub.database.Table;
import com.holub.database.TableFactory;

public class Membership {

	public Table Membership;
	
	public Membership() throws IOException {

		Membership=TableFactory.load("Membership.csv","C:/DP2023");
	}
}
