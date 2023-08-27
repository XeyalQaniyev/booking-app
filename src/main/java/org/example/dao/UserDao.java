package org.example.dao;

import org.example.entity.User;

import java.util.List;

public interface UserDao{
    List<User> getAll();
    boolean addUser();
    User getUserById(User id);

}
