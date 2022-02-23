package com.revature.dao;

import com.revature.model.RaceOrder;

import java.sql.SQLException;

public interface RaceOrderDAO extends DAO<RaceOrder> {
    void getIndividualOrders(int id) throws SQLException;
}
