package com.example.octo_sdu.openfoodfactreader.bean;

import java.util.Arrays;

public class Product
{
    private String product_name;

    private String image_url;

    private String ingredients_text_fr;

    private Ingredients[] ingredients;

    private Nutriments nutriments;

    private String quantity;

    private String categories;

    private String product_name_fr;

    private String serving_size;

    private String brands;


    public Product() {
    }


    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getIngredients_text_fr() {
        return ingredients_text_fr;
    }

    public void setIngredients_text_fr(String ingredients_text_fr) {
        this.ingredients_text_fr = ingredients_text_fr;
    }

    public Ingredients[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients[] ingredients) {
        this.ingredients = ingredients;
    }

    public Nutriments getNutriments() {
        return nutriments;
    }

    public void setNutriments(Nutriments nutriments) {
        this.nutriments = nutriments;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getProduct_name_fr() {
        return product_name_fr;
    }

    public void setProduct_name_fr(String product_name_fr) {
        this.product_name_fr = product_name_fr;
    }

    public String getServing_size() {
        return serving_size;
    }

    public void setServing_size(String serving_size) {
        this.serving_size = serving_size;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_name='" + product_name + '\'' +
                ", image_front_url='" + image_url + '\'' +
                ", ingredients_text_fr='" + ingredients_text_fr + '\'' +
                ", ingredients=" + Arrays.toString(ingredients) +
                ", nutriments=" + nutriments +
                ", quantity='" + quantity + '\'' +
                ", categories='" + categories + '\'' +
                ", product_name_fr='" + product_name_fr + '\'' +
                ", serving_size='" + serving_size + '\'' +
                '}';
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }
}