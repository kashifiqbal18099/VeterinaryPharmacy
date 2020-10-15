package com.kashif.veterinarypharmacy.home.adapter;

import android.content.Context;
import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.base.GenericAdapter;
import com.kashif.veterinarypharmacy.home.model.HomeCategorymodel;
import com.kashif.veterinarypharmacy.databinding.HomeCategoryItemBinding;

import java.util.List;

public class HomeCategoryAdapter extends GenericAdapter<HomeCategorymodel, HomeCategoryItemBinding> {

    Context context;
    List<HomeCategorymodel> homeCategoryModelList;


    public HomeCategoryAdapter(Context context, List<HomeCategorymodel> arrayList) {
        super(context, arrayList);
        this.context = context;
        this.homeCategoryModelList  = arrayList;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.home_category_item;
    }

    @Override
    public void onBindData(HomeCategorymodel model, int position, HomeCategoryItemBinding dataBinding) {

        dataBinding.setViewmodel(model);


    }

    @Override
    public void onItemClick(HomeCategorymodel model, int position, HomeCategoryItemBinding dataBinding) {

        NavController navController =Navigation.findNavController(dataBinding.getRoot());
        Bundle args  = new Bundle();
        args.putParcelable("category",model);
        navController.navigate(R.id.productListFragment,args);

    }
}
