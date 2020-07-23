package com.kashif.veterinarypharmacy.base;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

public class MyApp extends Application {


    public static MyApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }
   synchronized public static  MyApp getIntance()
   {

        return instance;

    }
    public List<String> GetArrayFromCommaSeperated(String str)
    {
        List<String> items = Arrays.asList(str.split("\\s*,\\s*"));
        return items;
    }


}
