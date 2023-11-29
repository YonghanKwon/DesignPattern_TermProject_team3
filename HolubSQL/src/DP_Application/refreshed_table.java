package DP_Application;

import java.io.IOException;
import java.util.Iterator;
import java.util.Observable;
import java.util.Random;

import com.holub.database.*;
import com.holub.text.ParseFailure;
import com.holub.tools.ArrayIterator;

public class refreshed_table extends Observable{
	private Table result;
	private channel user;
	public refreshed_table(channel user) throws IOException{
		this.user=user;
	}
	public void makeTable() throws IOException, ParseFailure {
		Random random = new Random(); 
		Table result_video;
		Table result_vie_sub;
		int size_nonsub;
		Database db=new Database("C:/DP2023");
		String query = "select Distinct* from Video";
		result_video=db.execute(query);
		size_nonsub=(int)((ConcreteTable)result_video).getrowSet().size();
		result=TableFactory.create("refresh",((ConcreteTable)result_video).getcolumnNames());

		query = "select DISTINCT title, publisher, duration, count, classfication from Video, Subscribe where Video.publisher=Subscribe.publisher and Subscribe.subscriber = \""+ user.getName()+"\"";
		result_vie_sub=db.execute(query);
		int size_sub = (int)((ConcreteTable) result_vie_sub).getrowSet().size();
				
		String[] temp_arr=new String[((ConcreteTable)result_video).getcolumnNames().length];
		int count=0;
		boolean flag=true;
		while(flag) {
			if(count>=7 || count>=size_sub/2) {
				flag=false;
				break;
			}
			int temp=random.nextInt(size_sub);

			
			Iterator i=((ConcreteTable)result_video).getrowSet().iterator();

			
			while(i.hasNext() && temp >=0) {
				Iterator rows_sub = new ArrayIterator((Object[])i.next());
				
				int idx=0;
				while(temp==0&&rows_sub.hasNext()) {
					temp_arr[idx]=rows_sub.next().toString();
								
					idx++;
				}	
				temp--;
			}
			
			
			result.insert(temp_arr);
			result = result.accept(new DistinctVisitor());
			count++;
			if(((ConcreteTable)result).getrowSet().size() != count)
				count--;
			
		}
		flag=true;
		while(flag) {
			if(count==10) {
				flag=false;
				break;
			}
			int temp=random.nextInt(size_nonsub);

			
			Iterator i=((ConcreteTable)result_video).getrowSet().iterator(); //한줄 전체
			
			
			
			while(i.hasNext()&&temp>=0) {
				Iterator rows_nonsub=new ArrayIterator((Object[])i.next());
				
				int idx=0;
				while(temp==0 && rows_nonsub.hasNext()) {
					temp_arr[idx]=rows_nonsub.next().toString();
						
					idx++;
					}
				temp--;
			}
			
			result.insert(temp_arr);
			result = result.accept(new DistinctVisitor());
			count++;
			if(((ConcreteTable)result).getrowSet().size() != count)
				count--;
		}
		setChanged();
		notifyObservers();
	}
	public Table getResultTable() {
		return result;
	}
}
