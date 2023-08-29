package org.example.app.controller;

import org.example.app.entity.User;

import java.util.List;

public interface UserController {
    User authenticate(String username, String password);
    List<User> getAll();
    boolean addUser(User u);
    User getUserById(int id);
    void showMyFlights(int userId);
}