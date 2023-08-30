package org.example.app.dao;

import org.example.app.entity.User;

import java.util.List;

public interface UserDao{
    List<User> getAllUser();
    boolean addUser(User u);
    User getUserById(int id);
}
