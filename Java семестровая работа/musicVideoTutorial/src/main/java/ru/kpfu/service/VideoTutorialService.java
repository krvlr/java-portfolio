package ru.kpfu.service;

import ru.kpfu.model.VideoTutorial;

import java.util.List;

public interface VideoTutorialService {
    void addVideoTutorial(VideoTutorial videoTutorial);
    void updateVideoTutorial(VideoTutorial videoTutorial);
    void delateVideoTutorial(VideoTutorial videoTutorial);
    List<VideoTutorial> getAllVideoTutorial();
}
