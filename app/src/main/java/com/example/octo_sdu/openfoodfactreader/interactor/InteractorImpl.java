package com.example.octo_sdu.openfoodfactreader.interactor;

import com.example.octo_sdu.openfoodfactreader.bean.Product;
import com.example.octo_sdu.openfoodfactreader.presenter.Presenter;
import com.example.octo_sdu.openfoodfactreader.repository.Repository;

import java.util.List;

public class InteractorImpl implements Interactor{
    private Repository repository;
    private Presenter presenter;

    public InteractorImpl(Repository repository, Presenter presenter) {
        this.repository = repository;
        this.presenter = presenter;

        repository.setInteractor(this);
    }

    public void findFoodByBarcode(String barcode) {
        repository.findFoodByBarcode(barcode);
    }

    @Override
    public void onSuccess(Product product) {
        presenter.onSuccess(product);
    }

    @Override
    public void onFailure(String result) {
        presenter.onFailure(result);
    }

    /** TODO
     * Ajout PAGINATION
     * @param search
     */
    @Override
    public void findFoodBySearch(String search) {
        repository.findFoodBySearch(search, 1);
    }

    @Override
    public void onSuccessMany(List<Product> products) {
        presenter.onSuccessMany(products);
    }
}
