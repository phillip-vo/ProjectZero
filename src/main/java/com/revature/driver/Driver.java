package com.revature.driver;

import com.revature.dao.RaceDAO;
import com.revature.dao.RunnerDAO;
import com.revature.model.Race;
import com.revature.model.Runner;
import com.revature.util.ArrayList;
import com.revature.util.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {

    public static void main(String[] args) throws SQLException {

        Connection conn = Database.getConnection();
        conn.close();
        /*
        ConnectionUtil conn = new ConnectionUtil();

        RunnerDAO runnerDao = new RunnerDAO();
        runnerDao.setConn(conn.getConnection());
        try {
            ArrayList<Runner> allRunners = runnerDao.getAllRunners();
            for(int i = 0; i < allRunners.size(); i++) {
                System.out.println(allRunners.get(i));
            }
            //System.out.println(allRunners.size());
        } catch(SQLException e) {
            e.printStackTrace();
        }

        RaceDAO raceDao = new RaceDAO();
        raceDao.setConn(conn.getConnection());
        try {
            ArrayList<Race> allRaces = raceDao.getAllRaces();
            for(int i = 0; i < allRaces.size(); i++) {
                System.out.println(allRaces.get(i));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        */



        /*
        // Testing classes and ArrayList
        ArrayList<Runner> runners = new ArrayList<Runner>();
        Runner r1 = new Runner(1, "leonard", "kawhi", "m", 30);
        Runner r2 = new Runner(2, "paul", "chris", "m", 36);
        runners.add(r1);
        runners.add(r2);
        System.out.println(runners.get(0).toString());
        System.out.println(runners.size());

        /*
        ArrayList<Race> races = new ArrayList<Race>();
        Race race1 = new Race("Holiday Classic 5k", 1, "5k");
        Race race2 = new Race("Dallas Half Marathon", 2, "half-marathon");
        races.add(race1);
        races.add(race2);
        System.out.println(races.toString());
        */

    }
}
