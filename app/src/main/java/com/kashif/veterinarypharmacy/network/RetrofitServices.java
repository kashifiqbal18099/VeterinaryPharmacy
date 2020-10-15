package com.kashif.veterinarypharmacy.network;

import com.kashif.veterinarypharmacy.home.model.HomeCategoryResponse;
import com.kashif.veterinarypharmacy.home.model.HomeCategorymodel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitServices {

    @GET("/veterinary/index.php/api/GetCategories")
    Call<HomeCategoryResponse>  getHomeCategories();

}
