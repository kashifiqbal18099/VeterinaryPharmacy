package com.kashif.veterinarypharmacy.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kashif.veterinarypharmacy.base.BaseActivity;
import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.databinding.ActivityLoginBinding;
import com.kashif.veterinarypharmacy.home.activity.HomeActivity;
import com.kashif.veterinarypharmacy.util.ClickHandlers;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> implements ClickHandlers {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding.setClickhandlers(this);
       // setContentView(R.layout.activity_login);

    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.login:
                startActivity(new Intent(mContext, HomeActivity.class));
                break;

            case R.id.signup:
                startActivity(new Intent(mContext, SignupActivity.class));
                break;
        }
    }
}