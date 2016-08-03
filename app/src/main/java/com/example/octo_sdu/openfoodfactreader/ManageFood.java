package com.example.octo_sdu.openfoodfactreader;

import com.example.octo_sdu.openfoodfactreader.bean.Product;

import java.util.ArrayList;
import java.util.List;

public class ManageFood {

    public Product checkProduct(Product product) {
        if (product == null)
            return null;
        if (product.getImage_url() == null)
            product.setImage_url("");
        if (product.getBrands() == null)
            product.setBrands("");
        if (product.getProduct_name() == null)
            product.setProduct_name("");
        if (product.getProduct_name_fr() == null || product.getProduct_name_fr().equals(""))
            product.setProduct_name_fr(product.getProduct_name());
        if (product.getIngredients_text_fr() == null)
            product.setIngredients_text_fr("");
        return product;
    }

    public List<Product> checkProducts(List<Product> products) {
        if (products == null)
            return null;
        List<Product> productList = new ArrayList<>();
        for (Product product:products) {
            Product result = checkProduct(product);
            if (result != null)
                productList.add(result);
        }
        return productList;
    }
}
