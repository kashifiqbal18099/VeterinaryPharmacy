package com.kashif.veterinarypharmacy.home.viemodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kashif.veterinarypharmacy.home.model.HomeCategoryResponse;
import com.kashif.veterinarypharmacy.home.model.HomeCategorymodel;
import com.kashif.veterinarypharmacy.home.model.HomeTopRatedProduct;
import com.kashif.veterinarypharmacy.home.model.ProductModel;
import com.kashif.veterinarypharmacy.home.repository.HomeRepository;
import com.kashif.veterinarypharmacy.network.ApiClientSet;
import com.kashif.veterinarypharmacy.network.NetworkState;
import com.kashif.veterinarypharmacy.network.Resource;
import com.kashif.veterinarypharmacy.network.RetrofitServices;

import java.util.List;

import retrofit2.Retrofit;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<List<String>> sliderimages;
    HomeRepository homeRepository;
    RetrofitServices retrofitServices;

    public void Init()
    {
        Retrofit retrofit= ApiClientSet.getClient();
        retrofitServices  = retrofit.create(RetrofitServices.class);
        if(homeRepository!=null)
        {
            return;
        }

        homeRepository  = HomeRepository.getInstance(retrofitServices);

    }

    public LiveData<List<String>> getSliderImages(){
        sliderimages  = homeRepository.getSliders();
        return sliderimages;
    }


    public LiveData<List<HomeCategorymodel>> getHomeCategries()
    {
        return homeRepository.getHomeCategories();
    }


    public LiveData<Resource<HomeCategoryResponse>> getHomeCategoriesandSlider()
    {
       return homeRepository.getHomeCategriesandSlider();
    }


    public LiveData<List<HomeTopRatedProduct>> getHomeTopRatedProducts()
    {
        return homeRepository.getHomeTopRatedProducts();
    }
    public LiveData<List<ProductModel>> getProducts()
    {
        return homeRepository.getProudcts();
    }

    public LiveData<NetworkState> getnetworkstate()
    {
        return homeRepository.getNetworkState();
    }
}
