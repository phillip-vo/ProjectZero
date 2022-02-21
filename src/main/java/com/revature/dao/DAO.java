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

    int delete(T t) throws SQLException;

    int count() throws SQLException;

}