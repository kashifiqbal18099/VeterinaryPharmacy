package com.kashif.veterinarypharmacy.profile.model;

import androidx.databinding.BaseObservable;

public class ProfileItemModel extends BaseObservable {
    String item_name;
    String item_icon;

    public ProfileItemModel(String item_name, String item_icon) {
        this.item_name = item_name;
        this.item_icon = item_icon;
    }

    public ProfileItemModel() {
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_icon() {
        return item_icon;
    }

    public void setItem_icon(String item_icon) {
        this.item_icon = item_icon;
    }
}
