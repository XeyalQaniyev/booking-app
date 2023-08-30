package org.example.app.dao;

import org.example.app.entity.Flight;
import org.example.app.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.app.util.Util.getFlight;

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
    public boolean addUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into \"User\"(name,surname,age,password,user_name) values(?,?,?,?,?)");

            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setInt(3, u.getAge());
            stmt.setString(4, u.getPassword());
            stmt.setString(4, u.getUserName());

            return stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        try (Connection c = connect()) {
            PreparedStatement stmt = connect().prepareStatement("select * from \"User\" where id = ?");
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
