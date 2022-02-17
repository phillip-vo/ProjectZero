package com.revature.driver;

import com.revature.model.Race;
import com.revature.model.Runner;
import com.revature.util.ArrayList;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class Driver {

    public static Connection conn = ConnectionUtil.getConnection();

    public static void main(String[] args) throws SQLException {

        /*
        // Testing classes and ArrayList
        ArrayList<Runner> runners = new ArrayList<Runner>();
        Runner r1 = new Runner("phil", 1);
        Runner r2 = new Runner("vincent", 2);
        runners.add(r1);
        runners.add(r2);
        System.out.println(runners.toString());

        ArrayList<Race> races = new ArrayList<Race>();
        Race race1 = new Race("Holiday Classic 5k", 1, "5k");
        Race race2 = new Race("Dallas Half Marathon", 2, "half-marathon");
        races.add(race1);
        races.add(race2);
        System.out.println(races.toString());
        */

    }
}
