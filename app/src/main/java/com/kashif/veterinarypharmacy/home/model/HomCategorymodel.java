package com.kashif.veterinarypharmacy.home.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class HomCategorymodel extends BaseObservable implements Parcelable {
    String id;
    String name;
    String image;


    public HomCategorymodel() {
    }

    public HomCategorymodel(String id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
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

    protected HomCategorymodel(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.image = in.readString();
    }

    public static final Parcelable.Creator<HomCategorymodel> CREATOR = new Parcelable.Creator<HomCategorymodel>() {
        @Override
        public HomCategorymodel createFromParcel(Parcel source) {
            return new HomCategorymodel(source);
        }

        @Override
        public HomCategorymodel[] newArray(int size) {
            return new HomCategorymodel[size];
        }
    };
}
