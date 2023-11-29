package DP_Application;

import java.io.IOException;
import java.util.Scanner;

import com.holub.database.*;

public class log_in {
	public channel user;
	public Database db;
	static Controller controller;
	public log_in(String name) throws IOException {
		this.user=new channel(name);
		controller=Controller.getInstance();
		controller.setUser(user);

		//이름 겹치는지 확인하고 겹치면 db에 추가
			
		
	}
	public static void main(String[] args) throws IOException {
		System.out.println("Enter name:");
		Scanner sc = new Scanner(System.in);
		String name;
		name=sc.next();
		log_in logIn = new log_in(name);
		System.out.println("Welcome! "+name);
		controller.run();
	}

}
