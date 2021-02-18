package com.vimalcvs.musicplayer;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavoriteDao {


    @Insert
    void addData(FavoriteEntity favoriteEntity);

    @Query("select * from favoritelist")
    List<FavoriteEntity> getFavoriteData();

    @Query("SELECT EXISTS (SELECT 1 FROM favoritelist WHERE id=:id)")
    int isFavorite(int id);

    @Delete
    void delete(FavoriteEntity favoriteEntity);

}
