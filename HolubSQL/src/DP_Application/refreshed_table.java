package DP_Application;

import java.util.Observable;

import com.holub.database.*;

public class refreshed_table extends Observable{
	private Table result;
	private channel user;
	public refreshed_table(channel user){
		this.user=user;
	}
	public void  makeTable() {
		
		Database db=new Database();
		String query = "select  from video, subcribe where video.publisher=subcribe.publisher, subcribe.subcriber = "+ user.getName();
		setChanged();
		notifyObservers();
	}
	
}
