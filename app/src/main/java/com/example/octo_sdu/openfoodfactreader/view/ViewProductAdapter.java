package com.example.octo_sdu.openfoodfactreader.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.octo_sdu.openfoodfactreader.R;

import java.util.ArrayList;
import java.util.List;

public class ViewProductAdapter  extends RecyclerView.Adapter<ViewProductHolder> {
    public List<String> productName = new ArrayList<>();
    public List<String> productImage = new ArrayList<>();

    public ViewProductAdapter() {
    }

    @Override
    public ViewProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewProductHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_result_search, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewProductHolder holder, int position) {
        holder.bind(productName.get(position), productImage.get(position));
    }

    @Override
    public int getItemCount() {
        return productName.size();
    }
}