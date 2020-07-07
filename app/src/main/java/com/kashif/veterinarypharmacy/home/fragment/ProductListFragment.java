package com.kashif.veterinarypharmacy.home.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.base.BaseActivity;
import com.kashif.veterinarypharmacy.base.BaseFramnet;
import com.kashif.veterinarypharmacy.databinding.FragmentProductListBinding;
import com.kashif.veterinarypharmacy.home.activity.HomeActivity;


public class ProductListFragment extends BaseFramnet<FragmentProductListBinding> {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        ((HomeActivity)getActivity()).dataBinding.top.backLinear.setVisibility(View.VISIBLE);
        ((HomeActivity)getActivity()).dataBinding.top.toolbar.setNavigationIcon(null);

    }

    @Override
    public int getlayout() {
        return R.layout.fragment_product_list;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        ((HomeActivity)getActivity()).dataBinding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        ((HomeActivity)getActivity()).dataBinding.top.backLinear.setVisibility(View.GONE);
        ((HomeActivity)getActivity()).setUpNavigationView();
    }
}