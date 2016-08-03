package com.example.octo_sdu.openfoodfactreader.view;

public interface ViewValidate {

    void onSuccess(String product_name_fr, String image_url, String brands, String ingredients_text_fr, String quantity);

    void onFailure(String result);
}
