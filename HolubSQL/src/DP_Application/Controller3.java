package DP_Application;

public class Controller3 {
	private static Controller3 uniqueInstance = new Controller3(); 
	
	private Controller3() {}
	channel user;
	
	public static Controller3 getInstance() {
		return uniqueInstance;
	}
	public void setUser(channel user) {
		this.user=user;
	}
	public void run() {
		System.out.println("add alarm list");
		
		System.out.println("Membership");
	}
}

/*
public void alarm() {
	
}
public void regist_Membership() {
	
}
*/