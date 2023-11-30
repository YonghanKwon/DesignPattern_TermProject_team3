package DP_Application;

import com.holub.database.Database;
import com.holub.database.Table;
import com.holub.text.ParseFailure;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class OrdinaryState implements State {
    @Override
    public void watch(channel channel, Table video) throws IOException, ParseFailure {
        String[] tmp_table = video.toString().split("\n");
        String[] vid = tmp_table[3].split("\\t");
        String[] time = vid[2].split(":");
        int vidTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        for(int i = 0; i < vidTime; i += 10) {
            try {
                if(i % 30 == 0) {
                    System.out.println("Add is playing");
                    Thread.sleep(150);
                }
                System.out.println(vid[0] + "is now streaming");
                Thread.sleep(50);
            } catch (Exception e) {}
        }
        char like;
        while(true) {
            System.out.println("Do you like this video?(Y/N)?");
            Scanner sc = new Scanner(System.in);
            like = sc.next().toLowerCase().charAt(0);
            if(like == 'y' || like == 'n') {
                break;
            }
            System.out.println("Please input Y(y), N(n)\n");
        }
        
		Database db = new Database("C:/DP2023");
		String date = LocalDate.now().toString().replace("-", "");
		db.execute("insert into ViewRecord values (\"" + channel.getName() + "\",\"" + vid[0] + "\",\"" + date + "\",\"" + ((like == 'y') ? "true" : "false") +"\")");
		db.execute("dump");
    }
}
