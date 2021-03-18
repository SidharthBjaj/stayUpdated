package com.example.stayupdated;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.stayupdated.pojo.news;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

        news news = newsItems.get(position);
        holder.heading.setText(news.getHeading());
        holder.description.setText(news.getDescription());
        Picasso.get().load(news.getImageUrl())
                .placeholder(R.drawable.ic_baseline_attachment_24)
                .into(holder.Image);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(news.getDetailUrl()));
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

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.newsHead);
            description = itemView.findViewById(R.id.newsDesc);
            Image = itemView.findViewById(R.id.imageCard);
            layout = itemView.findViewById(R.id.layout_const);

        }
    }
}
