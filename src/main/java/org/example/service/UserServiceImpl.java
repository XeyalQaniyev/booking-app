package org.example.service;

import org.example.dao.UserDao;
import org.example.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();
}
