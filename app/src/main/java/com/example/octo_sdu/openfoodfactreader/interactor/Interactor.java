package com.example.octo_sdu.openfoodfactreader.interactor;

import com.example.octo_sdu.openfoodfactreader.bean.Product;

import java.util.List;

public interface Interactor {
    void findFoodByBarcode(String barcode);

    void onSuccess(Product product);

    void onFailure(String result);

    void findFoodBySearch(String search);

    void onSuccessMany(List<Product> products);
}
