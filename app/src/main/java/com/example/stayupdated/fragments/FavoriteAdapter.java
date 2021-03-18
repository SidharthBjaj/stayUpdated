package com.example.stayupdated.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stayupdated.NewAdapter;
import com.example.stayupdated.R;
import com.example.stayupdated.pojo.favorite;
import com.example.stayupdated.pojo.news;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.CustomerViewHolder>{
    

        private ArrayList<favorite> favoriteItems;
        private Context context;

        public FavoriteAdapter(ArrayList<favorite> favoriteItems, Context context){
            this.favoriteItems = favoriteItems;
            this.context = context;
        }
        @NonNull
        @Override
        public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
            return new CustomerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {

            favorite favorite = favoriteItems.get(position);
            holder.heading.setText(favorite.getHeading());
            holder.description.setText(favorite.getDescription());
            Picasso.get().load(favorite.getImageUrl())
                    .placeholder(R.drawable.ic_baseline_attachment_24)
                    .into(holder.Image);
        }

        @Override
        public int getItemCount() {
            return favoriteItems.size();
        }

        class CustomerViewHolder extends RecyclerView.ViewHolder{

            public TextView heading;
            public TextView description;
            public ImageView Image;

            public CustomerViewHolder(@NonNull View itemView) {
                super(itemView);
                heading = itemView.findViewById(R.id.newsHead);
                description = itemView.findViewById(R.id.newsDesc);
                Image = itemView.findViewById(R.id.imageCard);

            }
        }
    }
