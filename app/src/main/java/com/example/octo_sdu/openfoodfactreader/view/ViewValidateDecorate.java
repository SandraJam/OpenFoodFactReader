package com.example.octo_sdu.openfoodfactreader.view;

import android.os.Handler;
import android.os.Looper;

public class ViewValidateDecorate implements ViewValidate {
    private ViewValidate viewValidate;

    public ViewValidateDecorate(ViewValidate viewValidate) {
        this.viewValidate = viewValidate;
    }

    @Override
    public void onSuccess(final String product_name_fr, final String image_url, final String brands, final String ingredients_text_fr, final String quantity) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                viewValidate.onSuccess(product_name_fr, image_url, brands, ingredients_text_fr, quantity);
            }
        });
    }

    @Override
    public void onFailure(final String result) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                viewValidate.onFailure(result);
            }
        });
    }
}
