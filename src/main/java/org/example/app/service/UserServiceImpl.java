package org.example.app.service;

import org.example.app.dao.UserDao;
import org.example.app.dao.UserDaoImpl;
import org.example.app.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public User authenticate(String username, String password) {
        return userDao.getAllUser()
                .stream()
                .findAny()
                .filter(user ->
                        user.getUserName().equalsIgnoreCase(username)&&
                                user.getPassword().equalsIgnoreCase(password)).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAllUser();
    }

    @Override
    public boolean addUser(User u) {
        return userDao.addUser(u);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

}