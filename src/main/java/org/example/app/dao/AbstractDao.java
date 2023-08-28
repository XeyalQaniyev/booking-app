package org.example.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDao {
    public Connection connect() {
        String url = "jdbc:postgresql://localhost:5432/bookingapp";
        String username = "postgres";
        String password = "toor";
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {

            System.err.println(e.getMessage());
            return null;
        }

    }
}