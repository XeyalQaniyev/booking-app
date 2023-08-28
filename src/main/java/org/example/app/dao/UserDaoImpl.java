package org.example.app.dao;

import org.example.app.entity.User;

import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDao{

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean addUser() {
        return false;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public void showMyFlights(int userId) {
        //join sql command
    }


}
