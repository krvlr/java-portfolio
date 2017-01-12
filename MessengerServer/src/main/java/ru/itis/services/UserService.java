package ru.itis.services;

import ru.itis.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User findUserById(Integer userId);
    User authorizeUser(String login, String password);
    void registredUser(User user);
    void deleteUser(Integer userId);
    void updateUser(User user);
    void addTokenForUser(Integer userId);
    void updateTokenForUser(Integer userId, String token);
    void addUserToChat(Integer userId, Integer chatId);
    void deleteUserFromChat(Integer userId, Integer chatId);
    void setLastUserMessageId(Integer userId, Integer chatId, Integer lastMessageId);
    void updateLastUserMessageId(Integer userId, Integer chatId, Integer lastMessageId);
}
