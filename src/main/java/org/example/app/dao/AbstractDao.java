package org.example.app.dao;

import org.example.app.constant.Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDao {
    public Connection connect() {
        String url = Sql.DB_URL.getValue();
        String username = "postgres";
        String password = "root";
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {

            System.err.println(e.getMessage());
            return null;
        }

    }
}