package com.example.ss07networkrecycler.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ss07networkrecycler.R;
import com.example.ss07networkrecycler.model.Item;

import java.util.List;

public class NewAdapter extends RecyclerView.Adapter {
    private List<Item> list;
    private Activity activity;

    public NewAdapter(List<Item> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    public void reloadData(List<Item> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_news, parent, false);
        NewHolder holder = new NewHolder(itemView);
        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NewHolder hol = (NewHolder) holder;
        Item model = list.get(position);
        hol.tvDate.setText(model.getDate());
        hol.tvDate.setText(model.getTitle());
        hol.tvDate.setText(model.getContent().getDescription());
        Glide.with(activity).load(model.getImage()).into(hol.ivCover);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NewHolder extends RecyclerView.ViewHolder {

        TextView tvDate, tvTitle, tvContent;
        ImageView ivCover;

        public NewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvContent = itemView.findViewById(R.id.tvContent);
            tvDate = itemView.findViewById(R.id.tvDate);
            ivCover = itemView.findViewById(R.id.ivCover);

        }
    }

}
