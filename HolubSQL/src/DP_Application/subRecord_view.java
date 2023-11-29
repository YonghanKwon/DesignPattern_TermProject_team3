package DP_Application;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class subRecord_view implements Observer {
    private subRecord_table model;
	private channel user;
	
	public subRecord_view(channel user, subRecord_table model) {
		this.user = user;
		this.model = model;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(model.getResultTable() + "\nEnter channel name to register membership: ");
        Scanner sc = new Scanner(System.in);
        String channel = sc.next();
        String[] tmp = model.getResultTable().toString().split("\n");
        for(int i = 3; i < tmp.length; i++) {
            if(tmp[i].equals(channel)) {
                //mediate(tmp[i], channel);
            }
        }
	}
}
