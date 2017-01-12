package ru.kpfu.dao;

import ru.kpfu.model.VideoTutorial;

import java.util.List;

public interface VideoTutorialDao {
    void create(VideoTutorial videoTutorial);
    void update(VideoTutorial videoTutorial);
    void delete(int videoTutorialId);
    List<VideoTutorial> getAll();
}
