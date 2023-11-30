package DP_Application;

import com.holub.database.Database;
import com.holub.database.Table;
import com.holub.text.ParseFailure;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class PremiumState implements State {
    @Override
    public void watch(channel channel, Table video) throws IOException, ParseFailure {
        String[] tmp_table = video.toString().split("\n");
        String[] vid = tmp_table[3].split("\\t");
        String[] time = vid[2].split(":");
        Scanner sc = new Scanner(System.in);
        int vidTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        for(int i = 0; i < vidTime; i += 10) {
            try {
                System.out.println(vid[0] + "is now streaming");
                Thread.sleep(50);
            } catch (Exception e) {}
        }
        char[] like = new char[2];
        while(true) {
            System.out.println("Do you like this video?(Y/N)?");
            like[0] = sc.next().toLowerCase().charAt(0);
            System.out.println("Do you like to subscribe this channel?(Y/N)?");
            like[1] = sc.next().toLowerCase().charAt(0);
            if((like[0] == 'y' || like[0] == 'n') && (like[1] == 'y' || like[1] == 'n')) {
                break;
            }
            System.out.println("Please input Y(y), N(n)\n");
        }
        
		Database db = new Database("C:/dp2023");
		String date = LocalDate.now().toString().replace("-", "");
		db.execute("insert into ViewRecord values (\"" + channel.getName() + "\",\"" + vid[0] + "\",\"" + date + "\",\"" + ((like[0] == 'y') ? "true" : "false") +"\")");
        if((like[1] == 'y')) {
            db.execute("insert into Subscribe values (\"" + channel.getName() + "\",\"" + vid[1] + "\",\"" + "false" +"\")");
        }
        int user_video_num = Integer.parseInt(vid[0]) + 1;
        db.execute("update Video set vid_num = \"" + user_video_num + "\" where name = \"" + vid[1] + "\"");
		db.execute("dump");
    }
}
