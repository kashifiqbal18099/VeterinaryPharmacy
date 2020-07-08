package com.kashif.veterinarypharmacy.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;


import com.kashif.veterinarypharmacy.util.CustomProgressDialog;

public abstract class BaseFramnet<DB extends ViewDataBinding> extends Fragment {


    public DB dataBinding;
    protected CustomProgressDialog customProgressDialog;
    protected Context mContext;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        dataBinding  = DataBindingUtil.inflate(inflater,getlayout(),container,false);
        customProgressDialog = new CustomProgressDialog(getActivity());
        mContext  = getActivity();
        OnCreateView();
        return dataBinding.getRoot();
    }

    public abstract void OnCreateView();
    public abstract int getlayout();

    public DB GetDataBinding()
    {
        return dataBinding;
    }
}
