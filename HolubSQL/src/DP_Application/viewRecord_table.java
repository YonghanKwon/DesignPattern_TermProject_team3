package DP_Application;

import java.io.IOException;
import java.util.Observable;

import com.holub.database.Database;
import com.holub.database.Table;
import com.holub.text.ParseFailure;

public class viewRecord_table extends Observable {
    
	private Table result;
	private channel user;
	public viewRecord_table(channel user) throws IOException{
		this.user = user;
	}
    public void makeTable() throws IOException, ParseFailure {
		Database db = new Database("C:/dp2023");
		String query = "select * from ViewRecord where viewer = \""+ user.getName()+"\"";
		result = db.execute(query);
		setChanged();
		notifyObservers();
	}
	public Table getResultTable() {
		return result;
	}
}
