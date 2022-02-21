package com.revature.driver;

import com.revature.dao.*;
import com.revature.model.Race;
import com.revature.model.Runner;
import com.revature.model.RunnerLogin;
import com.revature.util.ArrayList;
import com.revature.util.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws SQLException {

        RunnerLoginDAO runnerLoginDAO = new RunnerLoginDAOImpl();
        RunnerDAO runnerDAO = new RunnerDAOImpl();

        RunnerLogin runnerLogin;
        Runner runner;

        String userInput = "";
        int userInputInt = 0;

        String username = "";
        String password = "";

        Scanner input = new Scanner(System.in);

        System.out.println("|   MENU SELECTION DEMO   |");
        System.out.println("|   Options:              |");
        System.out.println("|   1. Login              |");
        System.out.println("|   2. Create New Account |");
        System.out.println("|   3. Exit               |");
        System.out.println("Select an option:");

        userInput = input.nextLine();
        userInputInt = Integer.parseInt(userInput);

        if (userInputInt == 1) {

            System.out.println("Login to existing account:");

            System.out.println("- Enter username: ");
            username = input.nextLine();

            System.out.println("- Enter password: ");
            password = input.nextLine();

            System.out.println("Processing request...");

            ArrayList<RunnerLogin> allRunnerLogins = runnerLoginDAO.getAll();

            if (allRunnerLogins.size() != 0) {

                boolean result = false;

                for (int i = 0; i < allRunnerLogins.size(); i++) {
                    runnerLogin = (RunnerLogin) allRunnerLogins.get(i);
                    if (username.equals(runnerLogin.getUsername()) && password.equals(runnerLogin.getPassword())) {
                        result = true;
                        break;
                    }
                }

                if (result) {
                    System.out.println("Login successful");
                } else {
                    System.out.println("Incorrect username or password");
                }
            } else {
                System.out.println("Table is empty, need to create a new account");
            }

        } else if (userInputInt == 2) {
            System.out.println("Create a new account:");

            System.out.println("- Enter a new username:");
            username = input.nextLine();

            System.out.println("- Enter a new password:");
            password = input.nextLine();

            System.out.println("Processing request...");

            runnerLogin = new RunnerLogin(username, password);

            int result = runnerLoginDAO.insert(runnerLogin);

            if (result == 1) {
                System.out.println("Creation successful");

                System.out.println("Next steps");
                System.out.println("Fill out profile information:");

                System.out.println("- Enter your first name:");
                String firstName = input.nextLine();

                System.out.println("- Enter your last name:");
                String lastName = input.nextLine();

                System.out.println("- Enter your gender (m - male, f - female, o - other):");
                String gender = input.nextLine();

                System.out.println("- Enter your age:");
                String stringAge = input.nextLine();
                int age = Integer.parseInt(stringAge);

                int login_id = 0;

                ArrayList<RunnerLogin> allRunnerLogins = runnerLoginDAO.getAll();
                ArrayList<Runner> allRunners = runnerDAO.getAll();

                // Need to fix: logging_id only insert 0 into db
                for (int i = 0; i < allRunners.size(); i++) {
                    runnerLogin = (RunnerLogin) allRunnerLogins.get(i);
                    if (username.equals(runnerLogin.getUsername()) && password.equals(runnerLogin.getPassword())) {
                        login_id = runnerLogin.getLoginId();
                        System.out.println(login_id);
                    }
                }

                System.out.println("Saving information...");

                runner = new Runner(firstName, lastName, gender, age, login_id);

                int runnerResult = runnerDAO.insert(runner);

                if (runnerResult == 1) {
                    System.out.println("Profile complete");
                } else {
                    System.out.println("Profile not saved, an error occurred");
                }

            } else {
                System.out.println("Cannot create account");
            }

        } else if (userInputInt == 3){
            System.out.println("Exiting system");
        } else {
            System.out.println("Invalid option, exiting system");
        }


        input.close();

/*
        ArrayList<RunnerLogin> allRunnerLogins = runnerLoginDAO.getAll();

        for (int i = 0; i < allRunnerLogins.size(); i++) {
            System.out.println(allRunnerLogins.get(i));
        }

        RunnerLogin runnerLogin2 = new RunnerLogin("winston", "dogbone");
        System.out.println("Username: " + runnerLogin2.getUsername());
        System.out.println("Password: " + runnerLogin2.getPassword());

        boolean result = false;

        for (int i = 0; i < allRunnerLogins.size(); i++) {
            RunnerLogin runnerLogin1 = (RunnerLogin) allRunnerLogins.get(i);

            if (runnerLogin2.getUsername().equals(runnerLogin1.getUsername()) && runnerLogin2.getPassword().equals(runnerLogin1.getPassword())) {
                result = true;
                break;
            }

        }

        if (result) {
            System.out.println("Account found");
        } else {
            System.out.println("Account does not exist");
        }
*/


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
