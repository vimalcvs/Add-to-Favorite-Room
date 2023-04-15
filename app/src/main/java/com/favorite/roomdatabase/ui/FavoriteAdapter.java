package com.favorite.roomdatabase.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.favorite.roomdatabase.R;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    public final Context context;
    private final List<FavoriteModel> list;
    private final DeleteItemClickListner deleteItemClickListner;
    private final FavoriteDao mFavoriteDao;

    public FavoriteAdapter(Context context, FavoriteDao favoriteDao, List<FavoriteModel> list, DeleteItemClickListner deleteItemClickListner) {
        this.context = context;
        this.mFavoriteDao = favoriteDao;
        this.list = list;
        this.deleteItemClickListner = deleteItemClickListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        FavoriteModel model = list.get(position);

        holder.hindi.setText(model.hindi);
        holder.english.setText(model.english);

        boolean isFavorite = mFavoriteDao.isFavorite(model.id);
        if (isFavorite) {
            holder.iv_favorite.setImageResource(R.drawable.ic_favorite);
        } else {
            holder.iv_favorite.setImageResource(R.drawable.ic_favorite_border);
        }

        holder.iv_favorite.setOnClickListener(view -> deleteItemClickListner.onItemDelete(position, list.get(position).id));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface DeleteItemClickListner {
        void onItemDelete(int position, int id);
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
