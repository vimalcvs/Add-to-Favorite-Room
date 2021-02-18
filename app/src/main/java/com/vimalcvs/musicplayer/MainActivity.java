package com.vimalcvs.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String HI = "http://technovimal.in/apps/fast-english/beers.json";
    private List<MainModel> product_models;
    private RecyclerView recyclerView;



    MainAdapter adapter;
    public static FavoriteDatabase favoriteDatabase;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        product_models = new ArrayList<>();
        btn = (Button) findViewById(R.id.favbtn);

        btn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FavoriteActivity.class)));


        favoriteDatabase = Room.databaseBuilder(getApplicationContext(), FavoriteDatabase.class, "myfavdb").allowMainThreadQueries().build();


        getData();
    }

    private void getData() {
        JsonArrayRequest request = new JsonArrayRequest(HI, response -> {
            for (int i = 0; i < response.length(); i++) {
                try {
                    JSONObject ob = response.getJSONObject(i);
                    MainModel pr = new MainModel(ob.getInt("id"),
                            ob.getString("hindi"),
                            ob.getString("english"));
                    product_models.add(pr);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            setupData(product_models);
        }, error -> {

        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    private void setupData(List<MainModel> product_models) {
        adapter = new MainAdapter(product_models, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
}
