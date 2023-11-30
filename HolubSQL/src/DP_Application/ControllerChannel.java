package DP_Application;

import java.io.IOException;

import com.holub.text.ParseFailure;

public class ControllerChannel {
	private static ControllerChannel uniqueInstance = new ControllerChannel(); 
	private subRecord_view subRecord_view;
	private subRecord_table subRecord_table;

	private ControllerChannel() {}
	channel user;
	
	public static ControllerChannel getInstance() {
		return uniqueInstance;
	}
	public void setUser(channel user) {
		this.user=user;
	}
	public void init() throws IOException {
		subRecord_table = new subRecord_table(user);
		subRecord_view = new subRecord_view(user, subRecord_table);
		subRecord_table.addObserver(subRecord_view);
	}
	public void run() throws IOException, ParseFailure {
		init();
		subRecord_table.makeTable();
		subRecord_view.getMembership();
	}
}
/*
public subscribe() {

}
public print_subscribe() {
	
}
*/