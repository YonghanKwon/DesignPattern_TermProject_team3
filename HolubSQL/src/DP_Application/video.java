package DP_Application;

import java.io.IOException;

import com.holub.database.Table;
import com.holub.database.TableFactory;

public class video {
	public Table video;
	public String title;
	public video(String title) throws IOException {
		this.title=title;
		video=TableFactory.load("video.csv","C:/DP2023");
		
	}
}
