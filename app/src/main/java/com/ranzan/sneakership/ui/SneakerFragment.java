package com.ranzan.sneakership.ui;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ranzan.sneakership.ItemClicked;
import com.ranzan.sneakership.R;
import com.ranzan.sneakership.adapter.Adapter;
import com.ranzan.sneakership.api.ResponseItem;
import com.ranzan.sneakership.network.ApiService;
import com.ranzan.sneakership.network.Network;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SneakerFragment extends Fragment implements ItemClicked {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private List<ResponseItem> list = new ArrayList<>();
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sneaker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        initViews(view);
        setRecyclerView();
        fetchData();
    }

    private void fetchData() {
        ApiService apiService = Network.getRetrofitInstance().create(ApiService.class);
        apiService.getResponse().enqueue(new Callback<List<ResponseItem>>() {
            @Override
            public void onResponse(Call<List<ResponseItem>> call, Response<List<ResponseItem>> response) {
                list.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ResponseItem>> call, Throwable t) {

            }
        });
    }

    private void setRecyclerView() {
        adapter = new Adapter(list, this);
        recyclerView.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void initViews(View v) {
        recyclerView = v.findViewById(R.id.recyclerView);
    }


    @Override
    public void OnItemClicked(int position) {
        ResponseItem responseItem = list.get(position);
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", (Parcelable) responseItem);
        navController.navigate(R.id.action_sneakerFragment_to_sneakerDetailsFragment, bundle);
    }
}