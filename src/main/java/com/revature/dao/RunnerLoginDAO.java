package com.revature.dao;

import com.revature.model.RunnerLogin;

import java.sql.SQLException;

public interface RunnerLoginDAO extends DAO<RunnerLogin> {

    int updateId(String username, int id) throws SQLException;
}
