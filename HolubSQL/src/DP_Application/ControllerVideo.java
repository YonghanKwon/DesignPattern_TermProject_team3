package DP_Application;

import java.io.IOException;
import java.util.Scanner;

import com.holub.text.ParseFailure;

public class ControllerVideo {
	private static ControllerVideo uniqueInstance = new ControllerVideo(); 
	private refresh_view refresh_view;
	private refreshed_table refreshed_model;
	private ControllerVideo() {}
	private channel user;
	
	public static ControllerVideo getInstance() {
		return uniqueInstance;
	}
	public void setUser(channel user) {
		this.user=user;
	}
	public void init() throws IOException {
		refreshed_model=new refreshed_table(user);
		refresh_view=new refresh_view(user, refreshed_model);
		refreshed_model.addObserver(refresh_view);
		//refreshed_model.addObserver(new refresh_view(user, refreshed_model));
	}
		
	public void run(char state) throws IOException, ParseFailure {
		Scanner sc = new Scanner(System.in);
		char input;		
		if(state==49) {
			input='r';
			while(input=='r') {
				init();
				refreshed_model.makeTable();
				
				input=sc.next().charAt(0);
				if(input>=48 && input <=59) {
					user.watch(user, refreshed_model.getVideo(input - 48));
					// System.out.println("watch");
					break;
				}
			}

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