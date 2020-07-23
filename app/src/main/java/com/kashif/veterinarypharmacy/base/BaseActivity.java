package com.kashif.veterinarypharmacy.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.kashif.veterinarypharmacy.util.CustomProgressDialog;

public abstract class  BaseActivity<DB extends ViewDataBinding> extends AppCompatActivity {
    public DB dataBinding;
    protected Context mContext;
    protected CustomProgressDialog customProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataBinding = DataBindingUtil.setContentView(this,getLayoutRes());
    }
    @LayoutRes
    public abstract int getLayoutRes();


    public DB GetDataBinding()
    {
        return dataBinding;
    }
}
