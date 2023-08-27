package org.example.app.service;

import org.example.app.dao.UserDao;
import org.example.app.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();
}
