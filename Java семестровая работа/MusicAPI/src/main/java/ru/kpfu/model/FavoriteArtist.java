package ru.kpfu.model;

import com.google.common.base.MoreObjects;

public class FavoriteArtist {

    private String name;
    private long listeners;
    private long playcount;
    private String image;

    public FavoriteArtist() {

    }

    public FavoriteArtist(String name, long listeners, long playcount, String image) {
        this.name = name;
        this.listeners = listeners;
        this.playcount = playcount;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public long getListeners() {
        return listeners;
    }

    public long getPlaycount() {
        return playcount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListeners(long listeners) {
        this.listeners = listeners;
    }

    public void setPlaycount(long playcount) {
        this.playcount = playcount;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", this.name)
                .add("listeners", this.listeners)
                .add("playcount", this.playcount)
                .toString();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
