package com.revature.dao;

import com.revature.model.RunnerLogin;
import com.revature.util.ArrayList;
import com.revature.util.Database;

import java.sql.*;

public class RunnerLoginDAOImpl implements RunnerLoginDAO{

    ArrayList<RunnerLogin> runnerLoginArrayList = new ArrayList<>(0);

    @Override
    public RunnerLogin get(int id) throws SQLException {

        Connection conn = Database.getConnection();
        RunnerLogin runnerLogin= null;

        String sql = "SELECT id, username, password FROM runner_login WHERE id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            int runnerLoginId = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");

            runnerLogin = new RunnerLogin(runnerLoginId, username, password);
        }

        rs.close();
        ps.close();
        conn.close();

        return runnerLogin;
    }

    @Override
    public ArrayList<RunnerLogin> getAll() throws SQLException {

        Connection conn = Database.getConnection();

        int count = count();

        ArrayList<RunnerLogin> allRunnerLogins = new ArrayList<>(count);

        String sql = "SELECT * FROM runner_login";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()) {
            RunnerLogin nextRunnerLogin = new RunnerLogin(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
            allRunnerLogins.add(nextRunnerLogin);
        }

        return allRunnerLogins;
    }

    @Override
    public int save(RunnerLogin runnerLogin) throws SQLException {

        return 0;
    }

    @Override
    public int insert(RunnerLogin runnerLogin) throws SQLException {

        Connection conn = Database.getConnection();

        String sql = "INSERT INTO runner_login (username, password) VALUES (?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, runnerLogin.getUsername());
        ps.setString(2, runnerLogin.getPassword());

        int result = ps.executeUpdate();

        ps.close();
        conn.close();

        return result;
    }

    @Override
    public int update(RunnerLogin runnerLogin) throws SQLException {

        Connection conn = Database.getConnection();

        String sql = "UPDATE runner_login SET username = ?, password = ? WHERE id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, runnerLogin.getUsername());
        ps.setString(2, runnerLogin.getPassword());
        ps.setInt(3, runnerLogin.getId());

        int result = ps.executeUpdate();

        ps.close();
        conn.close();

        return result;
    }

    @Override
    public int delete(RunnerLogin runnerLogin) throws SQLException {

        Connection conn = Database.getConnection();

        String sql = "DELETE FROM runner_login WHERE id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, runnerLogin.getId());

        int result = ps.executeUpdate();

        ps.close();
        conn.close();

        return result;
    }

    public int count() throws SQLException {

        Connection conn = Database.getConnection();

        String sql = "SELECT COUNT(*) FROM runner_login";

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
