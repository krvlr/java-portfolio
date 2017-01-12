package ru.kpfu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.dao.CommentDao;
import ru.kpfu.dao.UserDao;
import ru.kpfu.model.Comment;
import ru.kpfu.model.User;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private CommentDao commentDao;

    @Override
    public void registration(User user) {
        userDao.create(user);
    }

    @Override
    public String login(String login, String password) {
        User findUser = userDao.findByNameAndPassword(login, password);
        if (findUser != null){
            return setNewToken(findUser.getUserId());
        }
        return null;
    }

    @Override
    public List<User> getAllNames() {
        List<User> allUser = userDao.getAll();
        List<User> allIdName = new ArrayList<>();
        for(User user : allUser) {
            allIdName.add(new User(user.getUserId(), user.getName()));
        }
        return allIdName;
    }

    private String setNewToken(int userId) {
        SecureRandom random = new SecureRandom();
        String token = new BigInteger(130, random).toString(32);
        userDao.setToken(userId, token);
        return token;
    }

    public User findByToken(String token) {
        return userDao.findByToken(token);
    }

    @Override
    public void editProfile(User user) {
        User findUser = userDao.findByNameAndPassword(user.getName(), user.getPassword());
        if (findUser != null) {
            userDao.update(new User(findUser.getUserId(), user.getName(), user.getPassword(),
                    user.getEmail(), user.getCountry(), user.getSex(), user.getToken()));
        }
    }

    @Override
    public void deleteProfile(User user) {
        User findUser = userDao.findByNameAndPassword(user.getName(), user.getPassword());
        if (findUser != null) {
            userDao.delete(findUser.getUserId());
        }
    }

    @Override
    public void addComment(User user, int videoTutorialId, String commentText) {
        commentDao.create(new Comment(0, user.getUserId(), videoTutorialId, commentText));
    }

    @Override
    public void updateTextComment(User user, int videoTutorialId, String commentText) {
        Comment findComment = commentDao.find(user.getUserId(), videoTutorialId);
        if (findComment != null) {
            commentDao.update(new Comment(findComment.getCommentId(), findComment.getUserId(),
                    findComment.getVideoTutorialId(), commentText));
        }
    }

    @Override
    public void deleteComment(User user, int videoTutorialId) {
        Comment findComment = commentDao.find(user.getUserId(), videoTutorialId);
        if (findComment != null) {
            commentDao.delete(findComment.getCommentId());
        }
    }
}
