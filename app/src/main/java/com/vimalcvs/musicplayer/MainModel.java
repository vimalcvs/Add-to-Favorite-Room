package com.vimalcvs.musicplayer;

public class MainModel {
    private final int id;
    private final String hindi;
    private final String english;

    public MainModel(int id, String hindi, String english) {
        this.id = id;
        this.hindi = hindi;
        this.english = english;
    }

    public int getId() {
        return id;
    }

    public String getHindi() {
        return hindi;
    }

    public String getEnglish() {
        return english;
    }
}
