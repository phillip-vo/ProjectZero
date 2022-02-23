package com.revature.dao;

import com.revature.model.RunnerLogin;

import java.sql.SQLException;

public interface RunnerLoginDAO extends DAO<RunnerLogin> {

    int updateRunnerId(String username, int id) throws SQLException;
}
