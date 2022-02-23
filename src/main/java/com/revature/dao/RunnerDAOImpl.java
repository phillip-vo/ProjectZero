package com.revature.dao;

import com.revature.model.Runner;
import com.revature.util.ArrayList;
import com.revature.util.Database;

import java.sql.*;

public class RunnerDAOImpl implements RunnerDAO {

    @Override
    public Runner get(int id) throws SQLException {
        Connection conn = Database.getConnection();
        Runner runner = null;

        String sql = "SELECT runner_id, first_name, last_name, gender, age FROM runners WHERE runner_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int runnerId = rs.getInt("runner_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String gender = rs.getString("gender");
            int age = rs.getInt("age");

            runner = new Runner(runnerId, firstName, lastName, gender, age);
        }

        rs.close();
        ps.close();
        conn.close();

        return runner;
    }

    @Override
    public ArrayList<Runner> getAll() throws SQLException {
        Connection conn = Database.getConnection();

        int count = count();

        ArrayList<Runner> allRunners = new ArrayList<Runner>(count);

        String sql = "SELECT * FROM runners";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            Runner nextRunner = new Runner(rs.getInt("runner_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("gender"), rs.getInt("age"));
            allRunners.add(nextRunner);
        }
        rs.close();

        return allRunners;
    }


    @Override
    public int insert(Runner runner) throws SQLException {
        Connection conn = Database.getConnection();

        String sql = "INSERT INTO runners (first_name, last_name, gender, age) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, runner.getFirstName());
        ps.setString(2, runner. getLastName());
        ps.setString(3, runner.getGender());
        ps.setInt(4, runner.getAge());

        int result = ps.executeUpdate();

        ps.close();
        conn.close();

        return result;
    };

    @Override
    public int update(Runner runner) throws SQLException {
        Connection conn = Database.getConnection();

        String sql = "UPDATE runners SET first_name = ?, last_name = ?, gender = ?, age = ? WHERE runner_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, runner.getFirstName());
        ps.setString(2, runner.getLastName());
        ps.setString(3, runner.getGender());
        ps.setInt(4, runner.getAge());
        ps.setInt(5, runner.getRunnerId());

        int result = ps.executeUpdate();

        ps.close();
        conn.close();

        return result;
    }

    @Override
    public int delete(Runner runner) throws SQLException {
        Connection conn = Database.getConnection();

        String sql = "DELETE FROM runners WHERE runner_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, runner.getRunnerId());

        int result = ps.executeUpdate();

        ps.close();
        conn.close();

        return result;
    }

    @Override
    public int count() throws SQLException {

        Connection conn = Database.getConnection();

        String sql = "SELECT COUNT(*) FROM runners";

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        rs.next();

        int count = rs.getInt(1);

        ps.close();
        rs.close();
        conn.close();

        return count;
    }

}
