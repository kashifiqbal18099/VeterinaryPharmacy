package com.kashif.veterinarypharmacy.Login.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kashif.veterinarypharmacy.Base.BaseActivity;
import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.databinding.ActivitySignupBinding;

public class SignupActivity extends BaseActivity<ActivitySignupBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_signup);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_signup;
    }
}