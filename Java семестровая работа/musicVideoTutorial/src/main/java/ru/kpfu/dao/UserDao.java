package ru.kpfu.dao;

import ru.kpfu.model.User;

import java.util.List;

public interface UserDao {
    void create(User user);
    void update(User user);
    void delete(int userId);
    List<User> getAll();
    User findByNameAndPassword(String userName, String password);
    void setToken(int userId, String newToken);
    User findByToken(String token);
}

