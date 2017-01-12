package ru.itis.dao;

import ru.itis.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    User findById(Integer userId);
    User findByLogin(String login);
    void add(User user);
    void delete(Integer userId);
    void update(User user);
    String getToken(Integer userId);
    void addToken(Integer userId, String token);
    void updateToken(Integer userId, String token);
    void addUserToChat(Integer userId, Integer chatId);
    void deleteUserFromChat(Integer userId, Integer chatId);
    void setLastUserMessageId(Integer userId, Integer chatId, Integer lastMessageId);
    void updateLastUserMessageId(Integer userId, Integer chatId, Integer lastMessageId);
}
