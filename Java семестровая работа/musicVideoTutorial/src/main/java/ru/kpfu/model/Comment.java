package ru.kpfu.model;

import com.google.common.base.MoreObjects;

public class Comment {
    private int commentId;
    private int userId;
    private int videoTutorialId;
    private String comment;

    public Comment(int commentId, int userId, int videoTutorialId, String comment) {
        this.commentId = commentId;
        this.userId = userId;
        this.videoTutorialId = videoTutorialId;
        this.comment = comment;
    }

    public int getCommentId() {
        return commentId;
    }

    public int getUserId() {
        return userId;
    }

    public int getVideoTutorialId() {
        return videoTutorialId;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("commentId", this.commentId)
                .add("userId", this.userId)
                .add("videoTutorialId", this.videoTutorialId)
                .add("comment", this.comment)
                .toString();
    }
}

