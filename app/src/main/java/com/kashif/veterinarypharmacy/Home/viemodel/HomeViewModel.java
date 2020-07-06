package com.kashif.veterinarypharmacy.Home.viemodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.denzcoskun.imageslider.models.SlideModel;
import com.kashif.veterinarypharmacy.Home.repository.HomeRepository;

import java.util.List;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<List<SlideModel>> sliderimages;
    HomeRepository homeRepository;

    public void Init()
    {
        if(homeRepository!=null)
        {
            return;
        }

        homeRepository  = HomeRepository.getInstance();

    }

    public LiveData<List<SlideModel>> getSliderImages(){
        sliderimages  = homeRepository.getSliders();
        return sliderimages;
    }
}
