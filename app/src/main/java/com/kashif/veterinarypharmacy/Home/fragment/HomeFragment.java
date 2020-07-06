package com.kashif.veterinarypharmacy.Home.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.kashif.veterinarypharmacy.Base.BaseFramnet;
import com.kashif.veterinarypharmacy.Home.viemodel.HomeViewModel;
import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFramnet<FragmentHomeBinding> {

    List<SlideModel> imageslist = new ArrayList<>();
    HomeViewModel homeViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        homeViewModel.Init();
        LoadDummyImages();
    }

    public void LoadDummyImages()
    {

        homeViewModel.getSliderImages().observe(getActivity(), new Observer<List<SlideModel>>() {
            @Override
            public void onChanged(List<SlideModel> slideModels) {

                GetDataBinding().imageSlider.setImageList(slideModels,ScaleTypes.CENTER_CROP);
            }
        });
    }



    @Override
    public int getlayout() {
        return R.layout.fragment_home;
    }
}