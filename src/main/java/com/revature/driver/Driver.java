package com.revature.driver;

import com.revature.util.Initialize;

import java.sql.SQLException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Driver {

    public static final Logger log = Logger.getLogger(Driver.class);

    public static void main(String[] args) throws SQLException {

        Initialize init = new Initialize();

        init.printTitle();

        try {
            init.printStartMenu();
            int userInput = init.getUserInput();

            while(userInput != 0) {

                if (userInput == 1) {
                    init.login();
                    init.validateLogin();
                } else if (userInput == 2) {
                    init.createAccount();
                    init.createProfile();
                } else if (userInput == 3) {
                    init.displayAllRaces();
                } else {
                    System.out.println("Invalid option, exiting system");
                    break;
                }

                init.printStartMenu();
                userInput = init.getUserInput();
            }

        } catch(NumberFormatException e) {
            System.out.println("Invalid input, select a number option above");
        }

        System.out.print("Exiting system, goodbye");

    }
}
