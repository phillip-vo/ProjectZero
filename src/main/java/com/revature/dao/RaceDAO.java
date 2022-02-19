package com.revature.dao;

import com.revature.model.Race;
import com.revature.model.Runner;
import com.revature.util.ArrayList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RaceDAO {
    private Connection conn;

    public ArrayList<Race> getAllRaces() throws SQLException {
        ArrayList<Race> allRaces = new ArrayList<Race>();

        String query = "SELECT * FROM races";

        try(Statement statement = conn.createStatement()) {

            ResultSet rs =  statement.executeQuery(query);
            while(rs.next()) {
                Race nextRace = new Race(rs.getInt("race_id"), rs.getString("name"), rs.getString("distances"));
                allRaces.add(nextRace);
            }
            rs.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        conn.close();

        return allRaces;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
