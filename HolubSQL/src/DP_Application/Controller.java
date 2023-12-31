package DP_Application;

import java.io.IOException;
import java.util.Scanner;

import com.holub.text.ParseFailure;

public class Controller {
	static ControllerVideo controllerVideo;
	static ControllerChannel controllerChannel;
	static Controller3 controller3;
	private channel user;
	private static Controller uniqueInstance = new Controller(); 
	
	private Controller() {
		controllerVideo=ControllerVideo.getInstance();
		controllerChannel=ControllerChannel.getInstance();
		controller3=Controller3.getInstance();
		
	}
	
	public static Controller getInstance() {
		return uniqueInstance;
	}
	public void setUser(channel user) {
		this.user=user;
		controllerVideo.setUser(user);
		controllerChannel.setUser(user);
		controller3.setUser(user);
	}

	public void run() throws IOException, ParseFailure {
		Scanner sc = new Scanner(System.in);
				
		char input;
		while(true) {
		
			print_menu();
			input=sc.next().charAt(0);
			
			if(input==48)
				break;
			if(input>=49&&input<=51) 
				controllerVideo.run(input);
			else if(input==52)
				controllerChannel.run();
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
