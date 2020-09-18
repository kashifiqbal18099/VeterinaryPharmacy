package com.kashif.veterinarypharmacy.home.repository;

import androidx.lifecycle.MutableLiveData;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.gson.Gson;
import com.kashif.veterinarypharmacy.base.AppConstant;
import com.kashif.veterinarypharmacy.base.MyApp;
import com.kashif.veterinarypharmacy.home.model.HomCategorymodel;
import com.kashif.veterinarypharmacy.home.model.HomeTopRatedProduct;
import com.kashif.veterinarypharmacy.home.model.ProductModel;
import com.kashif.veterinarypharmacy.network.MyRestClient;
import com.kashif.veterinarypharmacy.network.NetworkOperationListener;
import com.kashif.veterinarypharmacy.network.NetworkState;
import com.kashif.veterinarypharmacy.network.VolleySingleObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeRepository {
    public static HomeRepository instance;
    private ArrayList<String> sliderArrayList = new ArrayList<>();
    private ArrayList<HomCategorymodel> homeCategoryModelArrayList = new ArrayList<>();
    private ArrayList<HomeTopRatedProduct> homeTopRatedProductArrayList = new ArrayList<>();
    private ArrayList<ProductModel> productModelArrayList = new ArrayList<>();
    private MutableLiveData<NetworkState> networkState = new MutableLiveData<>();
    private MutableLiveData<List<HomCategorymodel>> homecategorymutablelivedata = new MutableLiveData<>();
    private MutableLiveData<List<String>> slidermutablelivedata = new MutableLiveData<>();

    public static HomeRepository getInstance() {
        if (instance == null) {
            instance = new HomeRepository();
        }

        return instance;
    }

    public MutableLiveData<NetworkState> getNetworkState() {
        return networkState;
    }

    public MutableLiveData<List<String>> getSliders() {
        slidermutablelivedata.setValue(sliderArrayList);
        return slidermutablelivedata;
    }


    public MutableLiveData<List<HomCategorymodel>> getHomeCategories() {

        GetSliderAndCategories();
        return homecategorymutablelivedata;
    }


    public MutableLiveData<List<HomeTopRatedProduct>> getHomeTopRatedProducts() {

        SetHomeTopRated();
        MutableLiveData<List<HomeTopRatedProduct>> data = new MutableLiveData<>();
        data.setValue(homeTopRatedProductArrayList);
        return data;
    }

    public MutableLiveData<List<ProductModel>> getProudcts() {

        MutableLiveData<List<ProductModel>> data = new MutableLiveData<>();
        data.setValue(productModelArrayList);
        return data;
    }

    public void SetHomeTopRated() {
        homeTopRatedProductArrayList.clear();
        homeTopRatedProductArrayList.add(new HomeTopRatedProduct("1", "Panadol", "https://firebasestorage.googleapis.com/v0/b/freshone-f45ef.appspot.com/o/icons8-health-book-48.png?alt=media&token=b3556f69-03a8-473f-aba6-9390067b23a5"));
        homeTopRatedProductArrayList.add(new HomeTopRatedProduct("2", "Dispreen", "https://firebasestorage.googleapis.com/v0/b/freshone-f45ef.appspot.com/o/icons8-health-checkup-16.png?alt=media&token=03b876dc-d5be-4ad7-9feb-21cc042133c1"));
        homeTopRatedProductArrayList.add(new HomeTopRatedProduct("3", "Medical", "https://firebasestorage.googleapis.com/v0/b/freshone-f45ef.appspot.com/o/icons8-mental-health-50.png?alt=media&token=8ddd3bb3-69bc-4f74-b51b-668a9b01f70e"));
        homeTopRatedProductArrayList.add(new HomeTopRatedProduct("4", "Vat", "https://firebasestorage.googleapis.com/v0/b/freshone-f45ef.appspot.com/o/icons8-mother's-health-64.png?alt=media&token=b58f2271-6b63-4b7d-947f-a8c6e7164c32"));
    }

    public void SetCategories() {
        homeCategoryModelArrayList.clear();
        homeCategoryModelArrayList.add(new HomCategorymodel("1", "Panadol", "https://firebasestorage.googleapis.com/v0/b/freshone-f45ef.appspot.com/o/icons8-health-book-48.png?alt=media&token=b3556f69-03a8-473f-aba6-9390067b23a5"));
        homeCategoryModelArrayList.add(new HomCategorymodel("2", "Dispreen", "https://firebasestorage.googleapis.com/v0/b/freshone-f45ef.appspot.com/o/icons8-health-checkup-16.png?alt=media&token=03b876dc-d5be-4ad7-9feb-21cc042133c1"));
        homeCategoryModelArrayList.add(new HomCategorymodel("3", "Medical", "https://firebasestorage.googleapis.com/v0/b/freshone-f45ef.appspot.com/o/icons8-mental-health-50.png?alt=media&token=8ddd3bb3-69bc-4f74-b51b-668a9b01f70e"));
        homeCategoryModelArrayList.add(new HomCategorymodel("4", "Vat", "https://firebasestorage.googleapis.com/v0/b/freshone-f45ef.appspot.com/o/icons8-mother's-health-64.png?alt=media&token=b58f2271-6b63-4b7d-947f-a8c6e7164c32"));
    }




    public void GetSliderAndCategories() {

        final List<HomCategorymodel> homCategorymodelList = new ArrayList<>();
        homCategorymodelList.clear();
        homeCategoryModelArrayList.clear();
        sliderArrayList.clear();
        networkState.postValue(NetworkState.LOADING);
        new MyRestClient(MyApp.getIntance(), AppConstant.BASEURL + AppConstant.GETCATEGORIES, MyRestClient.Method.GET, null, new NetworkOperationListener() {
            @Override
            public void onSuccess(JSONObject response) throws JSONException {

                networkState.postValue(NetworkState.LOADED);

                Gson gson = new Gson();

                JSONArray categories = response.getJSONArray("categories");
                JSONArray slider = response.getJSONArray("sliders");
                for (int i = 0; i < categories.length(); i++) {
                    HomCategorymodel homCategorymodel = gson.fromJson(categories.getJSONObject(i).toString(), HomCategorymodel.class);
                    homCategorymodelList.add(homCategorymodel);
                }

                for(int i=0;i<slider.length();i++)
                {

                    sliderArrayList.add(slider.getJSONObject(i).getString("slider_image"));
                }
                slidermutablelivedata.setValue(sliderArrayList);
                homeCategoryModelArrayList.addAll(homCategorymodelList);
                homecategorymutablelivedata.setValue(homeCategoryModelArrayList);
            }

            @Override
            public void onFailed(int code, String reason) {

                networkState.postValue(new NetworkState(NetworkState.Status.FAILED, reason));
            }
        }).executeReq();


    }

}
