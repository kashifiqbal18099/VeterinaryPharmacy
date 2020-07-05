package com.kashif.veterinarypharmacy.Home.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kashif.veterinarypharmacy.Base.BaseActivity;
import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.databinding.ActivityHomeBinding;

public class HomeActivity extends BaseActivity<ActivityHomeBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_home;
    }
}