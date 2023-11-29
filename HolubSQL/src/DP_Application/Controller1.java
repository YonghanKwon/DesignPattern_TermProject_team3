package DP_Application;

import java.util.Scanner;

public class Controller1 {
	private static Controller1 uniqueInstance = new Controller1(); 
	
	private Controller1() {}
	channel user;
	
	public static Controller1 getInstance() {
		return uniqueInstance;
	}
	public void setUser(channel user) {
		this.user=user;
	}
	
	/*
	refresh_view refresh = new refresh_view();	//view
	refreshed_table refresh_model = new refreshed_table();
	refresh_model.addObserver(refresh);
	*/
	
	public void run(char state) {
		Scanner sc = new Scanner(System.in);
		char input;		
		if(state==49)
		{	input='r';
			while(input=='r') {
				System.out.println("refresh");
				if(input>=48 && input <=59)
					break;
				
				input=sc.next().charAt(0);
			}
			System.out.println("watch" + input );

		}
		else if(state==50) {
			System.out.println("watch record");

			}
		else if(state==51) {
			System.out.println("upload video");

			}
	}
}

/*
public void log_in() {
	
}
public void refresh() {
	
}
public void watch() {
	
}
public void print_viewRecord() {
	
}
public void video_upload() {
	
}
*/