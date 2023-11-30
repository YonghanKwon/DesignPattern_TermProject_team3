package DP_Application;

import java.io.IOException;

import com.holub.database.Table;
import com.holub.text.ParseFailure;

public interface State {
    public void watch(channel channel, Table video) throws IOException, ParseFailure;
}
