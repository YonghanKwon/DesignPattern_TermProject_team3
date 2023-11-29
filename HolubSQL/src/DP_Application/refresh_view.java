package DP_Application;

import java.util.Observable;
import java.util.Observer;

import com.holub.database.*;

public class refresh_view implements Observer {
	private Controller1 controller1 = Controller1.getInstance();
	private refreshed_table model;
	private channel user;
	
	public refresh_view(channel user,refreshed_table model){
		this.user=user;
		this.model=model;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(model.getResultTable());
		
		
	}


}