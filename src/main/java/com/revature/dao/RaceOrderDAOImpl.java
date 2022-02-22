package com.revature.dao;

import com.revature.model.RaceOrder;
import com.revature.model.RunnerLogin;
import com.revature.util.ArrayList;
import com.revature.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RaceOrderDAOImpl implements RaceOrderDAO {
    @Override
    public RaceOrder get(int id) throws SQLException {
        Connection conn = Database.getConnection();
        RaceOrder raceOrder= null;

        String sql = "SELECT order_id, runner_id, race_id FROM race_orders WHERE order_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            int orderId = rs.getInt("order_id");
            int runnerId = rs.getInt("runner_id");
            int raceId = rs.getInt("race_id");

            raceOrder = new RaceOrder(orderId, runnerId, raceId);
        }

        rs.close();
        ps.close();
        conn.close();

        return raceOrder;
    }

    @Override
    public ArrayList<RaceOrder> getAll() throws SQLException {
        return null;
    }

    @Override
    public int save(RaceOrder raceOrder) throws SQLException {
        return 0;
    }

    @Override
    public int insert(RaceOrder raceOrder) throws SQLException {
        return 0;
    }

    @Override
    public int update(RaceOrder raceOrder) throws SQLException {
        return 0;
    }

    @Override
    public int delete(RaceOrder raceOrder) throws SQLException {
        return 0;
    }


    @Override
    public int count() throws SQLException {
        return 0;
    }
}
