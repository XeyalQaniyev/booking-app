package org.example.app.service;

import org.example.app.dao.UserDao;
import org.example.app.dao.UserDaoImpl;
import org.example.app.entity.User;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public User authenticate(String username, String password) {

        return userDao.getAll()
                .stream()
                .findAny()
                .filter(user ->
                        user.getUserName().equalsIgnoreCase(username)&&
                                user.getPassword().equalsIgnoreCase(password)).get();
    }
}