package com.revature.util;

import com.revature.dao.*;
import com.revature.driver.Driver;
import com.revature.model.Race;
import com.revature.model.RaceOrder;
import com.revature.model.Runner;
import com.revature.model.RunnerLogin;

import java.sql.SQLException;
import java.util.Scanner;

public class Initialize {

    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String gender;
    private int age;

    private int userInput;

    private Scanner input = new Scanner(System.in);

    private RunnerLoginDAO runnerLoginDAO = new RunnerLoginDAOImpl();
    private RunnerDAO runnerDAO = new RunnerDAOImpl();
    private RaceDAO raceDAO = new RaceDAOImpl();
    private RaceOrderDAO raceOrderDAO = new RaceOrderDAOImpl();

    private RunnerLogin runnerLogin;
    private Runner runner;
    private Race race;
    private RaceOrder raceOrder;

    private int runnerId;
    private int raceId;
    private int orderId;

    private ArrayList<RunnerLogin> allRunnerLogins;
    private ArrayList<Runner> allRunners;
    private ArrayList<Race> allRaces;
    private ArrayList<RaceOrder> allRaceOrders;


    public Initialize() throws SQLException {
    }


    /*
    getUserInput Method:
    Get input from user
     */
    public int getUserInput() {
        Driver.log.info("getUserInput Method:");

        String userInputString = input.nextLine();
        int userInputInt = Integer.parseInt(userInputString);
        Driver.log.info("userInputInt: " + userInputInt);

        return userInputInt;
    }

    /*
    login Method:
    Get username and password
     */
    public void login() throws SQLException {
        Driver.log.info("login Method:");

        System.out.println("Login to existing account:");

        System.out.println("- Enter username: ");
        username = input.nextLine();
        Driver.log.info(" Entering username" + username);

        System.out.println("- Enter password: ");
        password = input.nextLine();
        Driver.log.info("Entering password" + password);

        System.out.println("Processing request...");
    }

    /*
    validateLogin Method:
    Check to see if login credentials are valid
     */
    public void validateLogin() throws SQLException {
        Driver.log.info("validateLogin Method:");

        allRunnerLogins = runnerLoginDAO.getAll();

        if (allRunnerLogins.size() != 0) {
            boolean result = false;

            for (int i = 0; i < allRunnerLogins.size(); i++) {
                runnerLogin = (RunnerLogin) allRunnerLogins.get(i);
                if (username.equals(runnerLogin.getUsername()) && password.equals(runnerLogin.getPassword())) {
                    result = true;
                    runnerId = runnerLogin.getLoginId();
                    break;
                }
            }

            getRunnerInfo();

            Driver.log.info("Login successful:" + result);

            if (result) {
                System.out.println("Login successful");
                loginOptions();

            } else {
                System.out.println("Incorrect username or password");
            }
        } else {
            System.out.println("Table is empty, need to create a new account");
        }
    }

    public void loginOptions() throws SQLException {
        Driver.log.info("loginOptions Method:");

        try {
            printLoginMenu(runner.getFirstName());
            Driver.log.info("Current runner firstname:" + runner.getFirstName());

            userInput = getUserInput();
            Driver.log.info("Current userInput:" + userInput);

            while (userInput != 0) {
                if (userInput == 1) {
                    updateProfile();
                } else if (userInput == 2) {
                    displayAllRaces();
                    System.out.println("Enter the ID of the race you want enter:");
                    raceId = getUserInput();
                    raceSignUp(raceId);
                    Driver.log.info("Select race with raceId of:" + raceId);

                } else if (userInput == 3) {
                    printIndividualRaces();
                    showIndividualRaces();
                    printRaceTableBot();
                } else {
                    System.out.println("Invalid option, exiting system");
                }

                printLoginMenu(runner.getFirstName());
                userInput = getUserInput();
                Driver.log.info("Current userInput:" + userInput);
            }
        } catch(NumberFormatException e) {
            System.out.print("Invalid input, pick a number option above");
        }

        System.out.println("Back to main menu");

    }

    public void raceSignUp(int raceId) throws SQLException {
        Driver.log.info("raceSignUp Method:");

        raceOrder = new RaceOrder(runnerId, raceId);
        Driver.log.info("Creating new raceOrder:" + raceOrder);

        int result = raceOrderDAO.insert(raceOrder);

        if (result == 1) {
            System.out.println("Signup was successful");
        } else {
            System.out.println("Signup unsuccessful");
        }

    }

