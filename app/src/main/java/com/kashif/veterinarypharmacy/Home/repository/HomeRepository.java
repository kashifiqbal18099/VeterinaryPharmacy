package com.kashif.veterinarypharmacy.Home.repository;

import androidx.lifecycle.MutableLiveData;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.kashif.veterinarypharmacy.Home.model.Slider;

import java.util.ArrayList;
import java.util.List;

public class HomeRepository {
    public static HomeRepository instance;
    private ArrayList<SlideModel> sliderArrayList  = new ArrayList<>();

    public static HomeRepository getInstance(){
        if(instance == null){
            instance = new HomeRepository();
        }
        return instance;
    }

    public MutableLiveData<List<SlideModel>> getSliders()
    {
        SetSlider();
        MutableLiveData<List<SlideModel>> data = new MutableLiveData<>();
        data.setValue(sliderArrayList);
        return data;
    }
    public void SetSlider()
    {

        sliderArrayList.add(new SlideModel("https://bit.ly/2YoJ77H", ScaleTypes.CENTER_CROP));
        sliderArrayList.add(new SlideModel("https://bit.ly/2BteuF2",ScaleTypes.CENTER_CROP));
        sliderArrayList.add(new SlideModel("https://bit.ly/3fLJf72",ScaleTypes.CENTER_CROP));

    }
}
