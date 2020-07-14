package com.kashif.veterinarypharmacy.home.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.base.BaseFramnet;
import com.kashif.veterinarypharmacy.databinding.FragmentProductListBinding;
import com.kashif.veterinarypharmacy.home.activity.HomeActivity;
import com.kashif.veterinarypharmacy.home.adapter.ProductListAdapter;
import com.kashif.veterinarypharmacy.home.model.HomCategorymodel;
import com.kashif.veterinarypharmacy.home.model.ProductModel;
import com.kashif.veterinarypharmacy.home.viemodel.HomeViewModel;
import com.kashif.veterinarypharmacy.util.CircleAnimationUtil;

import java.util.ArrayList;
import java.util.List;


public class ProductListFragment extends BaseFramnet<FragmentProductListBinding> implements ProductListAdapter.ProductListInterface {

    HomCategorymodel homCategorymodel;
    HomeViewModel homeViewModel;
    ProductListAdapter productListAdapter;
    List<ProductModel> productModelArrayList = new ArrayList<>();
    ImageView dummy_image;
    int actionbarheight;
    int cartcount = 0;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void OnCreateView() {

        homCategorymodel = getArguments().getParcelable("category");
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        homeViewModel.Init();
        ((HomeActivity) getActivity()).dataBinding.top.title.setText(homCategorymodel.getName());
        ((HomeActivity) getActivity()).dataBinding.top.backLinear.setVisibility(View.VISIBLE);
        ((HomeActivity) getActivity()).dataBinding.top.toolbar.setNavigationIcon(null);
        dummy_image  = GetDataBinding().dummyImage;
        GetProducts();
    }

    public void GetProducts() {
        productListAdapter = new ProductListAdapter(getActivity(), productModelArrayList, this);
        GetDataBinding().productListRec.setAdapter(productListAdapter);

        homeViewModel.getProducts().observe(getActivity(), new Observer<List<ProductModel>>() {
            @Override
            public void onChanged(List<ProductModel> productModels) {

                productModelArrayList.clear();
                productModelArrayList.addAll(productModels);
                productListAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getlayout() {
        return R.layout.fragment_product_list;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        ((HomeActivity) getActivity()).dataBinding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        ((HomeActivity) getActivity()).dataBinding.top.backLinear.setVisibility(View.GONE);
        ((HomeActivity) getActivity()).setUpNavigationView();
    }

    @Override
    public void OnAddToCart(String product_id,ImageView view) {

        Bitmap b = loadBitmapFromView(view, view.getWidth(), view.getHeight());
        makeFlyAnimation(view);

    }



    private void makeFlyAnimation(ImageView targetView) {

        ImageView destView = ((HomeActivity) getActivity()).dataBinding.top.cartIcon;

        new CircleAnimationUtil().attachActivity(getActivity()).setTargetView(targetView).setMoveDuration(800).setDestView(destView).setAnimationListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                cartcount++;
                if( ((HomeActivity) getActivity()).dataBinding.top.badgeNotification1.getVisibility()==View.GONE)
                    ((HomeActivity) getActivity()).dataBinding.top.badgeNotification1.setVisibility(View.VISIBLE);


                ((HomeActivity) getActivity()).dataBinding.top.badgeNotification1.setText(String.valueOf(cartcount));
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).startAnimation();


    }

    public Bitmap loadBitmapFromView(View view, int width, int height) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);



        return returnedBitmap;
    }


}