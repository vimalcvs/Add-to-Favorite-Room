package com.vimalcvs.musicplayer;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities={FavoriteEntity.class},version = 1)
public abstract class FavoriteDatabase extends RoomDatabase {
    public abstract FavoriteDao favoriteDao();
}
