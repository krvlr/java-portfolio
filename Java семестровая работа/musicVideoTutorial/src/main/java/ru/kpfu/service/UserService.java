package ru.kpfu.service;

import ru.kpfu.model.User;

import java.util.List;

public interface UserService {
    void registration(User user);
    String login(String login, String password);
    List<User> getAllNames();
    User findByToken(String token);
    void editProfile(User user);
    void deleteProfile(User user);
    void addComment(User user, int videoTutorialId, String commentText);
    void updateTextComment(User user, int videoTutorialId, String commentText);
    void deleteComment(User user, int videoTutorialId);
}
