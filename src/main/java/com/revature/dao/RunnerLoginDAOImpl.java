package com.revature.dao;

import com.revature.model.RunnerLogin;
import com.revature.util.ArrayList;
import com.revature.util.Database;

import java.sql.*;

public class RunnerLoginDAOImpl implements RunnerLoginDAO{

    @Override
    public RunnerLogin get(int id) throws SQLException {

        Connection conn = Database.getConnection();
        RunnerLogin runnerLogin= null;

        String sql = "SELECT login_id, username, password FROM runner_logins WHERE login_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            int loginId = rs.getInt("login_id");
            String username = rs.getString("username");
            String password = rs.getString("password");

            runnerLogin = new RunnerLogin(loginId, username, password);
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

        String sql = "SELECT * FROM runner_logins";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()) {
            RunnerLogin nextRunnerLogin = new RunnerLogin(rs.getInt("login_id"), rs.getString("username"), rs.getString("password"));
            allRunnerLogins.add(nextRunnerLogin);
        }

        rs.close();

        return allRunnerLogins;
    }


    @Override
    public int insert(RunnerLogin runnerLogin) throws SQLException {

        Connection conn = Database.getConnection();

        String sql = "INSERT INTO runner_logins (username, password) VALUES (?, ?)";

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

        String sql = "UPDATE runner_logins SET username = ?, password = ? WHERE login_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, runnerLogin.getUsername());
        ps.setString(2, runnerLogin.getPassword());
        ps.setInt(3, runnerLogin.getLoginId());

        int result = ps.executeUpdate();

        ps.close();
        conn.close();

        return result;
    }

    @Override
    public int delete(RunnerLogin runnerLogin) throws SQLException {

        Connection conn = Database.getConnection();

        String sql = "DELETE FROM runner_logins WHERE login_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, runnerLogin.getLoginId());

        int result = ps.executeUpdate();

        ps.close();
        conn.close();

        return result;
    }

    public int count() throws SQLException {

        Connection conn = Database.getConnection();

        String sql = "SELECT COUNT(*) FROM runner_logins";

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        rs.next();

        int count = rs.getInt(1);

        ps.close();
        rs.close();
        conn.close();

        return count;
    }

    @Override
    public int updateRunnerId(String username, int id) throws SQLException {
        Connection conn = Database.getConnection();

        String sql = "UPDATE runner_logins SET runner_id = ? WHERE username = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setString(2, username);

        int result = ps.executeUpdate();

        ps.close();
        conn.close();

        return result;
    }
}
