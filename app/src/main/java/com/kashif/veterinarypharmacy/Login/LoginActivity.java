package com.kashif.veterinarypharmacy.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kashif.veterinarypharmacy.Base.BaseActivity;
import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_login);

    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_login;
    }
}