package com.revature.dao;

import com.revature.model.Runner;
import com.revature.util.ArrayList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface DAO<T> {

    T get(int id) throws SQLException;

    ArrayList<T> getAll() throws SQLException;

    int save(T t) throws SQLException;

    int insert(T t) throws SQLException;

    int update(T t) throws SQLException;

    int delete(T t);

}


/*
    private Connection conn;

    public ArrayList<Runner> getAllRunners() throws SQLException {

        ArrayList<Runner> allRunners = new ArrayList<Runner>();

        String query = "SELECT * FROM runners";

        try(Statement statement = conn.createStatement()) {

            ResultSet rs =  statement.executeQuery(query);
            while(rs.next()) {
                Runner nextRunner = new Runner(rs.getInt("runner_id"), rs.getString("last_name"), rs.getString("first_name"), rs.getString("gender"), rs.getInt("age"));
                allRunners.add(nextRunner);
            }
            rs.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        conn.close();

        return allRunners;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
     */