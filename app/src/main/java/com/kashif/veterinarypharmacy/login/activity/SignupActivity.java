package com.kashif.veterinarypharmacy.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kashif.veterinarypharmacy.base.BaseActivity;
import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.databinding.ActivitySignupBinding;
import com.kashif.veterinarypharmacy.home.activity.HomeActivity;
import com.kashif.veterinarypharmacy.util.ClickHandlers;

public class SignupActivity extends BaseActivity<ActivitySignupBinding> implements ClickHandlers {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataBinding.setClickhandlers(this);
     //   setContentView(R.layout.activity_signup);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_signup;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.signup:

                startActivity(new Intent(mContext, HomeActivity.class));
                break;
            case R.id.login:
                onBackPressed();
                break;
        }
    }
}