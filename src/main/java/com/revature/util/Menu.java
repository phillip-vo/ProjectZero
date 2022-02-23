package com.revature.util;

public class Menu {

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

    public void printLoginMenu(String firstName) {
        System.out.println("Welcome, " + firstName);
        System.out.println("|   MENU SELECTION DEMO            |");
        System.out.println("|   Options:                       |");
        System.out.println("|   1. Update Profile Information  |");
        System.out.println("|   2. Find a Race                 |");
        System.out.println("|   4. Exit                        |");
        System.out.println("Select an option:");
    }
}
