package DP_Application;

import java.util.Scanner;

public class Controller {
	static Controller1 controller1;
	static Controller2 controller2;
	static Controller3 controller3;
	channel user;
	private static Controller uniqueInstance = new Controller(); 
	
	private Controller() {
		controller1=Controller1.getInstance();
		controller2=Controller2.getInstance();
		controller3=Controller3.getInstance();
		
	}
	
	public static Controller getInstance() {
		return uniqueInstance;
	}
	public void setUser(channel user) {
		this.user=user;
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		
		char input;
		while(true) {
		
			print_menu();
			input=sc.next().charAt(0);
			
			if(input==48)
				break;
			if(input>=49&&input<=51) 
				controller1.run(input);
			else if(input==51)
				controller2.run();
			else controller3.run();
		}
	}
	public static void print_menu() {
		System.out.println("0. end program");
		System.out.println("1. home");
		System.out.println("2. view record");
		System.out.println("3. upload video");
		System.out.println("4. watch subscribe list");
		
	}
}
