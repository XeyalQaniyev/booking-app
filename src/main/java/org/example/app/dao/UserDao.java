package org.example.app.dao;

import org.example.app.entity.User;

import java.util.List;

public interface UserDao{
    List<User> getAll();
    boolean addUser();
    User getUserById(int id);

    void showMyFlights(int userId);

}
