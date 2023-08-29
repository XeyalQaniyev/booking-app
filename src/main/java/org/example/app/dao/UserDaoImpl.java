package org.example.app.dao;

import org.example.app.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDao {

    @Override
    public List<User> getAll() {
        List<User> userlist = new ArrayList<>();

        Statement stmt = null;

        try (Connection c = connect()) {
            stmt = connect().createStatement();
            stmt.execute("select * from \"User\" ");

            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                User u = getUser(rs);
                userlist.add(u);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return userlist;
    }

    @Override
    public boolean addUser() {
        return false;
    }

    @Override
    public User getUserById(int id) {
        try (Connection c = connect()) {
            User user = null;
            PreparedStatement stmt = c.prepareStatement("select * from \"User\" where id = ?");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                user = getUser(rs);
            }
            return user;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void showMyFlights(int userId) {
        //join sql command
    }

    private User getUser(ResultSet rs) {
        try {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            int age = rs.getInt("age");
            String pass = rs.getString("password");
            String username = rs.getString("user_name");

            return new User(id, name, surname, age, pass, username);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }


}
