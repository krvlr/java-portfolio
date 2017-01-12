package ru.itis.dao;

import ru.itis.models.Message;

import java.util.List;

public interface MessageDao {
    List<Message> getAll();
    Message findById(Integer messageId);
    List<Message> findByChatId(Integer chatId);
    void add(Message message);
    void update(Message message);
}
