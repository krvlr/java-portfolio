package ru.kpfu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.dao.UserDao;
import ru.kpfu.model.User;

import java.math.BigInteger;
import java.security.SecureRandom;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void registration(User user) {
        if (!checkEmail(user.getEmail())){
            userDao.create(user);
        }
    }

    @Override
    public String login(String login, String password) {
        User findUser = userDao.findByNameAndPassword(login, password);
        if (findUser != null){
            return setNewToken(findUser.getName());
        }
        return null;
    }

    @Override
    public boolean checkEmail(String email) {
        return userDao.findByEmail(email) != null ? true : false;
    }

    @Override
    public boolean checkLogin(String login) {
        return userDao.findByLogin(login) != null ? true : false;
    }

    @Override
    public User findByToken(String token) {
        return userDao.findByToken(token);
    }

    private String setNewToken(String userName) {
        SecureRandom random = new SecureRandom();
        String token = new BigInteger(130, random).toString(32);
        userDao.setToken(userName, token);
        return token;
    }
}
