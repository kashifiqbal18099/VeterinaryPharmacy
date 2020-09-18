package com.kashif.veterinarypharmacy.home.fragment;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;
import android.widget.ImageView;

import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.base.BaseFramnet;
import com.kashif.veterinarypharmacy.cart.db.CartModel;
import com.kashif.veterinarypharmacy.cart.viewmodel.CartViewModel;
import com.kashif.veterinarypharmacy.databinding.FragmentProductListBinding;
import com.kashif.veterinarypharmacy.home.activity.HomeActivity;
import com.kashif.veterinarypharmacy.home.adapter.ProductListAdapter;
import com.kashif.veterinarypharmacy.home.model.HomCategorymodel;
import com.kashif.veterinarypharmacy.home.model.ProductModel;
import com.kashif.veterinarypharmacy.home.viemodel.ProductViewModel;
import com.kashif.veterinarypharmacy.util.CircleAnimationUtil;

import java.util.ArrayList;
import java.util.List;


public class ProductListFragment extends BaseFramnet<FragmentProductListBinding> implements ProductListAdapter.ProductListInterface{

    HomCategorymodel homCategorymodel;
    ProductViewModel productViewModel;
    CartViewModel cartViewModel;
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
        cartViewModel = ViewModelProviders.of(this).get(CartViewModel.class);
        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        productViewModel.Init();
        ((HomeActivity) getActivity()).dataBinding.top.title.setText(homCategorymodel.getCategory_title());
        ((HomeActivity) getActivity()).dataBinding.top.backLinear.setVisibility(View.VISIBLE);
        ((HomeActivity) getActivity()).dataBinding.top.toolbar.setNavigationIcon(null);
        dummy_image  = GetDataBinding().dummyImage;
        ObeserverCartQty();
        GetProducts();
    }

    public void GetProducts() {
        productListAdapter = new ProductListAdapter(getActivity(), productModelArrayList, this);
        GetDataBinding().productListRec.setAdapter(productListAdapter);

        productViewModel.getProducts().observe(getActivity(), new Observer<List<ProductModel>>() {
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

        HomeActivity.getInstance().GetDataBinding().drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        HomeActivity.getInstance().GetDataBinding().top.backLinear.setVisibility(View.GONE);
        HomeActivity.getInstance().setUpNavigationView();
    }

    @Override
    public void OnAddToCart(final ProductModel productModel, final ImageView view) {


        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                Integer qty=  cartViewModel.getQty(productModel.getId());
                if(qty==0)
                {
                    CartModel cartModel  = new CartModel();
                    cartModel.setCart_id("1");
                    float discount = Float.parseFloat(productModel.getOriginal_price()) - Float.parseFloat(productModel.getPromo_price());
                    cartModel.setDiscount(discount);
                    cartModel.setProduct_details("hello this is a product");
                    cartModel.setProduct_price(Float.parseFloat(productModel.getOriginal_price()));
                    cartModel.setProduct_id(productModel.getId());
                    cartModel.setImage(productModel.getThumbail());
                    cartModel.setQty(1);
                    cartModel.setProduct_name(productModel.getName());
                    cartViewModel.addToCart(cartModel);
                }
                else
                {
                    qty = qty+1;
                    cartViewModel.UpdateQty(productModel.getId(),qty);
                }




            }
        });

        Bitmap b = loadBitmapFromView(view, view.getWidth(), view.getHeight());
        makeFlyAnimation(view);
    }



    private void makeFlyAnimation(ImageView targetView) {

        ImageView destView =  HomeActivity.getInstance().GetDataBinding().top.cartIcon;

        new CircleAnimationUtil().attachActivity(getActivity()).setTargetView(targetView).setMoveDuration(800).setDestView(destView).setAnimationListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

         //       cartcount++;

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



    public void ObeserverCartQty() {
        if (cartViewModel != null && getView() != null && getActivity() != null) {

            cartViewModel.getAllQty().observe(getActivity(), new Observer<Integer>() {
                @Override
                public void onChanged(Integer qty) {

                    if (HomeActivity.getInstance().GetDataBinding().top.badgeNotification1.getVisibility() == View.GONE)
                        HomeActivity.getInstance().GetDataBinding().top.badgeNotification1.setVisibility(View.VISIBLE);


                    if (qty > 0)
                    {
                        HomeActivity.getInstance().GetDataBinding().top.badgeNotification1.setText(String.valueOf(qty));
                    }
                     else
                    {
                        if (HomeActivity.getInstance().GetDataBinding().top.badgeNotification1.getVisibility() == View.VISIBLE)
                            HomeActivity.getInstance().GetDataBinding().top.badgeNotification1.setVisibility(View.GONE);
                    }

                }
            });
        }
    }



    @Override
    public void onResume() {
        super.onResume();

        ObeserverCartQty();
    }
}