package com.ranzan.sneakership.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ranzan.sneakership.R;
import com.ranzan.sneakership.api.ResponseItem;

import java.util.ArrayList;
import java.util.List;

public class BagAdapter extends RecyclerView.Adapter<BagAdapter.BagViewHolder> {
    private List<ResponseItem> list = new ArrayList<>();


    public BagAdapter(List<ResponseItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public BagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        return new BagViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BagViewHolder holder, int position) {
        ResponseItem responseItem = list.get(position);
        holder.setData(responseItem);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class BagViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView name, price;

        public BagViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.bagImage);
            name = itemView.findViewById(R.id.bagName);
            price = itemView.findViewById(R.id.bagPrice);
        }

        void setData(ResponseItem responseItem) {
            Glide.with(imageView).load(responseItem.getMedia().getImageUrl()).into(imageView);
            name.setText(responseItem.getName());
            price.setText(responseItem.getRetailPrice() + "");
        }
    }
}
