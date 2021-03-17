package com.example.stayupdated;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stayupdated.pojo.news;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
//        Spons location = locations.get(position);
        news news = newsItems.get(position);
        holder.heading.setText(news.getHeading());
        holder.description.setText(news.getDescription());
        Picasso.get().load(news.getImageUrl())
                .placeholder(R.drawable.ic_baseline_attachment_24)
                .into(holder.Image);

    }

    @Override
    public int getItemCount() {
        return 0;
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
