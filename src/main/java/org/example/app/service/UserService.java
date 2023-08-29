package org.example.app.service;

import org.example.app.entity.User;

import java.util.List;

public interface UserService {
    User authenticate(String username, String password);
    List<User> getAll();
    boolean addUser(User u);
    User getUserById(int id);
    void showMyFlights(int userId);

}
