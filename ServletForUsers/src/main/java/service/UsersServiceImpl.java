package service;

import dao.UsersDao;
import models.User;

import java.util.List;

public class UsersServiceImpl implements UsersService {
    private UsersDao usersDao;

    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public List<User> getAllUser() {
        return usersDao.getAll();
    }

    public User findUserById(int id) {
        return usersDao.find(id);
    }

    @Override
    public void addUser(User user) {
        usersDao.add(user);
    }

    public void updateUser(User user) {
        this.usersDao.update(user);
    }

    @Override
    public void deleteUser(int id) {
        usersDao.delete(id);
    }
}
