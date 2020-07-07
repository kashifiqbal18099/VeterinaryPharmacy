package com.kashif.veterinarypharmacy.home.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.base.GenericAdapter;
import com.kashif.veterinarypharmacy.home.model.HomCategorymodel;
import com.kashif.veterinarypharmacy.databinding.HomeCategoryItemBinding;

import java.util.List;

public class HomeCategoryAdapter extends GenericAdapter<HomCategorymodel, HomeCategoryItemBinding> {

    Context context;
    List<HomCategorymodel> homeCategoryModelList;


    public HomeCategoryAdapter(Context context, List<HomCategorymodel> arrayList) {
        super(context, arrayList);
        this.context = context;
        this.homeCategoryModelList  = arrayList;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.home_category_item;
    }

    @Override
    public void onBindData(HomCategorymodel model, int position, HomeCategoryItemBinding dataBinding) {

        dataBinding.setViewmodel(model);


    }

    @Override
    public void onItemClick(HomCategorymodel model, int position, HomeCategoryItemBinding dataBinding) {

        NavController navController =Navigation.findNavController(dataBinding.getRoot());
        Bundle args  = new Bundle();
        navController.navigate(R.id.productListFragment);

    }
}
