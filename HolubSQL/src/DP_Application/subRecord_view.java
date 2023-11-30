package DP_Application;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.io.IOException;
import com.holub.text.ParseFailure;

public class subRecord_view implements Observer {
    private subRecord_table model;
	private channel user;
	
	public subRecord_view(channel user, subRecord_table model) {
		this.user = user;
		this.model = model;
	}
    public void getMembership() throws IOException, ParseFailure {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter channel name to register membership: ");
        String channel = sc.next();
        user.mediate(channel);
    }

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(model.getResultTable());
	}
}
