package com.ranzan.sneakership.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ranzan.sneakership.ItemClicked;
import com.ranzan.sneakership.R;
import com.ranzan.sneakership.api.ResponseItem;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<ResponseItem> list;
    private ItemClicked itemClicked;

    public Adapter(List<ResponseItem> list, ItemClicked itemClicked) {
        this.list = list;
        this.itemClicked = itemClicked;
    }

    public Adapter(List<ResponseItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view, itemClicked);
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
        private ConstraintLayout constraintLayout;
        private ItemClicked itemClicked;

        public ViewHolder(@NonNull View itemView, ItemClicked itemClicked) {
            super(itemView);
            this.itemClicked = itemClicked;
            initViews(itemView);
        }

        private void initViews(View v) {
            image = v.findViewById(R.id.productImage);
            add = v.findViewById(R.id.add);
            name = v.findViewById(R.id.productName);
            price = v.findViewById(R.id.productPrice);
            constraintLayout = v.findViewById(R.id.itemClick);
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClicked.OnItemClicked(getAdapterPosition());
                }
            });
        }

        void setData(ResponseItem responseItem) {
            Glide.with(image).load(responseItem.getMedia().getImageUrl()).placeholder(R.drawable.ic_image).into(image);
            name.setText(responseItem.getName());
            price.setText(responseItem.getRetailPrice() + "");
        }
    }
}
