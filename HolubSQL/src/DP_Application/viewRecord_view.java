package DP_Application;

import java.util.Observable;
import java.util.Observer;

public class viewRecord_view implements Observer {
    private viewRecord_table model;
	
	public viewRecord_view(viewRecord_table model) {
		this.model = model;
	}
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(model.getResultTable());
	}
}
