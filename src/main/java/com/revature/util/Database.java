package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

    private Database() {

    }

    public static Connection getConnection() throws SQLException {
        Connection conn = null;

        try {
            // Create FileInputStream object and pass in sql.properties file
            FileInputStream propertiesInput = new FileInputStream("C:\\Users\\Sequoia\\Desktop\\RevatureProjects\\sql.properties");

            // Create Properties object and load data from propertiesInput
            Properties props = new Properties();
            props.load(propertiesInput);

            // Set variables used for connection
            String url = (String) props.get("url");
            String username = (String) props.get("username");
            String password = (String) props.get("password");


            conn = DriverManager.getConnection(url, username, password);

            if (conn != null) {
                System.out.println("Database connection successful");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return conn;
    }

}
