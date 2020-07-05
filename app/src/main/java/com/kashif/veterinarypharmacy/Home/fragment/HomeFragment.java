package com.kashif.veterinarypharmacy.Home.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.models.SlideModel;
import com.kashif.veterinarypharmacy.Base.BaseFramnet;
import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFramnet<FragmentHomeBinding> {

    List<SlideModel> imageslist = new ArrayList<>();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void LoadDummyImages()
    {

      /*  imageslist.add(new SlideModel("https://bit.ly/2YoJ77H", "The animal population decreased by 58 percent in 42 years."))
        imageslist.add(SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct."))
        imageslist.add(SlideModel("https://bit.ly/3fLJf72", "And people do that."))*/
    }



    @Override
    public int getlayout() {
        return R.layout.fragment_home;
    }
}