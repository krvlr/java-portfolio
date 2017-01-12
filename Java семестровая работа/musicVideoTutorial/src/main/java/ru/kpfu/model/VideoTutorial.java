package ru.kpfu.model;

import com.google.common.base.MoreObjects;

public class VideoTutorial {
    private int videoTutorialId;
    private int ownerId;
    private String description;

    public VideoTutorial(int videoTutorialId, int ownerId, String description) {
        this.videoTutorialId = videoTutorialId;
        this.ownerId = ownerId;
        this.description = description;
    }

    public int getVideoTutorialId() {
        return videoTutorialId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("videoTutorialId", this.videoTutorialId)
                .add("ownerId", this.ownerId)
                .add("description", this.description)
                .toString();
    }
}
