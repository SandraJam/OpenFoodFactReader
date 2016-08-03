package com.example.octo_sdu.openfoodfactreader.repository;

import com.example.octo_sdu.openfoodfactreader.ManageFood;
import com.example.octo_sdu.openfoodfactreader.bean.Product;
import com.example.octo_sdu.openfoodfactreader.bean.Search;
import com.example.octo_sdu.openfoodfactreader.bean.Searchs;
import com.example.octo_sdu.openfoodfactreader.interactor.Interactor;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class Repository {

    public static final String SEARCH_NULL = "La recherche ne retourne aucun résultat.";
    public static final String NETWORK_PROBLEM = "Problème de Connexion.";
    public static final String PRODUCT_NULL = "Le produit est n'existe pas.";

    private Interactor interactor = null;
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(CallOpenFood.URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build();
    private CallOpenFood callOpenFood = retrofit.create(CallOpenFood.class);
    private ManageFood manageFood = new ManageFood();

    public void findFoodByBarcode(String barcode) {
        final Call<Search> validCall = callOpenFood.findByCode(barcode);
        try {
            Search search = validCall.execute().body();
            if (search != null) {
                Product result = manageFood.checkProduct(search.getProduct());
                if (result != null)
                    interactor.onSuccess(result);
                else
                    interactor.onFailure(PRODUCT_NULL);
            }else {
                interactor.onFailure(SEARCH_NULL);
            }
        } catch (IOException e) {
            interactor.onFailure(NETWORK_PROBLEM);
        }
    }

    public void setInteractor(Interactor interactor) {
        this.interactor = interactor;
    }

    public void findFoodBySearch(String search, int page) {
        final Call<Searchs> validCall = callOpenFood.findByWord(search, page);
        try {
            Searchs searchs = validCall.execute().body();
            if (searchs != null) {
                List<Product> products = manageFood.checkProducts(searchs.getProducts());
                if (products != null)
                    interactor.onSuccessMany(products);
                else
                    interactor.onFailure(PRODUCT_NULL);
            }else {
                interactor.onFailure(SEARCH_NULL);
            }
        } catch (IOException e) {
            interactor.onFailure(NETWORK_PROBLEM);
        }
    }
}
