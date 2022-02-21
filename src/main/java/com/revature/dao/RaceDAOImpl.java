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

        String sql = "SELECT race_id, name, distance FROM races WHERE id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            int raceId = rs.getInt("race_id");
            String name = rs.getString("name");
            String distance = rs.getString("distance");

            race = new Race(raceId, name, distance);
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
            Race nextRace = new Race(rs.getInt("race_id"), rs.getString("name"), rs.getString("distance"));
            allRaces.add(nextRace);
        }
        rs.close();

        return allRaces;
    }

    @Override
    public int save(Race race) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Race race) throws SQLException {
        Connection conn = Database.getConnection();

        String sql = "INSERT INTO races (name, distance) VALUES (?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, race.getName());
        ps.setString(2, race. getDistance());

        int result = ps.executeUpdate();

        ps.close();
        conn.close();

        return result;
    }

    @Override
    public int update(Race race) throws SQLException {
        Connection conn = Database.getConnection();

        String sql = "UPDATE races SET name = ?, distance = ? WHERE race_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, race.getName());
        ps.setString(2, race.getDistance());
        ps.setInt(3, race.getRaceId());

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
