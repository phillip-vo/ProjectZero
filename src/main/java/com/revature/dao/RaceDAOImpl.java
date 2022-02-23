package com.revature.dao;

import com.revature.model.Race;
import com.revature.model.Runner;
import com.revature.util.ArrayList;
import com.revature.util.Database;

import java.sql.*;

public class RaceDAOImpl implements RaceDAO {
    @Override
    public Race get(int id) throws SQLException {
        Connection conn = Database.getConnection();
        Race race = null;

        String sql = "SELECT race_id, name, distance, race_date FROM races WHERE id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            int raceId = rs.getInt("race_id");
            String name = rs.getString("name");
            String distance = rs.getString("distance");
            String date = rs.getString("race_date");

            race = new Race(raceId, name, distance, date);
        }

        rs.close();
        ps.close();
        conn.close();

        return race;
    }

    @Override
    public ArrayList<Race> getAll() throws SQLException {
        Connection conn = Database.getConnection();

        int count = count();

        ArrayList<Race> allRaces = new ArrayList<Race>(count);

        String sql = "SELECT * FROM races";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            Race nextRace = new Race(rs.getInt("race_id"), rs.getString("name"), rs.getString("distance"), rs.getString("race_date"), rs.getString("city"), rs.getString("state"));
            allRaces.add(nextRace);
        }
        rs.close();

        return allRaces;
    }

    @Override
    public int insert(Race race) throws SQLException {
        Connection conn = Database.getConnection();

        String sql = "INSERT INTO races (name, distance, race_date) VALUES (?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, race.getName());
        ps.setString(2, race. getDistance());
        ps.setString(3, race.getDate());

        int result = ps.executeUpdate();

        ps.close();
        conn.close();

        return result;
    }

    @Override
    public int update(Race race) throws SQLException {
        Connection conn = Database.getConnection();

        String sql = "UPDATE races SET name = ?, distance = ?, race_date = ? WHERE race_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, race.getName());
        ps.setString(2, race.getDistance());
        ps.setString(3, race.getDate());
        ps.setInt(4, race.getRaceId());

        int result = ps.executeUpdate();

        ps.close();
        conn.close();

        return result;
    }

    @Override
    public int delete(Race race) throws SQLException {
        Connection conn = Database.getConnection();

        String sql = "DELETE FROM races WHERE race_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, race.getRaceId());

        int result = ps.executeUpdate();

        ps.close();
        conn.close();

        return result;
    }


    @Override
    public int count() throws SQLException {

        Connection conn = Database.getConnection();

        String sql = "SELECT COUNT(*) FROM races";

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
