package com.example.octo_sdu.openfoodfactreader.presenter;

import com.example.octo_sdu.openfoodfactreader.bean.Product;
import com.example.octo_sdu.openfoodfactreader.view.ViewValidate;

import java.util.List;

public class Presenter {
    private ViewValidate viewValidate;

    public Presenter(ViewValidate viewValidate) {
        this.viewValidate = viewValidate;
    }

    public void onSuccess(Product product) {
        viewValidate.onSuccess(product.getProduct_name_fr(), product.getImage_url(), product.getBrands(), product.getIngredients_text_fr(), product.getQuantity());
    }

    public void onFailure(String result) {
        viewValidate.onFailure(result);
    }

    public void onSuccessMany(List<Product> products) {
        for (Product product :
                products) {
            viewValidate.onSuccess(product.getProduct_name_fr(), product.getImage_url(), product.getBrands(), product.getIngredients_text_fr(), product.getQuantity());
        }
    }
}
