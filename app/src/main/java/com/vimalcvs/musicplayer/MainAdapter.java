package com.vimalcvs.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    List<MainModel> product_models;
    Context ct;

    public MainAdapter(List<MainModel> product_models, Context ct) {
        this.product_models = product_models;
        this.ct = ct;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        final MainModel productList = product_models.get(position);

        holder.english.setText(productList.getEnglish());
        holder.hindi.setText(productList.getHindi());


        if (MainActivity.favoriteDatabase.favoriteDao().isFavorite(productList.getId())==1)
            holder.favorite.setImageResource(R.drawable.ic_favorite);
        else
            holder.favorite.setImageResource(R.drawable.ic_favorite_border);


        holder.favorite.setOnClickListener(v -> {
            FavoriteEntity favoriteEntity =new FavoriteEntity();

            int id = productList.getId();
            String hindi = productList.getHindi();
            String english = productList.getEnglish();

            favoriteEntity.setId(id);
            favoriteEntity.setHindi(hindi);
            favoriteEntity.setEnglish(english);

            if (MainActivity.favoriteDatabase.favoriteDao().isFavorite(id)!=1){
                holder.favorite.setImageResource(R.drawable.ic_favorite);
                MainActivity.favoriteDatabase.favoriteDao().addData(favoriteEntity);
            }else {
                holder.favorite.setImageResource(R.drawable.ic_favorite_border);
                MainActivity.favoriteDatabase.favoriteDao().delete(favoriteEntity);
            }
        });
    }
    @Override
    public int getItemCount() {
        return product_models.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView favorite;
        TextView hindi, english;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hindi = (TextView)itemView.findViewById(R.id.hindi);
            english =(TextView)itemView.findViewById(R.id.english);
            favorite=(ImageView)itemView.findViewById(R.id.favorite);


        }
    }
}
