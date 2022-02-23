package com.revature.dao;

import com.revature.model.RaceOrder;
import com.revature.model.Runner;
import com.revature.model.RunnerLogin;
import com.revature.util.ArrayList;
import com.revature.util.Database;

import java.sql.*;

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
        Connection conn = Database.getConnection();

        int count = count();

        ArrayList<RaceOrder> allRaceOrders = new ArrayList<RaceOrder>(count);

        String sql = "SELECT * FROM race_orders";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            RaceOrder nextRaceOrder = new RaceOrder(rs.getInt("order_id"), rs.getInt("runner_id"), rs.getInt("race_id"));
            allRaceOrders.add(nextRaceOrder);
        }
        rs.close();

        return allRaceOrders;
    }

    @Override
    public int insert(RaceOrder raceOrder) throws SQLException {
        Connection conn = Database.getConnection();

        String sql = "INSERT INTO race_orders (runner_id, race_id) VALUES (?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, raceOrder.getRunnerId());
        ps.setInt(2, raceOrder.getRaceId());

        int result = ps.executeUpdate();

        ps.close();
        conn.close();

        return result;
    }

    @Override
    public int update(RaceOrder raceOrder) throws SQLException {
        Connection conn = Database.getConnection();

        String sql = "UPDATE race_orders SET runner_id = ?, race_id = ? WHERE order_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, raceOrder.getRunnerId());
        ps.setInt(2, raceOrder.getRaceId());
        ps.setInt(3, raceOrder.getOrderId());

        int result = ps.executeUpdate();

        ps.close();
        conn.close();

        return result;
    }

    @Override
    public int delete(RaceOrder raceOrder) throws SQLException {
        Connection conn = Database.getConnection();

        String sql = "DELETE FROM race_orders WHERE order_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, raceOrder.getOrderId());

        int result = ps.executeUpdate();

        ps.close();
        conn.close();

        return result;
    }


    @Override
    public int count() throws SQLException {
        Connection conn = Database.getConnection();

        String sql = "SELECT COUNT(*) FROM race_orders";

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        rs.next();

        int count = rs.getInt(1);

        ps.close();
        rs.close();
        conn.close();

        return count;
    }

    public void getIndividualOrders(int id) throws SQLException {
        Connection conn = Database.getConnection();

        String sql = "SELECT race_orders.order_id, races.name, races.distance, races.race_date, races.state, races.city " +
                "FROM race_orders INNER JOIN runners ON race_orders.runner_id = runners.runner_id " +
                "INNER JOIN races ON race_orders.race_id = races.race_id WHERE runners.runner_id = ? ORDER BY races.race_date";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            int orderId = rs.getInt("order_id");
            String name = rs.getString("name");
            String distance = rs.getString("distance");
            String date = rs.getString("race_date");
            String state = rs.getString("state");
            String city = rs.getString("city");
            System.out.println(String.format("| %-10s %-32s %-18s %-13s %-10s %-20s|", orderId, name, distance, date, state, city));
        }
    }
}
