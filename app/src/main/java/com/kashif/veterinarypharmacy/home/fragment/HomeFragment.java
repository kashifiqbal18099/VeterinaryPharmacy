package com.kashif.veterinarypharmacy.home.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.kashif.veterinarypharmacy.base.BaseFramnet;
import com.kashif.veterinarypharmacy.base.MyApp;
import com.kashif.veterinarypharmacy.home.adapter.HomeCategoryAdapter;
import com.kashif.veterinarypharmacy.home.adapter.HomeTopRatedAdapter;
import com.kashif.veterinarypharmacy.home.model.HomCategorymodel;
import com.kashif.veterinarypharmacy.home.model.HomeTopRatedProduct;
import com.kashif.veterinarypharmacy.home.viemodel.HomeViewModel;
import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.databinding.FragmentHomeBinding;
import com.kashif.veterinarypharmacy.imageslider.adapter.ViewPagerAdapeter;
import com.kashif.veterinarypharmacy.network.NetworkState;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends BaseFramnet<FragmentHomeBinding> {

    List<SlideModel> imageslist = new ArrayList<>();
    List<HomCategorymodel> homeCategoryModelList  = new ArrayList<>();
    List<HomeTopRatedProduct> homeTopRatedProductList  = new ArrayList<>();
    List<String> sliderlist  = new ArrayList<>();
    List<SlideModel> slideModelList   = new ArrayList<>();
    HomeViewModel homeViewModel;
    HomeTopRatedAdapter homeTopRatedAdapter;
    HomeCategoryAdapter homeCategoryAdapter;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;




    @Override
    public void OnCreateView() {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        homeViewModel.Init();
        LoadDummyImages();
        GetHomeCategories();
        GetHomeTopRatedProducts();
    }



    public void LoadDummyImages()
    {
        sliderlist.clear();
        final ViewPagerAdapeter viewPagerAdapeter = new ViewPagerAdapeter(sliderlist, getContext());
        dataBinding.imageSlider.setAdapter(viewPagerAdapeter);
        homeViewModel.getSliderImages().observe(getActivity(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> list) {
                sliderlist.clear();
                sliderlist.addAll(list);
                NUM_PAGES = sliderlist.size();
                viewPagerAdapeter.notifyDataSetChanged();

                final Runnable Update = new Runnable() {
                    public void run() {
                        if (currentPage == NUM_PAGES) {
                            currentPage = 0;
                        }
                        dataBinding.imageSlider.setCurrentItem(currentPage++, true);
                    }
                };
                final Handler handler = new Handler();
                Timer swipeTimer = new Timer();
                swipeTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(Update);
                    }
                }, 3000, 3000);
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
                homeCategoryModelList.clear();
                homeCategoryModelList.addAll(homeCategoryModels);
                homeCategoryAdapter.notifyDataSetChanged();
            }
        });

        homeViewModel.getnetworkstate().observe(getActivity(), new Observer<NetworkState>() {
            @Override
            public void onChanged(NetworkState networkState) {

                if(networkState.getStatus()== NetworkState.Status.RUNNING)
                {
                    customProgressDialog.show();
                }
                if(networkState.getStatus()== NetworkState.Status.SUCCESS)
                {
                    customProgressDialog.dismiss();
                }
                if(networkState.getStatus()== NetworkState.Status.FAILED)
                {
                    Toast.makeText(mContext, networkState.getMsg(), Toast.LENGTH_SHORT).show();
                    customProgressDialog.dismiss();
                }
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
                homeTopRatedProductList.clear();
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