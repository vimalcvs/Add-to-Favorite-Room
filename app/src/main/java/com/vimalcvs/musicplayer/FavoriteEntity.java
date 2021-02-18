package com.vimalcvs.musicplayer;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favoritelist")

public class FavoriteEntity {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "hindi")
    private String hindi;

    @ColumnInfo(name = "english")
    private String english;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }




    public String getHindi() {
        return hindi;
    }

    public void setHindi(String hindi) {
        this.hindi = hindi;
    }



    public String getEnglish() {
        return english;
    }
    public void setEnglish(String english) {
        this.english = english;
    }

}
