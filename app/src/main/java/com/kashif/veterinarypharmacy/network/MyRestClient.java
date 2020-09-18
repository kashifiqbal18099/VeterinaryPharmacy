package com.kashif.veterinarypharmacy.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class MyRestClient {
    private NetworkOperationListener listener;
    private JSONObject body;
    private String link, method;
    private Context context;
    private ProgressDialog pd;

    public MyRestClient(final Context context, String url, String method, JSONObject body, NetworkOperationListener listener) {
        this.context = context;
        this.listener = listener;
        this.link = url;
        this.method = method;
        this.body = body;
        //Utility.writeToFile(body.toString(), "data");
    }

    public MyRestClient(final Context context, String url, String method, JSONObject body, ProgressDialog pd, NetworkOperationListener listener) {
        this.context = context;
        this.listener = listener;
        this.link = url;
        this.method = method;
        this.body = body;
        this.pd = pd;
/*        url = url.replaceAll(" ", "%20");
        Utility.logCatMsg("URL: " + url);*/
        //Utility.writeToFile(body.toString(), "data");
    }

    public void executeReq() {
        if (context != null) {
            if(ConnectionDetector.isConnectingToInternet(context)){
                getResponse();
            }else{
                retryDialog(null);
            }
        }
    }

    public void execImageUpload(String fileName, Drawable drawable){
        if (context != null) {
            if(ConnectionDetector.isConnectingToInternet(context)){
                uploadImage(fileName, drawable);
            }
        }
    }

    public void execVideoThumbUpload(String videoFileName, String thumbFileName, File videoFile, File thumbFile){
        if (context != null) {
            if(ConnectionDetector.isConnectingToInternet(context)){
                videoFileUpload(videoFileName, thumbFileName, videoFile, thumbFile);
            }
        }
    }

    private void videoFileUpload(final String videoFileName, final String thumbFileName, final File videoFile, final File thumbFile){
        VolleyMultiPartRequest multipartRequest = new VolleyMultiPartRequest(Request.Method.POST, this.link, new Response.Listener<NetworkResponse>() {
            @Override
            public void onResponse(NetworkResponse response) {
         /*       String resultResponse = null;
                try {
                    resultResponse = new String(response.data, String.valueOf(HttpHeaderParser.parseCacheHeaders(response)));

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();

                }
                if(listener != null){
                    try {
                        listener.onSuccess(resultResponse);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                if(listener != null){
                    listener.onFailed(error.networkResponse.statusCode, error.getMessage());
                }
            }
        }) {

            @Override
            protected Map<String, DataPart> getByteData() {
                Map<String, DataPart> params = new HashMap<>();
/*                params.put(videoFileName, new DataPart(videoFileName, Utility.getBytesFromFile(context, videoFile), "media/video"));
                params.put(thumbFileName, new DataPart(thumbFileName, Utility.getBytesFromFile(context, thumbFile), "media/image"));*/
                return params;
            }
        };
        VolleySingleObject.getInstance(context).addToRequestQueue(multipartRequest);
    }

    public void execFileUpload(String fileName, File file){
        if (context != null) {
            if(ConnectionDetector.isConnectingToInternet(context)){
                fileUpload(fileName, file);
            }
        }
    }

    public void execDocumentUpload(String fileName, File file){
        if(context != null){
            if(ConnectionDetector.isConnectingToInternet(context)){
                if(file != null){
                    //documentUpload(fileName, file);
                } else {
              //      Utility.showToast(context, "file is null");
                }

            }
        }
    }

    private void uploadImage(final String fileName, final Drawable drawable){
        VolleyMultiPartRequest multipartRequest = new VolleyMultiPartRequest(Request.Method.POST, this.link, new Response.Listener<NetworkResponse>() {
            @Override
            public void onResponse(NetworkResponse response) {
                String resultResponse = new String(response.data);
              //  Utility.logCatMsg("Success: "+resultResponse);
             /*   if(listener != null){
                    try {
                        listener.onSuccess(resultResponse);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
             //   Utility.logCatMsg("Failed: "+error.getMessage());
                if(listener != null){
                    listener.onFailed(error.networkResponse.statusCode, error.getMessage());
                }
            }
        }) {
            @Override
            protected Map<String, DataPart> getByteData() {
                Map<String, DataPart> params = new HashMap<>();
             //   params.put(fileName, new DataPart(fileName, Utility.getFileDataFromDrawable(context, drawable), "image/jpeg"));
                return params;
            }
        };
        VolleySingleObject.getInstance(context).addToRequestQueue(multipartRequest);
    }

    private void fileUpload(final String fileName, final File file){
        VolleyMultiPartRequest multipartRequest = new VolleyMultiPartRequest(Request.Method.POST, this.link, new Response.Listener<NetworkResponse>() {
            @Override
            public void onResponse(NetworkResponse response) {
                String resultResponse = new String(response.data);
            //    Utility.logCatMsg("Success: "+resultResponse);
             /*   if(listener != null){
                    try {
                        listener.onSuccess(resultResponse);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
/*                if(NewsFeedUploadActivity.pd != null){
                    NewsFeedUploadActivity.pd.hide();
                }
                Utility.showToast(context, Utility.getVolleyError(error));
                Utility.logCatMsg("Failed: "+Utility.getVolleyError(error));*/
//                if(listener != null){
//                    listener.onFailed(error.networkResponse.statusCode, error.getMessage());
//                }
            }
        }) {

            @Override
            protected Map<String, DataPart> getByteData() {
                Map<String, DataPart> params = new HashMap<>();
                //params.put(fileName, new DataPart(fileName, Utility.getBytesFromFile(context, file), "media/audio"));

                return params;
            }
        };
        VolleySingleObject.getInstance(context).addToRequestQueue(multipartRequest);
    }

/*
    private void documentUpload(final String fileName, final File file){
        VolleyMultiPartRequest multipartRequest = new VolleyMultiPartRequest(Request.Method.POST, this.link, response -> {
            String resultResponse = new String(response.data);
  *//*          Utility.logCatMsg("Success: "+resultResponse);
            if(listener != null){
                try {
                    listener.onSuccess(resultResponse);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, error -> {
            error.printStackTrace();
            Utility.logCatMsg("Failed: "+error.getMessage());*//*
//                if(listener != null){
//                    listener.onFailed(error.networkResponse.statusCode, error.getMessage());
//                }
        }) {

            @Override
            protected Map<String, DataPart> getByteData() {
                Map<String, DataPart> params = new HashMap<>();
                params.put(fileName, new DataPart(fileName, Utility.getBytesFromFile(context, file), "application/pdf"));
                return params;
            }
        };
        VolleySingleObject.getInstance(context).addToRequestQueue(multipartRequest);
    }*/





    private void getResponse() {
        int reqMethod = 0;

        if(method.equals(Method.GET)){
            reqMethod = Request.Method.GET;

        }
        else if(method.equals(Method.POST)){

            reqMethod = Request.Method.POST;

        }else if(method.equals(Method.PUT)){

            reqMethod = Request.Method.PUT;

        }
        else if(method.equalsIgnoreCase(Method.DELETE))
        {
            reqMethod  = Request.Method.DELETE;
        }
        JsonRequest jRequest = new JsonObjectRequest(reqMethod, link, body, new JsonSuccessListener(), new StringErrorListener()) {
            @Override
            protected VolleyError parseNetworkError(VolleyError volleyError) {
           //     Utility.logCatMsg("Error: " + volleyError.getMessage());
                if(pd != null){
                    pd.dismiss();
                }
                return super.parseNetworkError(volleyError);
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Content-type", "application/json; charset=utf-8");
                params.put("Accept", "application/json; charset=utf-8");
             //   params.put("Authorization", "Bearer " + sharedPrefs.GetAccessToken());
                return params;
            }
        };
        VolleySingleObject.getInstance(context).addToRequestQueue(jRequest);
    }

    private class JsonSuccessListener implements Response.Listener<JSONObject>{

        @Override
        public void onResponse(JSONObject response) {
        //    Utility.logCatMsg("onSuccess: " + response.toString());
            if(pd != null){
                pd.dismiss();
            }
            if (listener != null) {
                try {
                    listener.onSuccess(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class StringErrorListener implements Response.ErrorListener{
        @Override
        public void onErrorResponse(VolleyError err) {
        //   Utility.showToast(context, Utility.getVolleyError(err));
           if(pd != null){
               pd.dismiss();
           }

        }
    }

    private void retryDialog(final Throwable error) {
        if (context != null) {
            try {
                if (!((AppCompatActivity) context).isFinishing()) {
                    if (error == null) {
         //               Utility.showToast(context, "Network Request Failed");
                    }
                }
            }catch (RuntimeException exc){
          //      Utility.logCatMsg("Context is not provided as expected, handling exception");
                if (listener != null)
                    listener.onFailed(0, ((error != null && error.getMessage() != null) ? error.getMessage() : "Failed"));
            }
        }
    }

    public static class Method {
        public static final String GET = "GET";
        public static final String POST = "POST";
        public static final String PUT = "PUT";
        public static final String DELETE = "DELETE";
    }
}
