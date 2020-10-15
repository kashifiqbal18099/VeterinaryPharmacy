package com.kashif.veterinarypharmacy.network;

import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kashif.veterinarypharmacy.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClientSet {

    private static Retrofit retrofit = null;

    public  static Retrofit getClient() {

        if(retrofit == null)
        {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
            okHttpClientBuilder.readTimeout(70, TimeUnit.SECONDS)
                    .connectTimeout(70, TimeUnit.SECONDS)
                    .writeTimeout(70, TimeUnit.SECONDS)
                    .build();
            okHttpClientBuilder.addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .addHeader("content-type", "application/x-www-form-urlencoded")
                            .method(original.method(), original.body())
                            .build();

                    Log.e("response    ","responsecal "+request.toString());


                    return chain.proceed(request);
                }
            });


            OkHttpClient client = okHttpClientBuilder.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();

        }

        return retrofit;
    }
}
