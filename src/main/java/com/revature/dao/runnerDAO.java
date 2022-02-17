package com.revature.dao;

import com.revature.model.Runner;
import com.revature.util.ArrayList;

import java.sql.SQLException;
import java.sql.Statement;

import static com.revature.driver.Driver.conn;

public class runnerDAO {

    public ArrayList<Runner> getAllRunner() throws SQLException {
        ArrayList<Runner> allRunners = new ArrayList<Runner>();

        Statement statement = conn.createStatement();


    }


}
