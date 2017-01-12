package ru.itis.services;

import ru.itis.models.Message;

import java.util.List;

public interface MessageService {
    List<Message> getAllMessage();
    Message findMessageById(Integer messageId);
    List<Message> findMessagesByChatId(Integer chatId);
    void addMessage(Message message);
    void updateMessage(Message message);
}
