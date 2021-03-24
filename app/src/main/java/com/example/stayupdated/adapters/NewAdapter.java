package com.example.stayupdated.adapters;

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

import com.example.stayupdated.DetailsActivity;
import com.example.stayupdated.R;
import com.example.stayupdated.pojo.news;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.CustomerViewHolder>{

    private ArrayList<news> newsItems;
    private Context context;

    public NewAdapter(ArrayList<news> newsItems, Context context){
        this.newsItems = newsItems;
        this.context = context;
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
        holder.publish.setText(news.getPublishDate());
        holder.source.setText(news.getSource());
        Picasso.get().load(news.getImageUrl())
                .placeholder(R.drawable.ic_baseline_add_circle_outline_24)
                .into(holder.Image);
        
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailsActivity.class);
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(news.getDetailUrl()));
                intent.putExtra("title",news.getHeading());
                intent.putExtra("abstract",news.getDescription());
                intent.putExtra("byLine",news.getSource());
                intent.putExtra("url",news.getDetailUrl());
                intent.putExtra("urlToImage",news.getImageUrl());
//                intent.putExtra("")
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    class CustomerViewHolder extends RecyclerView.ViewHolder{

        public TextView heading;
        public TextView description;
        public ImageView Image;
        public ConstraintLayout layout;
        public TextView source;
        public TextView publish;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.newsHeadFav);
            description = itemView.findViewById(R.id.newsDescFav);
            Image = itemView.findViewById(R.id.imageFav);
            layout = itemView.findViewById(R.id.layout_const_fav);
            source = itemView.findViewById(R.id.sourceNews);
            publish = itemView.findViewById(R.id.publishDate);

        }
    }
}
