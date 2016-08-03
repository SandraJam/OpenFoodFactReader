package com.example.octo_sdu.openfoodfactreader.interactor;

import com.example.octo_sdu.openfoodfactreader.bean.Product;
import com.example.octo_sdu.openfoodfactreader.presenter.Presenter;
import com.example.octo_sdu.openfoodfactreader.repository.Repository;

import java.util.List;

public class InteractorDecorate implements Interactor {
    private Interactor interactor;

    public InteractorDecorate(Repository repository, Presenter presenter) {
        interactor = new InteractorImpl(repository, presenter);
    }

    @Override
    public void findFoodByBarcode(final String barcode) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                interactor.findFoodByBarcode(barcode);
            }
        }).start();
    }

    @Override
    public void onSuccess(Product product) {

    }

    @Override
    public void onFailure(String result) {

    }

    @Override
    public void findFoodBySearch(final String search) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                interactor.findFoodBySearch(search);
            }
        }).start();
    }

    @Override
    public void onSuccessMany(List<Product> products) {

    }
}
