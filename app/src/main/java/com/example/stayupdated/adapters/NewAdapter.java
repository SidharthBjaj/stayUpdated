package com.example.stayupdated.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stayupdated.DetailsActivity;
import com.example.stayupdated.R;
import com.example.stayupdated.database.database;
import com.example.stayupdated.pojo.favorite;
import com.example.stayupdated.pojo.news;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.CustomerViewHolder>{

    private ArrayList<news> newsItems;
    private Context context;
    private int size;

    public NewAdapter(ArrayList<news> newsItems, Context context, int size){
        this.newsItems = newsItems;
        this.context = context;
        this.size = size;

    }
    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_item,parent,false);
        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {

        news news = newsItems.get(position);
        holder.heading.setText(news.getHeading());
        holder.description.setText(news.getDescription());
        holder.source.setText(news.getSource());
        if (holder.Image != null) {
            Picasso.get().load(news.getImageUrl())
                    .placeholder(R.drawable.ic_baseline_add_circle_outline_24)
                    .into(holder.Image);
        }
        else {
            holder.Image.setImageResource(R.drawable.googlemaps);
        }

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("title",news.getHeading());
                intent.putExtra("abstract",news.getDescription());
                intent.putExtra("byLine",news.getSource());
                intent.putExtra("url",news.getDetailUrl());
                intent.putExtra("urlToImage",news.getImageUrl());
                context.startActivity(intent);
            }
        });

        /**
         * adding the data for favorite page along with adding the information to database for addition editing of reader with notes.
         */
        holder.layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                database db = new database(context);
                db.addFavorite(new favorite(news.heading,news.description,news.imageUrl));
                CharSequence text = "Article added to database";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                return true;
            }
        });

        holder.description.setTextSize(size);
        holder.heading.setTextSize(size);
        holder.source.setTextSize(size);

    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    class CustomerViewHolder extends RecyclerView.ViewHolder  {

        public TextView heading;
        public TextView description;
        public ImageView Image;
        public ConstraintLayout layout;
        public TextView source;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.newsHeadFav);
            description = itemView.findViewById(R.id.newsDescFav);
            Image = itemView.findViewById(R.id.imageFav);
            layout = itemView.findViewById(R.id.layout_const_fav);
            source = itemView.findViewById(R.id.sourceNews);
            description.setTextSize(14);
            heading.setTextSize(14);
            source.setTextSize(14);
        }

    }


}
