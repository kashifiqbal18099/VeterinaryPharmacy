package com.kashif.veterinarypharmacy.home.model;

import java.util.List;

public class HomeCategoryResponse   {

    List<HomeCategorymodel> categories;
    List<SliderModel> sliders;

    public HomeCategoryResponse() {
    }

    public List<HomeCategorymodel> getCategories() {
        return categories;
    }

    public void setCategories(List<HomeCategorymodel> categories) {
        this.categories = categories;
    }

    public List<SliderModel> getSliders() {
        return sliders;
    }

    public void setSliders(List<SliderModel> sliders) {
        this.sliders = sliders;
    }
}
