package com.kashif.veterinarypharmacy.home.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.kashif.veterinarypharmacy.base.BaseFramnet;
import com.kashif.veterinarypharmacy.home.adapter.HomeCategoryAdapter;
import com.kashif.veterinarypharmacy.home.adapter.HomeTopRatedAdapter;
import com.kashif.veterinarypharmacy.home.model.HomCategorymodel;
import com.kashif.veterinarypharmacy.home.model.HomeTopRatedProduct;
import com.kashif.veterinarypharmacy.home.viemodel.HomeViewModel;
import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFramnet<FragmentHomeBinding> {

    List<SlideModel> imageslist = new ArrayList<>();
    List<HomCategorymodel> homeCategoryModelList  = new ArrayList<>();
    List<HomeTopRatedProduct> homeTopRatedProductList  = new ArrayList<>();
    HomeViewModel homeViewModel;
    HomeTopRatedAdapter homeTopRatedAdapter;
    HomeCategoryAdapter homeCategoryAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        homeViewModel.Init();
        LoadDummyImages();
        GetHomeCategories();
        GetHomeTopRatedProducts();
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

    public void GetHomeCategories()
    {
        homeCategoryAdapter  = new HomeCategoryAdapter(getActivity(),homeCategoryModelList);

        GetDataBinding().categoryRec.setAdapter(homeCategoryAdapter);

        homeViewModel.getHomeCategries().observe(getActivity(), new Observer<List<HomCategorymodel>>() {
            @Override
            public void onChanged(List<HomCategorymodel> homeCategoryModels) {
                homeCategoryModelList.addAll(homeCategoryModels);
                homeCategoryAdapter.notifyDataSetChanged();
            }
        });
    }

    public void GetHomeTopRatedProducts()
    {
        homeTopRatedAdapter  = new HomeTopRatedAdapter(getActivity(),homeTopRatedProductList);
        GetDataBinding().topRatedRec.setAdapter(homeTopRatedAdapter);

        homeViewModel.getHomeTopRatedProducts().observe(getActivity(), new Observer<List<HomeTopRatedProduct>>() {
            @Override
            public void onChanged(List<HomeTopRatedProduct> homeTopRatedProducts) {
                homeTopRatedProductList.addAll(homeTopRatedProducts);
                homeTopRatedAdapter.notifyDataSetChanged();
            }
        });
    }



    @Override
    public int getlayout() {
        return R.layout.fragment_home;
    }
}