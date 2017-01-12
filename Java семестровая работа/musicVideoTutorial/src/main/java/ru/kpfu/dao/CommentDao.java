package ru.kpfu.dao;

import ru.kpfu.model.Comment;

import java.util.List;

public interface CommentDao {
    void create(Comment comment);
    void update(Comment comment);
    void delete(int commentId);
    Comment find(int userId, int videoTutorialId);
    List<Comment> getAll();
}
