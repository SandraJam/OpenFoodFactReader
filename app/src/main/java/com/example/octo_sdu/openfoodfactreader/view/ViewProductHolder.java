package com.example.octo_sdu.openfoodfactreader.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.octo_sdu.openfoodfactreader.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewProductHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.text_resultSearch)
    TextView textViewResultSearch;
    @BindView(R.id.image_resultSearch)
    ImageView imageViewResultSearch;

    public ViewProductHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind (String name, String image) {
        textViewResultSearch.setText(name);
        Glide.with(imageViewResultSearch.getContext()).load(image).into(imageViewResultSearch);
    }
}
