package com.favorite.roomdatabase.ui;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {FavoriteModel.class}, version = 1)
public abstract class FavoriteDatabase extends RoomDatabase {

    private static FavoriteDatabase instance;

    public static FavoriteDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (FavoriteDatabase.class) {
                instance = Room.databaseBuilder(context, FavoriteDatabase.class, "DATABASE").allowMainThreadQueries().build();
            }
        }
        return instance;
    }

    public abstract FavoriteDao getDao();
}
