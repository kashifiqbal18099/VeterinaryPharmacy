package com.kashif.veterinarypharmacy.home.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.base.BaseActivity;
import com.kashif.veterinarypharmacy.base.MyApp;
import com.kashif.veterinarypharmacy.databinding.ActivityProductDetailsBinding;
import com.kashif.veterinarypharmacy.home.model.ProductModel;
import com.kashif.veterinarypharmacy.imageslider.adapter.ViewPagerAdapeter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ProductDetailsActivity extends BaseActivity<ActivityProductDetailsBinding> {

    List<String> list  = new ArrayList<>();
    ProductModel productModel;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productModel = getIntent().getExtras().getParcelable("product");
        if(productModel!=null)
        {
            dataBinding.setDetails(productModel);
            InitSlider();
        }
        dataBinding.top.backLinear.setVisibility(View.VISIBLE);
    }
    public void InitSlider()
    {

        List<String> list = MyApp.getIntance().GetArrayFromCommaSeperated(productModel.getImage());
        NUM_PAGES = list.size();
        ViewPagerAdapeter viewPagerAdapeter = new ViewPagerAdapeter(list, this);
        dataBinding.viewPager.setAdapter(viewPagerAdapeter);

        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                dataBinding.viewPager.setCurrentItem(currentPage++, true);
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



    @Override
    public int getLayoutRes() {
        return R.layout.activity_product_details;
    }
}