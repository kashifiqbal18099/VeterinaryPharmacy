package com.kashif.veterinarypharmacy.home.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;

public class HomeTopRatedProduct extends BaseObservable implements Parcelable {

    String id;
    String name;
    String image;


    public HomeTopRatedProduct() {
    }

    public HomeTopRatedProduct(String id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.image);
    }

    protected HomeTopRatedProduct(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.image = in.readString();
    }

    public static final Parcelable.Creator<HomeTopRatedProduct> CREATOR = new Parcelable.Creator<HomeTopRatedProduct>() {
        @Override
        public HomeTopRatedProduct createFromParcel(Parcel source) {
            return new HomeTopRatedProduct(source);
        }

        @Override
        public HomeTopRatedProduct[] newArray(int size) {
            return new HomeTopRatedProduct[size];
        }
    };
}
