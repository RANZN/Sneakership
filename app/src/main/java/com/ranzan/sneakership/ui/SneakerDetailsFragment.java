package com.ranzan.sneakership.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.ranzan.sneakership.R;
import com.ranzan.sneakership.api.ResponseItem;

public class SneakerDetailsFragment extends Fragment {
    private ImageView image, back;
    private TextView title, brand, price;
    private Button addToCart;
    private NavController navController;
    private ResponseItem item;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sneaker_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        initViews(view);
        if (getArguments() != null) {
            item = getArguments().getParcelable("data");
            title.setText(item.getName());
            brand.setText(item.getBrand());
            price.setText(item.getRetailPrice() + "");
            Glide.with(image).load(item.getMedia().getImageUrl()).placeholder(R.drawable.ic_image).into(image);
        }
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToCart();
            }
        });
    }

    private void addItemToCart() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("cart", item);
        navController.navigate(R.id.action_sneakerDetailsFragment_to_checkOutFragment,bundle);
    }

    private void initViews(View view) {
        back = view.findViewById(R.id.back);
        image = view.findViewById(R.id.productDetailImage);
        title = view.findViewById(R.id.productDetailedName);
        brand = view.findViewById(R.id.productBrand);
        addToCart = view.findViewById(R.id.addToCart);
        price = view.findViewById(R.id.productPrice);
    }
}