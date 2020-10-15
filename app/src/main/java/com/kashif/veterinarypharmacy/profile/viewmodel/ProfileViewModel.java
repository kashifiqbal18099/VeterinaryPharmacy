package com.kashif.veterinarypharmacy.profile.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.kashif.veterinarypharmacy.network.ApiClientSet;
import com.kashif.veterinarypharmacy.network.RetrofitServices;
import com.kashif.veterinarypharmacy.profile.model.ProfileItemModel;
import com.kashif.veterinarypharmacy.profile.repository.ProfileRepository;

import java.util.List;

import retrofit2.Retrofit;

public class ProfileViewModel extends AndroidViewModel {

    ProfileRepository profileRepository;
    RetrofitServices retrofitServices;
    LiveData<List<ProfileItemModel>> profileitemlivedata =  new MutableLiveData<>();
    public ProfileViewModel(@NonNull Application application) {
        super(application);
        Retrofit retrofit= ApiClientSet.getClient();
        retrofitServices  = retrofit.create(RetrofitServices.class);
        profileRepository  = ProfileRepository.getInstance(retrofitServices);
    }

    public LiveData<List<ProfileItemModel>> getProfileitemlivedata() {
        return profileRepository.getProfleitemlivedata();
    }
}
