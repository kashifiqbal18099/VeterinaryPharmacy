package com.kashif.veterinarypharmacy.profile.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.base.BaseFramnet;
import com.kashif.veterinarypharmacy.base.GenericAdapter;
import com.kashif.veterinarypharmacy.databinding.FragmentPrfileFramentBinding;
import com.kashif.veterinarypharmacy.databinding.FragmentProductListBinding;
import com.kashif.veterinarypharmacy.databinding.ProfileItemBinding;
import com.kashif.veterinarypharmacy.profile.model.ProfileItemModel;
import com.kashif.veterinarypharmacy.profile.viewmodel.ProfileViewModel;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends BaseFramnet<FragmentPrfileFramentBinding> {

    GenericAdapter<ProfileItemModel, ProfileItemBinding> ProfileItemAdapter;
    List<ProfileItemModel> profileItemModels  = new ArrayList<>();
    ProfileViewModel profileViewModel;
    @Override
    public void OnCreateView() {
        profileViewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        InitItemAdapter();
        GetProfileItems();
    }

    @Override
    public int getlayout() {
        return R.layout.fragment_prfile_frament;
    }
    public void InitItemAdapter()
    {
        ProfileItemAdapter  = new GenericAdapter<ProfileItemModel, ProfileItemBinding>(getActivity(),profileItemModels) {
            @Override
            public int getLayoutResId() {
                return R.layout.profile_item;
            }

            @Override
            public void onBindData(ProfileItemModel model, int position, ProfileItemBinding dataBinding) {

                dataBinding.setProfilitem(model);
            }

            @Override
            public void onItemClick(ProfileItemModel model, int position, ProfileItemBinding dataBinding) {

            }
        };

        GetDataBinding().profileItemRec.setAdapter(ProfileItemAdapter);
    }

    public void GetProfileItems()
    {
        profileViewModel.getProfileitemlivedata().observe(getActivity(), new Observer<List<ProfileItemModel>>() {
            @Override
            public void onChanged(List<ProfileItemModel> profileItemModels1) {
                profileItemModels.addAll(profileItemModels1);
                ProfileItemAdapter.notifyDataSetChanged();
            }
        });
    }
}