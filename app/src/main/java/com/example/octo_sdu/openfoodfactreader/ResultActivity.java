package com.example.octo_sdu.openfoodfactreader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.octo_sdu.openfoodfactreader.interactor.Interactor;
import com.example.octo_sdu.openfoodfactreader.interactor.InteractorDecorate;
import com.example.octo_sdu.openfoodfactreader.presenter.Presenter;
import com.example.octo_sdu.openfoodfactreader.repository.Repository;
import com.example.octo_sdu.openfoodfactreader.view.ViewValidate;
import com.example.octo_sdu.openfoodfactreader.view.ViewValidateDecorate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity implements ViewValidate {
    @BindView(R.id.textViewNameFood)
    TextView textViewNameFood;
    @BindView(R.id.imageviewFood)
    ImageView imageViewFood;
    @BindView(R.id.textViewBrandFood)
    TextView textViewBrandFood;
    @BindView(R.id.textViewIngredientFood)
    TextView textViewIngredientFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);

        Interactor interactor = new InteractorDecorate(new Repository(), new Presenter(new ViewValidateDecorate(this)));
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String barcode = extras.getString("barcode");
            interactor.findFoodByBarcode(barcode);
        }
    }

    @Override
    public void onSuccess(String product_name_fr, String image_url, String brands, String ingredients_text_fr, String quantity) {
        textViewNameFood.setText(product_name_fr);
        Glide.with(this).load(image_url).into(imageViewFood);
        textViewBrandFood.setText(brands);
        textViewIngredientFood.setText(ingredients_text_fr);
    }

    @Override
    public void onFailure(String result) {
        textViewNameFood.setText(result);
    }
}
