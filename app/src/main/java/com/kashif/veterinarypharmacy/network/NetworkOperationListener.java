package com.kashif.veterinarypharmacy.network;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Moon on 1/18/2017.
 */
public interface NetworkOperationListener {
    void onSuccess(JSONObject response) throws JSONException;

    void onFailed(int code, String reason);
}
