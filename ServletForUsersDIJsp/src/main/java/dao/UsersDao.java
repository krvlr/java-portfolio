package dao;

import java.util.List;

import models.User;

public interface UsersDao {
    List<User> getAll();
    User find(int id);
    void add(User user);
    void update(User user);
    void delete(int id);
    void setToken(User user);
    String getToken(User user);
}
