package com.ranzan.sneakership.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ranzan.sneakership.R;
import com.ranzan.sneakership.adapter.BagAdapter;
import com.ranzan.sneakership.api.ResponseItem;

import java.util.ArrayList;
import java.util.List;


public class CheckOutFragment extends Fragment {
    private List<ResponseItem> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private BagAdapter adapter;
    private static int total = 0;
    private TextView tvTotal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_check_out, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvTotal = view.findViewById(R.id.tvTotal);
        recyclerView = view.findViewById(R.id.bagRecycerView);
        setRecyclerView();
        if (getArguments() != null) {
            ResponseItem item = getArguments().getParcelable("cart");
            total += item.getRetailPrice();
            list.add(item);
            adapter.notifyDataSetChanged();
            tvTotal.setText(total + "");
        }
    }

    private void setRecyclerView() {
        adapter = new BagAdapter(list);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}