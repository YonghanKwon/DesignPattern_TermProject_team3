package DP_Application;

import java.io.IOException;
import java.util.Observable;
import java.util.Random;

import com.holub.database.*;
import com.holub.text.ParseFailure;

public class refreshed_table extends Observable{
	private Table result;
	private channel user;
	public refreshed_table(channel user) throws IOException{
		this.user=user;
	}
	public void makeTable() throws IOException, ParseFailure {
		Random random = new Random(); //난수 생성
		
		Database db=new Database("C:/DP2023");
		String query = "select DISTINCT title, publisher, duration, count, classfication from Video, Subscribe where Video.publisher=Subscribe.publisher and Subscribe.subscriber = \""+ user.getName()+"\"";
		result=db.execute(query);
		result.insert(new Object[]{"Software Engineer","lee","15:19","120","education"});
		int size = (int)((ConcreteTable) result).getrowSet().size();
		int size_nonsub=3;
		if(size<=14) {
			size_nonsub=10-size/2;
		}
		for(int i=0;i<10;i++)
		{
			random.nextInt(size);
			random.nextInt(size_nonsub);
		}
		setChanged();
		notifyObservers();
	}
	public Table getResultTable() {
		return result;
	}
}
