package com.favorite.roomdatabase.ui;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllData(FavoriteModel model);

    @Query("SELECT * FROM favorite_table")
    List<FavoriteModel> getAllData();

    @Query("SELECT EXISTS (SELECT 1 FROM favorite_table WHERE id = :id)")
    boolean isFavorite(int id);

    @Query("DELETE FROM favorite_table WHERE id = :id")
    void deleteData(int id);
}