    public void showIndividualRaces() throws SQLException {
        Driver.log.info("showIndividualRaces Method:");
        raceOrderDAO.getIndividualOrders(runnerId);
    }


    public void updateProfile() throws SQLException {
        Driver.log.info("updateProfile Method:");

        printUpdateMenu();
        userInput = getUserInput();
        Driver.log.info("Current userInput:" + userInput);

        if (userInput == 1) {
            System.out.println("- Enter first name:");
            firstName = input.nextLine();
            Driver.log.info("Updating firstname to: " + firstName);
        } else if (userInput == 2) {
            System.out.println("- Enter last name:");
            lastName = input.nextLine();
            Driver.log.info("Updating lastname to: " + lastName);
        } else if (userInput == 3) {
            System.out.println("- Enter gender:");
            gender = input.nextLine();
            Driver.log.info("Updating gender to: " + gender);
        } else if (userInput == 4) {
            System.out.println("- Enter age:");
            age = Integer.parseInt(input.nextLine());
            Driver.log.info("Updating age to: " + age);
        } else if (userInput == 0) {
            System.out.print("Exiting system, goodbye");
        } else {
            System.out.println("Invalid option, exiting system");
        }

        System.out.println("Updating profile...");
        runner = new Runner(runnerId, firstName, lastName, gender, age);
        Driver.log.info("Creating new runner object:" + runner);

        int result = runnerDAO.update(runner);

        if (result == 1) {
            System.out.println("Update successful");
        } else {
            System.out.println("Update unsuccessful");
        }

    }

    public void createAccount() throws SQLException {
        Driver.log.info("createAccount Method:");

        try {
            System.out.println("Create a new account:");

            System.out.println("- Enter a new username:");
            username = input.nextLine();
            Driver.log.info("Enter new username: " + username);

            System.out.println("- Enter a new password:");
            password = input.nextLine();
            Driver.log.info("Entering new password: " + password);

            System.out.println("Processing request...");

            runnerLogin = new RunnerLogin(username, password);
            Driver.log.info("Creating new runnerLogin object: " + runnerLogin);

            int result = runnerLoginDAO.insert(runnerLogin);
            Driver.log.info("Inserting new runnerLogin into database");

            if (result == 1) {
                System.out.println("Creation successful");
            } else {
                System.out.println("Cannot create account");
            }

        } catch (SQLException e) {
            System.out.println("Username unavailable.");
        }
    }

    public void getProfileInput() {
        System.out.println("- Enter first name:");
        firstName = input.nextLine();

        System.out.println("- Enter last name:");
        lastName = input.nextLine();

        System.out.println("- Enter gender (m - male, f - female):");
        gender = input.nextLine();

        System.out.println("- Enter age:");
        String stringAge = input.nextLine();
        age = Integer.parseInt(stringAge);
    }

    public void createProfile() throws SQLException {

        System.out.println("Next steps");
        System.out.println("Fill out profile information:");

        getProfileInput();

        System.out.println("Saving information...");

        runner = new Runner(firstName, lastName, gender, age);

        int result = runnerDAO.insert(runner);

        allRunners = runnerDAO.getAll();

        for (int i = 0; i < allRunners.size(); i++) {
            runner = (Runner) allRunners.get(i);
            if (firstName.equals(runner.getFirstName()) && lastName.equals(runner.getLastName())) {
                runnerId = runner.getRunnerId();
            }
        }

        getRunnerInfo();

        linkAccount(firstName, lastName);

        if (result == 1) {
            System.out.println("Profile complete");
            loginOptions();
        } else {
            System.out.println("Profile not saved, an error occurred");
        }

    }

    public void getRunnerInfo() throws SQLException {
        runner = runnerDAO.get(runnerId);
        runnerId = runner.getRunnerId();
        firstName = runner.getFirstName();
        lastName = runner.getLastName();
        gender = runner.getGender();
        age = runner.getAge();
    }

    public int linkAccount(String firstName, String lastName) throws SQLException {
        int runnerId = 0;
        allRunners = runnerDAO.getAll();
        for (int i = 0; i < allRunners.size(); i++) {
            runner = (Runner) allRunners.get(i);
            if (firstName.equals(runner.getFirstName()) && lastName.equals(runner.getLastName())) {
                runnerId = runner.getRunnerId();
            }
        }

        int result = runnerLoginDAO.updateRunnerId(username, runnerId);

        return result;
    }

