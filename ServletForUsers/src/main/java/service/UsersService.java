package service;

import models.User;

import java.util.List;

public interface UsersService {
    List<User> getAllUser();
    User findUserById(int id);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
