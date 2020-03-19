package com.example.jayshri.imagelibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder>{

    List<String> urls;
    Context context;

    public ImageAdapter(List<String> urls, Context context){
        this.urls = urls;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);
        v.setLayoutParams(new RecyclerView.LayoutParams(1080,800));
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide
            .with(context)
            .load(urls.get(position))
            .apply(new RequestOptions()
            .placeholder(R.mipmap.ic_launcher)
            .fitCenter())
            .into(holder.getImage());
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);
            image =(ImageView)itemView.findViewById(R.id.img);
        }

        public ImageView getImage(){ return this.image;}
    }

}


