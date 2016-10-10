package ru.itis.service;

import ru.itis.dao.UsersDao;
import ru.itis.models.User;

import java.io.IOException;
import java.util.List;

public class SimpleUsersServiceImpl implements SimpleUsersService {

    private UsersDao usersDao;

    public SimpleUsersServiceImpl() {

    }

    @Override
    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public boolean isRegistered(String userName, String userPassword) {
        List<User> registeredUsers = null;
        try {
            registeredUsers = usersDao.getAll();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (User user : registeredUsers) {
            if (user.getName().equals(userName) &&
                    user.getPassword().equals(userPassword)) {
                return true;
            }
        }

        return false;
    }
}
