package ru.kpfu.dao;

import ru.kpfu.model.User;

import java.util.List;

public interface UserDao {
    void create(User user);
    List<User> getAll();
    User findByNameAndPassword(String userName, String password);
    User findByEmail(String email);
    User findByLogin(String login);
    void setToken(String userName, String newToken);
    User findByToken(String token);
}
