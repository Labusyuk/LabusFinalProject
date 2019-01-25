package com.labus.bankpayments.dao;

import com.labus.bankpayments.db.ConnectionPool;
import com.labus.bankpayments.exception.DaoException;
import com.labus.bankpayments.entity.Entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class EntityDao <K, T extends Entity>  {
    protected Connection connection = null;
    EntityDao(){
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            connection = pool.takeConnection();
            connection.setAutoCommit(false);
        }catch (SQLException e) {
        }
    }
    public abstract List<T> getAll() throws DaoException;
    public abstract T getById(K id) throws DaoException;
    public abstract void deleteById(K id) throws DaoException;
    public abstract K create(T entity) throws DaoException;
    public abstract void update(T entity) throws DaoException;
    public abstract T retrieveEntity(ResultSet resultSet) throws DaoException;
}