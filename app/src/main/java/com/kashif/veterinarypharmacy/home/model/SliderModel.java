package com.kashif.veterinarypharmacy.home.model;

public class SliderModel {
    String ID;
    String slider_image;
    String is_active;
    String created_at;
    String updated_at;

    public SliderModel() {
    }

    public SliderModel(String ID, String slider_image, String is_active, String created_at, String updated_at) {
        this.ID = ID;
        this.slider_image = slider_image;
        this.is_active = is_active;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSlider_image() {
        return slider_image;
    }

    public void setSlider_image(String slider_image) {
        this.slider_image = slider_image;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
