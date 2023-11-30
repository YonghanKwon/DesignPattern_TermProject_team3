package DP_Application;

import java.io.IOException;
import java.time.LocalDate;

import com.holub.database.Database;
import com.holub.text.ParseFailure;

public class Membership {
	String target;
	public Membership() {}
	public void setTarget(String target) {
		this.target = target;
	}
	public void mediate(String target, String ord) throws IOException, ParseFailure {
		Database db = new Database("C:/dp2023");
		String date = LocalDate.now().toString().replace("-", "");
		db.execute("insert into Membership values (\"" + ord + "\",\"" + target + "\",\"" + date + "\")");
		db.execute("dump");
	}
}
