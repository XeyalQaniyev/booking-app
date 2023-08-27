package org.example.app.controller;

import org.example.app.service.UserService;
import org.example.app.service.UserServiceImpl;

public class UserControllerImpl implements UserController {
    private final UserService userService = new UserServiceImpl();
}
