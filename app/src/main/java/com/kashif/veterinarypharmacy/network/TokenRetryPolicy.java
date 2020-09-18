package com.kashif.veterinarypharmacy.network;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.VolleyError;




public class TokenRetryPolicy extends DefaultRetryPolicy {

    private int mCurrentTimeoutMs;
    private final int mMaxNumRetries;
    private final float mBackoffMultiplier;


    public TokenRetryPolicy(int initialTimeoutMs, int maxNumRetries, float backoffMultiplier) {
        mCurrentTimeoutMs = initialTimeoutMs;
        mMaxNumRetries = maxNumRetries;
        mBackoffMultiplier = backoffMultiplier;
    }

    @Override
    public void retry(VolleyError error) throws VolleyError
    {


    }

    @Override
    public int getCurrentTimeout() {
        return mCurrentTimeoutMs;
    }

    @Override
    public int getCurrentRetryCount() {
        return 60000;
    }


    protected boolean hasAttemptRemaining() {
        return mCurrentTimeoutMs <= mMaxNumRetries;
    }
}
