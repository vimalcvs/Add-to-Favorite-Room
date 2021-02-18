package com.vimalcvs.musicplayer;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {

    private FavoriteAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        List<FavoriteEntity> favorites = MainActivity.favoriteDatabase.favoriteDao().getFavoriteData();

        RecyclerView rv = findViewById(R.id.rec);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter=new FavoriteAdapter(favorites,getApplicationContext());
        rv.setAdapter(adapter);
    }
}
