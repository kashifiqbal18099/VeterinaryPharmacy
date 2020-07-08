package com.kashif.veterinarypharmacy.home.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class ProductModel extends BaseObservable {
    String image;
    String name;
    String unit;
    String original_price;
    String promo_price;
    String precent_off;
    boolean is_fav;


    public ProductModel() {
    }

    public ProductModel(String image, String name, String unit, String original_price, String promo_price, String precent_off, boolean is_fav) {
        this.image = image;
        this.name = name;
        this.unit = unit;
        this.original_price = original_price;
        this.promo_price = promo_price;
        this.precent_off = precent_off;
        this.is_fav = is_fav;
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
    }
}
