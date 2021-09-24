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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<ResponseItem> list;

    public Adapter(List<ResponseItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResponseItem responseItem = list.get(position);
        holder.setData(responseItem);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image, add;
        private TextView name, price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initViews(itemView);
        }

        private void initViews(View v) {
            image = v.findViewById(R.id.productImage);
            add = v.findViewById(R.id.add);
            name = v.findViewById(R.id.productName);
            price = v.findViewById(R.id.productPrice);
        }

        void setData(ResponseItem responseItem) {
            Glide.with(image).load(responseItem.getMedia().getImageUrl()).placeholder(R.drawable.ic_image).into(image);
            name.setText(responseItem.getName());
            price.setText(responseItem.getRetailPrice() + "");
        }
    }
}
