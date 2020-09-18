package com.kashif.veterinarypharmacy.base;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.kashif.veterinarypharmacy.network.TokenRetryPolicy;

import java.util.Arrays;
import java.util.List;

import static android.content.ContentValues.TAG;

public class MyApp extends Application {

    private com.android.volley.RequestQueue mRequestQueue2;
    public static MyApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }

    synchronized public static MyApp getIntance() {

        return instance;
    }

    public List<String> GetArrayFromCommaSeperated(String str) {
        List<String> items = Arrays.asList(str.split("\\s*,\\s*"));
        return items;
    }


    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);


        req.setRetryPolicy(new TokenRetryPolicy(
                60000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        JsonObjectRequest jsonObjectRequest = (JsonObjectRequest) req;
        getRequestQueue().add(req);
    }


    public com.android.volley.RequestQueue getRequestQueue() {
        if (mRequestQueue2 == null) {
            mRequestQueue2 = Volley.newRequestQueue(getApplicationContext());
        }


        return mRequestQueue2;
    }


}
