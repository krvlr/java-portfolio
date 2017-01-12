package ru.kpfu.service;

import ru.kpfu.model.User;

public interface UserService {
    void registration(User user);
    String login(String login, String password);
    boolean checkEmail(String email);
    boolean checkLogin(String login);
    User findByToken(String token);
}
