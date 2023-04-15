package com.favorite.roomdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.favorite.roomdatabase.ui.FavoriteDao;
import com.favorite.roomdatabase.ui.FavoriteModel;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final List<MyModel> list;
    private final FavoriteDao favoriteDao;

    public MyAdapter(List<MyModel> list, FavoriteDao favoriteDao) {
        this.list = list;
        this.favoriteDao = favoriteDao;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_layout, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        MyModel model = list.get(position);
        holder.hindi.setText(model.hindi);
        holder.english.setText(model.english);

        boolean isFavorite = favoriteDao.isFavorite(model.id);
        if (isFavorite) {
            holder.iv_favorite.setImageResource(R.drawable.ic_favorite);
        } else {
            holder.iv_favorite.setImageResource(R.drawable.ic_favorite_border);
        }

        holder.iv_favorite.setOnClickListener(view -> {
            boolean isCurrentlyFavorite = favoriteDao.isFavorite(model.id);
            if (isCurrentlyFavorite) {
                favoriteDao.deleteData(model.id);
                holder.iv_favorite.setImageResource(R.drawable.ic_favorite_border);
            } else {
                favoriteDao.insertAllData(new FavoriteModel(model.id, model.hindi, model.english));
                holder.iv_favorite.setImageResource(R.drawable.ic_favorite);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView hindi;
        public TextView english;
        public ImageView iv_favorite;

        public ViewHolder(View view) {
            super(view);
            iv_favorite = view.findViewById(R.id.iv_favorite);
            hindi = view.findViewById(R.id.hindi);
            english = view.findViewById(R.id.english);

        }
    }
}
