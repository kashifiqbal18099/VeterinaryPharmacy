package com.kashif.veterinarypharmacy.home.adapter;

import android.content.Context;

import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.base.GenericAdapter;
import com.kashif.veterinarypharmacy.databinding.HomeTopRatedProductItemBinding;
import com.kashif.veterinarypharmacy.home.model.HomeTopRatedProduct;

import java.util.List;

public class HomeTopRatedAdapter extends GenericAdapter<HomeTopRatedProduct, HomeTopRatedProductItemBinding> {



    public HomeTopRatedAdapter(Context context, List<HomeTopRatedProduct> arrayList) {
        super(context, arrayList);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.home_top_rated_product_item;
    }

    @Override
    public void onBindData(HomeTopRatedProduct model, int position, HomeTopRatedProductItemBinding dataBinding) {

        dataBinding.setViewmodel(model);

    }

    @Override
    public void onItemClick(HomeTopRatedProduct model, int position, HomeTopRatedProductItemBinding dataBinding) {

    }
}
