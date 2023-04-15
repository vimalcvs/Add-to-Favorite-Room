package com.favorite.roomdatabase.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.favorite.roomdatabase.R;

import java.util.List;

public class FavoriteActivity extends AppCompatActivity {

    private FavoriteDao mFavoriteDao;
    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerview = findViewById(R.id.recyclerview);


        FavoriteDatabase db = FavoriteDatabase.getDatabase(this);
        mFavoriteDao = db.getDao();

    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    private void getData() {
        List<FavoriteModel> list = FavoriteDatabase.getDatabase(getApplicationContext()).getDao().getAllData();
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(new FavoriteAdapter(getApplicationContext(), mFavoriteDao, list, (position, id) -> {
            FavoriteDatabase.getDatabase(getApplicationContext()).getDao().deleteData(id);
            getData();
        }));

        ImageView emptyImage = findViewById(R.id.empty_image);
        if (list.isEmpty()) {
            emptyImage.setVisibility(View.VISIBLE);
        } else {
            emptyImage.setVisibility(View.GONE);
        }
    }

}