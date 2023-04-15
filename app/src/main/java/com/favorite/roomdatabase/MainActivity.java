package com.favorite.roomdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.favorite.roomdatabase.ui.FavoriteActivity;
import com.favorite.roomdatabase.ui.FavoriteDao;
import com.favorite.roomdatabase.ui.FavoriteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FavoriteDao mFavoriteDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FavoriteDatabase db = FavoriteDatabase.getDatabase(this);
        mFavoriteDao = db.getDao();

        Button save = findViewById(R.id.btn_getData);
        save.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), FavoriteActivity.class)));

        getData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    private void getData() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<MyModel> list = new ArrayList<>();
        list.add(new MyModel(1, "What", "क्या"));
        list.add(new MyModel(2, "How", "कैसे"));
        list.add(new MyModel(3, "Where", "कहाँ"));
        list.add(new MyModel(4, "When", "कब"));
        list.add(new MyModel(5, "Who", "कौन"));
        list.add(new MyModel(6, "Why", "क्यों"));
        list.add(new MyModel(7, "Which", "कौन सा"));
        list.add(new MyModel(8, "Hello", "नमस्ते"));
        list.add(new MyModel(9, "Goodbye", "अलविदा"));
        list.add(new MyModel(10, "Thank you", "धन्यवाद"));
        MyAdapter adapter = new MyAdapter(list, mFavoriteDao);
        recyclerView.setAdapter(adapter);
    }

}