    public void displayAllRaces() throws SQLException {
        System.out.println("Processing request...");

        allRaces = raceDAO.getAll();

        printRaceTable();

        for (int i = 0; i < allRaces.size(); i++) {
            System.out.println(allRaces.get(i));
        }

        printRaceTableBot();
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void printTitle() {
        System.out.println("******************************************************************************************************************************************************");
        System.out.println("  =======   ||        ||=====||   ||            ||          ||==========||   ||            ||   ||======||   ||==========||   ==========   ||     ||  ");
        System.out.println("  ||        ||        ||     ||    ||    ||    ||                 ||          ||    ||    ||        ||             ||         ||      ||   ||     ||  ");
        System.out.println("  ||=====   ||        ||     ||     ||  ||||  ||                  ||           ||  ||||  ||         ||             ||         ||           ||=====||  ");
        System.out.println("       ||   ||        ||     ||      ||||  ||||                   ||            ||||  ||||          ||             ||         ||      ||   ||     ||  ");
        System.out.println("  =====||   ||=====   ||=====||       ||    ||                    ||             ||    ||       ||======||         ||         ==========   ||     ||  ");
        System.out.println();
        System.out.println("                                ||     ||==========||   ||     ||   ||        ||=====||   ||==========||   ||=====||                                  ");
        System.out.println("                               ||||          ||         ||     ||   ||        ||                ||         ||                                         ");
        System.out.println("                              ||  ||         ||         ||=====||   ||        ||==||            ||         ||==||                                     ");
        System.out.println("                             ||====||        ||         ||     ||   ||        ||                ||         ||                                         ");
        System.out.println("                            ||      ||       ||         ||     ||   ||=====   ||=====||         ||         ||=====||                                  ");
        System.out.println("******************************************************************************************************************************************************");
    }

    public void printStartMenu() {
        System.out.println("|==================================|");
        System.out.println("|   MENU                           |");
        System.out.println("|----------------------------------|");
        System.out.println("|   Options:                       |");
        System.out.println("|   1. Login                       |");
        System.out.println("|   2. Create New Account          |");
        System.out.println("|   3. Find A Race                 |");
        System.out.println("|   0. Exit                        |");
        System.out.println("|==================================|");
        System.out.println("Select a number option:");
    }

    public void printLoginMenu(String firstName) {
        System.out.println("Welcome, " + firstName);
        System.out.println("|==================================|");
        System.out.println("|   MENU SELECTION DEMO            |");
        System.out.println("|----------------------------------|");
        System.out.println("|   Options:                       |");
        System.out.println("|   1. Update Profile Information  |");
        System.out.println("|   2. Signup For A Race           |");
        System.out.println("|   3. View Your Current Races     |");
        System.out.println("|   0. Exit                        |");
        System.out.println("|==================================|");
        System.out.println("Select a number option:");
    }

    public void printUpdateMenu() {
        System.out.println("|==================================|");
        System.out.println("|   MENU SELECTION DEMO            |");
        System.out.println("|----------------------------------|");
        System.out.println("|   Options:                       |");
        System.out.println("|   1. Update First Name           |");
        System.out.println("|   2. Update Last Name            |");
        System.out.println("|   3. Update Gender               |");
        System.out.println("|   4. Update Age                  |");
        System.out.println("|   0. Exit                        |");
        System.out.println("|==================================|");
        System.out.println("Select a number option:");
    }

    public void printRaceTable() {
        System.out.println("===============================================================================================================");
        System.out.println("| ALL UPCOMING RACES                                                                                          |");
        System.out.println("|-------------------------------------------------------------------------------------------------------------|");
        System.out.println("| RACE ID | NAME                           | DISTANCE         | DATE        | STATE    | CITY                 |");
        System.out.println("|-------------------------------------------------------------------------------------------------------------|");
    }

    public void printRaceTableBot() {
        System.out.println("===============================================================================================================");
    }

    public void printIndividualRaces() {
        System.out.println("===============================================================================================================");
        System.out.println("| YOUR UPCOMING RACES                                                                                         |");
        System.out.println("|-------------------------------------------------------------------------------------------------------------|");
        System.out.println("| ORDER ID | NAME                           | DISTANCE         | DATE        | STATE    | CITY                |");
        System.out.println("|-------------------------------------------------------------------------------------------------------------|");
    }

}
