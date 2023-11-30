package DP_Application;

import java.io.IOException;
import java.util.Observable;

import com.holub.database.Database;
import com.holub.database.Table;
import com.holub.text.ParseFailure;

public class subRecord_table extends Observable {
    
	private Table result;
	private channel user;
	public subRecord_table(channel user) throws IOException{
		this.user = user;
	}
    public void makeTable() throws IOException, ParseFailure {
		Database db = new Database("C:/DP2023");
		String query = "select publisher from Subscribe where subscriber = \""+ user.getName()+"\"";
		result = db.execute(query);
		setChanged();
		notifyObservers();
	}
	public Table getResultTable() {
		return result;
	}
}
