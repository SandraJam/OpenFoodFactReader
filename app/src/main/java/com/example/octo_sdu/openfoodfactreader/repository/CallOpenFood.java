package com.example.octo_sdu.openfoodfactreader.repository;

import com.example.octo_sdu.openfoodfactreader.bean.Search;
import com.example.octo_sdu.openfoodfactreader.bean.Searchs;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CallOpenFood {
    String URL = "http://fr.openfoodfacts.org";

    @GET("/api/v0/produit/{barcode}.json")
    Call<Search> findByCode(@Path("barcode") String barcode);

    @GET("/cgi/search.pl?json=1")
    Call<Searchs> findByWord(@Query("search_terms") String search, @Query("page") int page);
}
