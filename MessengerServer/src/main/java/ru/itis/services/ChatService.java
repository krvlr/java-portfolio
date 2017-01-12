package ru.itis.services;

import ru.itis.models.Chat;

import java.util.List;

public interface ChatService {
    List<Chat> getAllChat();
    Chat findChat(Integer chatId);
    void addChat(Chat chat);
    void deleteChat(Integer chatId);
    void updateChat(Chat chat);
}
