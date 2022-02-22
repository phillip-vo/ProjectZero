package com.revature.util;

import com.revature.dao.*;
import com.revature.model.Race;
import com.revature.model.Runner;
import com.revature.model.RunnerLogin;

import java.sql.SQLException;
import java.util.Scanner;

public class Initialize {

    private String username;
    private String password;

    private Scanner input = new Scanner(System.in);

    private RunnerLoginDAO runnerLoginDAO = new RunnerLoginDAOImpl();
    private RunnerDAO runnerDAO = new RunnerDAOImpl();
    private RaceDAO raceDAO = new RaceDAOImpl();

    private RunnerLogin runnerLogin;
    private Runner runner;
    private Race race;

    public Initialize() throws SQLException {
    }


    /*
    printMenu Method:
    Display menu options in console
     */
    public void printStartMenu() {
        System.out.println("|   MENU SELECTION DEMO        |");
        System.out.println("|   Options:                   |");
        System.out.println("|   1. Login                   |");
        System.out.println("|   2. Create New Account      |");
        System.out.println("|   3. Find a Race             |");
        System.out.println("|   4. Exit                    |");
        System.out.println("Select an option:");
    }

    /*
    getUserInput Method:
    Get input from user
     */
    public int getUserInput() {

        String userInputString = input.nextLine();
        int userInputInt = Integer.parseInt(userInputString);

        return userInputInt;
    }

    /*
    login Method:
    Get username and password
     */
    public void login() throws SQLException {

        System.out.println("Login to existing account:");

        System.out.println("- Enter username: ");
        username = input.nextLine();

        System.out.println("- Enter password: ");
        password = input.nextLine();

        System.out.println("Processing request...");
    }

    /*
    validateLogin Method:
    Check to see if login credentials are valid
     */
    public void validateLogin() throws SQLException {

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
    }

    public void createAccount() throws SQLException {

        try {
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
            } else {
                System.out.println("Cannot create account");
            }

        } catch (SQLException e) {
            System.out.println("Username unavailable.");
        }
    }

    public void createProfile() throws SQLException {

        System.out.println("Next steps");
        System.out.println("Fill out profile information:");

        System.out.println("- Enter your first name:");
        String firstName = input.nextLine();

        System.out.println("- Enter your last name:");
        String lastName = input.nextLine();

        System.out.println("- Enter your gender (m - male, f - female):");
        String gender = input.nextLine();

        System.out.println("- Enter your age:");
        String stringAge = input.nextLine();
        int age = Integer.parseInt(stringAge);

        System.out.println("Saving information...");

        runner = new Runner(firstName, lastName, gender, age);

        int result = runnerDAO.insert(runner);


        if (result == 1) {
            System.out.println("Profile complete");
        } else {
            System.out.println("Profile not saved, an error occurred");
        }

        linkAccount(firstName, lastName);
    }

    public int linkAccount(String firstName, String lastName) throws SQLException {
        int runnerId = 0;
        ArrayList<Runner> allRunners = runnerDAO.getAll();
        for (int i = 0; i < allRunners.size(); i++) {
            runner = (Runner) allRunners.get(i);
            if (firstName.equals(runner.getFirstName()) && lastName.equals(runner.getLastName())) {
                runnerId = runner.getRunnerId();
            }
        }

        int result = runnerLoginDAO.updateId(username, runnerId);

        return result;
    }

    public void displayRaces() throws SQLException {
        System.out.println("Processing request...");

        ArrayList<Race> allRaces = raceDAO.getAll();

        for (int i = 0; i < allRaces.size(); i++) {
            System.out.println(allRaces.get(i));
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
