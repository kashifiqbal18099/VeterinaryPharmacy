package com.kashif.veterinarypharmacy.home.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class HomeCategorymodel extends BaseObservable implements Parcelable {
    String ID;
    String category_title;
    String category_image;


    public HomeCategorymodel() {
    }

    public HomeCategorymodel(String id, String name, String image) {
        this.ID = id;
        this.category_title = name;
        this.category_image = image;
    }

    @Bindable
    public String getId() {
        return ID;
    }

    public void setId(String id) {
        this.ID = id;
    }

    @Bindable
    public String getCategory_title() {
        return category_title;
    }

    public void setCategory_title(String category_title) {
        this.category_title = category_title;
    }

    @Bindable
    public String getCategory_image() {
        return category_image.matches("'^http://'") ? category_image.replace("http://","https://") : category_image;
    }

    public void setCategory_image(String category_image) {
        this.category_image = category_image;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ID);
        dest.writeString(this.category_title);
        dest.writeString(this.category_image);
    }

    protected HomeCategorymodel(Parcel in) {
        this.ID = in.readString();
        this.category_title = in.readString();
        this.category_image = in.readString();
    }

    public static final Parcelable.Creator<HomeCategorymodel> CREATOR = new Parcelable.Creator<HomeCategorymodel>() {
        @Override
        public HomeCategorymodel createFromParcel(Parcel source) {
            return new HomeCategorymodel(source);
        }

        @Override
        public HomeCategorymodel[] newArray(int size) {
            return new HomeCategorymodel[size];
        }
    };
}
