package com.kashif.veterinarypharmacy.profile.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.kashif.veterinarypharmacy.home.repository.HomeRepository;
import com.kashif.veterinarypharmacy.network.RetrofitServices;
import com.kashif.veterinarypharmacy.profile.model.ProfileItemModel;

import java.util.ArrayList;
import java.util.List;

public class ProfileRepository {

    MutableLiveData<List<ProfileItemModel>> profleitemlivedata  = new MutableLiveData<>();
    List<ProfileItemModel> profileItemModels  = new ArrayList<>();
    public static ProfileRepository instance;
    RetrofitServices retrofitServices;

    public ProfileRepository(RetrofitServices retrofitServices) {
        this.retrofitServices  =retrofitServices;
        SetProfileItem();
    }

    public static ProfileRepository getInstance(RetrofitServices retrofitServices) {

        if (instance == null) {
            instance = new ProfileRepository(retrofitServices);
        }

        return instance;
    }

    public LiveData<List<ProfileItemModel>> getProfleitemlivedata() {
        return profleitemlivedata;
    }

    public void SetProfileItem()
    {
        profileItemModels.add(new ProfileItemModel("My Orders","ORDER_ICON"));
        profileItemModels.add(new ProfileItemModel("My Rewards Points","REWARD_ICON"));
        profileItemModels.add(new ProfileItemModel("Consultation","CONSULTATION_ICON"));

        profileItemModels.add(new ProfileItemModel("P24 Wallet","WALLET_ICON"));
        profileItemModels.add(new ProfileItemModel("Wishlist","WISHLIST_ICON"));
        profileItemModels.add(new ProfileItemModel("My Rewards Points","REWARD_ICON"));


        profileItemModels.add(new ProfileItemModel("Upload Prescription","PRESCRIPTIPN_ICON"));
        profileItemModels.add(new ProfileItemModel("Change Password","PASSWORD_ICON"));
        profileItemModels.add(new ProfileItemModel("Signout","SIGNOUT_ICON"));

        profleitemlivedata.setValue(profileItemModels);

    }
}
