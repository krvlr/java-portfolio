package ru.kpfu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.dao.VideoTutorialDao;
import ru.kpfu.model.VideoTutorial;

import java.util.List;

@Service
public class VideoTutorialServiceImpl implements VideoTutorialService {

    @Autowired
    private VideoTutorialDao videoTutorialDao;

    @Override
    public void addVideoTutorial(VideoTutorial videoTutorial) {
        videoTutorialDao.create(videoTutorial);
    }

    @Override
    public void updateVideoTutorial(VideoTutorial videoTutorial) {
        videoTutorialDao.update(videoTutorial);
    }

    @Override
    public void delateVideoTutorial(VideoTutorial videoTutorial) {
        videoTutorialDao.delete(videoTutorial.getVideoTutorialId());
    }

    @Override
    public List<VideoTutorial> getAllVideoTutorial() {
        return videoTutorialDao.getAll();
    }

}
