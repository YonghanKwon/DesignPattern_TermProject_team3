package DP_Application;

public class Controller2 {
	private static Controller2 uniqueInstance = new Controller2(); 
	
	private Controller2() {}
	channel user;
	
	public static Controller2 getInstance() {
		return uniqueInstance;
	}
	public void setUser(channel user) {
		this.user=user;
	}
	public void run() {
		System.out.println("do subscribe");
		System.out.println("watch subscribe record");
		
	}
}
/*
public subscribe() {

}
public print_subscribe() {
	
}
*/