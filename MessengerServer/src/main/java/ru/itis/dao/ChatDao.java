package ru.itis.dao;

import ru.itis.models.Chat;

import java.util.List;

public interface ChatDao {
    List<Chat> getAll();
    Chat find(Integer chatId);
    void add(Chat chat);
    void delete(Integer chatId);
    void update(Chat chat);
}
