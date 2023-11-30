package DP_Application;

import java.util.Observable;
import java.util.Observer;

public class refresh_view implements Observer {
	private refreshed_table model;
	
	public refresh_view(refreshed_table model) {
		this.model=model;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(model.getResultTable());
	}
}