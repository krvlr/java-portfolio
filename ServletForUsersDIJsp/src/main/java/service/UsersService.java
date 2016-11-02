package service;

import models.User;

import java.util.List;

public interface UsersService {
    List<User> getAllUser();
    User findUserById(int id);
    User findUserByLoginAndPassword(String login, String password);
    User findUserByToken(String token);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    String setToken(User user);
}
