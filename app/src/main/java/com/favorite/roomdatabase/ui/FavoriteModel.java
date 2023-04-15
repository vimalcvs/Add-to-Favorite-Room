package com.favorite.roomdatabase.ui;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorite_table", indices = {@Index(value = {"hindi"}, unique = true), @Index(value = {"english"}, unique = true)})
public class FavoriteModel {

    @ColumnInfo(name = "hindi")
    public String hindi;

    @ColumnInfo(name = "english")
    public String english;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    public FavoriteModel(int id, String hindi, String english) {
        this.id = id;
        this.hindi = hindi;
        this.english = english;
    }
}
