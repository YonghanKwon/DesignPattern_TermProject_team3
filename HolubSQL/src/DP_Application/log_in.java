package DP_Application;

import java.io.IOException;
import java.util.Scanner;

import com.holub.text.ParseFailure;

public class log_in {
	Membership membership = new Membership();
	public channel user;
	static Controller controller;
	public log_in(String name) throws IOException, ParseFailure {
		this.user = new channel(membership, name);
		controller = Controller.getInstance();
		controller.setUser(user);
		
	}
	public static void main(String[] args) throws IOException, ParseFailure {
		System.out.println("Enter name:");
		Scanner sc = new Scanner(System.in);
		String name;
		name=sc.next();
		log_in logIn = new log_in(name);
		System.out.println("Welcome! "+name);
		controller.run();
	}

}
