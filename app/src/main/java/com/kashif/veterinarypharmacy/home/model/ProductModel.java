package com.kashif.veterinarypharmacy.home.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class ProductModel extends BaseObservable implements Parcelable {
    String image;
    String thumbail;
    String name;
    String unit;
    String original_price;
    String promo_price;
    String precent_off;
    boolean is_fav;
    String id;


    public ProductModel() {
    }

    public ProductModel(String image, String thumbail, String name, String unit, String original_price, String promo_price, String precent_off, boolean is_fav, String id) {
        this.image = image;
        this.thumbail = thumbail;
        this.name = name;
        this.unit = unit;
        this.original_price = original_price;
        this.promo_price = promo_price;
        this.precent_off = precent_off;
        this.is_fav = is_fav;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Bindable
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Bindable
    public String getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(String original_price) {
        this.original_price = original_price;
    }

    @Bindable
    public String getPromo_price() {
        return promo_price;
    }

    public void setPromo_price(String promo_price) {
        this.promo_price = promo_price;
    }

    @Bindable
    public String getPrecent_off() {
        return precent_off;
    }

    public void setPrecent_off(String precent_off) {
        this.precent_off = precent_off;
    }

    @Bindable
    public boolean isIs_fav() {
        return is_fav;

    }

    public void setIs_fav(boolean is_fav) {
        this.is_fav = is_fav;
        notifyPropertyChanged(BR.is_fav);
    }

    @Bindable
    public String getThumbail() {
        return thumbail;
    }

    public void setThumbail(String thumbail) {
        this.thumbail = thumbail;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.image);
        dest.writeString(this.thumbail);
        dest.writeString(this.name);
        dest.writeString(this.unit);
        dest.writeString(this.original_price);
        dest.writeString(this.promo_price);
        dest.writeString(this.precent_off);
        dest.writeByte(this.is_fav ? (byte) 1 : (byte) 0);
        dest.writeString(this.id);
    }

    protected ProductModel(Parcel in) {
        this.image = in.readString();
        this.thumbail = in.readString();
        this.name = in.readString();
        this.unit = in.readString();
        this.original_price = in.readString();
        this.promo_price = in.readString();
        this.precent_off = in.readString();
        this.is_fav = in.readByte() != 0;
        this.id = in.readString();
    }

    public static final Parcelable.Creator<ProductModel> CREATOR = new Parcelable.Creator<ProductModel>() {
        @Override
        public ProductModel createFromParcel(Parcel source) {
            return new ProductModel(source);
        }

        @Override
        public ProductModel[] newArray(int size) {
            return new ProductModel[size];
        }
    };
}
