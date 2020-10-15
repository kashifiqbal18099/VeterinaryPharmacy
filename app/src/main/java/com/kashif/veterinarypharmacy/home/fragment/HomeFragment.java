package com.kashif.veterinarypharmacy.home.fragment;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Handler;
import android.widget.Toast;

import com.denzcoskun.imageslider.models.SlideModel;
import com.kashif.veterinarypharmacy.base.BaseFramnet;
import com.kashif.veterinarypharmacy.home.adapter.HomeCategoryAdapter;
import com.kashif.veterinarypharmacy.home.adapter.HomeTopRatedAdapter;
import com.kashif.veterinarypharmacy.home.model.HomeCategoryResponse;
import com.kashif.veterinarypharmacy.home.model.HomeCategorymodel;
import com.kashif.veterinarypharmacy.home.model.HomeTopRatedProduct;
import com.kashif.veterinarypharmacy.home.model.SliderModel;
import com.kashif.veterinarypharmacy.home.viemodel.HomeViewModel;
import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.databinding.FragmentHomeBinding;
import com.kashif.veterinarypharmacy.imageslider.adapter.ViewPagerAdapeter;
import com.kashif.veterinarypharmacy.network.NetworkState;
import com.kashif.veterinarypharmacy.network.Resource;
import com.kashif.veterinarypharmacy.network.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends BaseFramnet<FragmentHomeBinding> implements LifecycleOwner {

    List<SlideModel> imageslist = new ArrayList<>();
    List<HomeCategorymodel> homeCategoryModelList  = new ArrayList<>();
    List<HomeTopRatedProduct> homeTopRatedProductList  = new ArrayList<>();
    List<SliderModel> sliderlist  = new ArrayList<>();
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
        GetHomeCategories();
        GetHomeTopRatedProducts();
    }





    public void GetHomeCategories()
    {
        sliderlist.clear();
        final ViewPagerAdapeter viewPagerAdapeter = new ViewPagerAdapeter(sliderlist, getContext());
        dataBinding.imageSlider.setAdapter(viewPagerAdapeter);
        homeCategoryAdapter  = new HomeCategoryAdapter(getActivity(),homeCategoryModelList);
        GetDataBinding().categoryRec.setAdapter(homeCategoryAdapter);
        customProgressDialog.show();

        homeViewModel.getHomeCategoriesandSlider().observe(getActivity(), new Observer<Resource<HomeCategoryResponse>>() {
            @Override
            public void onChanged(Resource<HomeCategoryResponse> homeCategoryResponseResource) {

                if(null != homeCategoryResponseResource && (homeCategoryResponseResource.status == Status.ERROR || homeCategoryResponseResource.status == Status.SUCCESS)){
                    customProgressDialog.dismiss();
                }
                if(homeCategoryResponseResource.data!=null && homeCategoryResponseResource.status==Status.SUCCESS && homeCategoryResponseResource.getMessage()==null)
                {
                    homeCategoryModelList.addAll(homeCategoryResponseResource.data.getCategories());
                    homeCategoryAdapter.notifyDataSetChanged();

                    if(homeCategoryResponseResource.data.getSliders()!=null && homeCategoryResponseResource.data.getSliders().size()>0)
                    {
                        sliderlist.addAll(homeCategoryResponseResource.data.getSliders());
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