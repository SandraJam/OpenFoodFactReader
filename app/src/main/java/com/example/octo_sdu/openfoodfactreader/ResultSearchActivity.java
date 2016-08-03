package com.example.octo_sdu.openfoodfactreader;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.octo_sdu.openfoodfactreader.interactor.Interactor;
import com.example.octo_sdu.openfoodfactreader.interactor.InteractorDecorate;
import com.example.octo_sdu.openfoodfactreader.presenter.Presenter;
import com.example.octo_sdu.openfoodfactreader.repository.Repository;
import com.example.octo_sdu.openfoodfactreader.view.ViewProductAdapter;
import com.example.octo_sdu.openfoodfactreader.view.ViewValidate;
import com.example.octo_sdu.openfoodfactreader.view.ViewValidateDecorate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultSearchActivity extends AppCompatActivity implements ViewValidate{
    private static final int SPAN_COUNT_PORTRAIT = 2;
    private static final int SPAN_COUNT_LANDSCAPE = 4;
    @BindView(R.id.recyclerview_products)
    RecyclerView recyclerViewProducts;
    ViewProductAdapter viewProductAdapter = new ViewProductAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_search);
        ButterKnife.bind(this);

        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewProducts.setAdapter(viewProductAdapter);
        recyclerViewProducts.setLayoutManager(new GridLayoutManager(this, getSpanCount()));

        final Interactor interactor = new InteractorDecorate(new Repository(), new Presenter(new ViewValidateDecorate(this)));
        Bundle extras = getIntent().getExtras();
        String search;
        if (extras != null) {
            search = extras.getString("search");
            if (search != null && search.length() > 1)
                search = search.substring(0,1).toUpperCase()+search.substring(1);
            interactor.findFoodBySearch(search);
        }
    }

    private int getSpanCount() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            return SPAN_COUNT_PORTRAIT;
        } else {
            return SPAN_COUNT_LANDSCAPE;
        }
    }

    @Override
    public void onSuccess(String product_name_fr, String image_url, String brands, String ingredients_text_fr, String quantity) {
        viewProductAdapter.productName.add(product_name_fr+" - "+quantity);
        viewProductAdapter.productImage.add(image_url);
        viewProductAdapter.notifyItemInserted(viewProductAdapter.productName.size()-1);
    }

    @Override
    public void onFailure(String result) {
        finish();
    }
}
