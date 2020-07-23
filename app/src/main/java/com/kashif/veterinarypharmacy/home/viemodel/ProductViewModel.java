package com.kashif.veterinarypharmacy.home.viemodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.kashif.veterinarypharmacy.home.model.ProductModel;
import com.kashif.veterinarypharmacy.home.repository.HomeRepository;
import com.kashif.veterinarypharmacy.home.repository.ProductRepsitory;

import java.util.List;

public class ProductViewModel extends ViewModel {

    ProductRepsitory productRepsitory;

    public void Init()
    {
        if(productRepsitory!=null)
        {
            return;
        }

        productRepsitory  = ProductRepsitory.getInstance();

    }

    public LiveData<List<ProductModel>> getProducts()
    {
        return productRepsitory.getProudcts();
    }


}
