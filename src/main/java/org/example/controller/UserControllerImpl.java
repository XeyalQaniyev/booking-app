package org.example.controller;

import org.example.service.UserService;
import org.example.service.UserServiceImpl;

public class UserControllerImpl implements UserController {
    private final UserService userService = new UserServiceImpl();
}
