package com.vimalcvs.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private final List<FavoriteEntity> favoriteListEnteties;
    Context context;

    public FavoriteAdapter(List<FavoriteEntity> favoriteListEnteties, Context context) {
        this.favoriteListEnteties = favoriteListEnteties;
        this.context = context;
    }

    @NonNull
    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.favorites_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.ViewHolder holder, int position) {
        FavoriteEntity fl= favoriteListEnteties.get(position);
        holder.hindi.setText(fl.getHindi());
        holder.english.setText(fl.getEnglish());

    }

    @Override
    public int getItemCount() {
        return favoriteListEnteties.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView hindi,english;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hindi = itemView.findViewById(R.id.fimg_pr);
            english =itemView.findViewById(R.id.ftv_name);

        }
    }
}
