package org.example.app.service;

import org.example.app.entity.User;

public interface UserService {
    User authenticate(String username, String password);
}
