package com.revature.driver;

import com.revature.util.Initialize;

import java.sql.SQLException;

public class Driver {

    public static void main(String[] args) throws SQLException {

        Initialize init = new Initialize();

        init.printStartMenu();
        int userInput = init.getUserInput();

        if (userInput == 1) {
            init.login();
            init.validateLogin();
        } else if (userInput == 2) {
            init.createAccount();
            init.createProfile();
        } else if (userInput == 3) {
            init.displayRaces();
        } else if (userInput == 4) {
            System.out.print("Exiting system, goodbye");
        } else {
            System.out.println("Invalid option, exiting system");
        }

    }
}
