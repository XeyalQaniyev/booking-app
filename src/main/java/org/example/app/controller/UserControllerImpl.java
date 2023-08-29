package org.example.app.controller;

import org.example.app.entity.User;
import org.example.app.service.UserService;
import org.example.app.service.UserServiceImpl;

import java.util.List;

public class UserControllerImpl implements UserController {
    private final UserService userService = new UserServiceImpl();

    @Override
    public User authenticate(String username, String password) {
        return userService.authenticate(username,password);
    }

    @Override
    public List<User> getAll() {
        return userService.getAll();
    }

    @Override
    public boolean addUser(User u) {
        return userService.addUser(u);
    }

    @Override
    public User getUserById(int id) {
        return userService.getUserById(id);
    }

    @Override
    public void showMyFlights(int userId) {

    }
}