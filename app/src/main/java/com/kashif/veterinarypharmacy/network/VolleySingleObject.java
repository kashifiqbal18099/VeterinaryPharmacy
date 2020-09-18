package com.kashif.veterinarypharmacy.network;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class VolleySingleObject
{
    private RequestQueue mRequestQueue;
    private static VolleySingleObject volleySingleObject;
    private static Context context;

    private VolleySingleObject(){}
    public static synchronized VolleySingleObject getInstance(Context context){
        VolleySingleObject.context = context;
        if(volleySingleObject == null){
            volleySingleObject = new VolleySingleObject();
        }
        return volleySingleObject;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(context);
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag("");
        req.setRetryPolicy(new TokenRetryPolicy(
                40 * 1000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        getRequestQueue().add(req);
    }
}

