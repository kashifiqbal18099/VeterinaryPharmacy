package com.kashif.veterinarypharmacy.home.repository;

import androidx.lifecycle.MutableLiveData;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.kashif.veterinarypharmacy.home.model.HomCategorymodel;
import com.kashif.veterinarypharmacy.home.model.HomeTopRatedProduct;
import com.kashif.veterinarypharmacy.home.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class HomeRepository {
    public static HomeRepository instance;
    private ArrayList<SlideModel> sliderArrayList  = new ArrayList<>();
    private ArrayList<HomCategorymodel> homeCategoryModelArrayList  = new ArrayList<>();
    private ArrayList<HomeTopRatedProduct> homeTopRatedProductArrayList  = new ArrayList<>();
    private ArrayList<ProductModel> productModelArrayList  = new ArrayList<>();

    public static HomeRepository getInstance(){
        if(instance == null){
            instance = new HomeRepository();
        }
        return instance;
    }

    public MutableLiveData<List<SlideModel>> getSliders()
    {
        SetSlider();
        MutableLiveData<List<SlideModel>> data = new MutableLiveData<>();
        data.setValue(sliderArrayList);
        return data;
    }


    public  MutableLiveData<List<HomCategorymodel>> getHomeCategories()
    {

        SetCategories();;
        MutableLiveData<List<HomCategorymodel>> data  = new MutableLiveData<>();
        data.setValue(homeCategoryModelArrayList);
        return data;
    }


    public  MutableLiveData<List<HomeTopRatedProduct>> getHomeTopRatedProducts()
    {

        SetHomeTopRated();
        MutableLiveData<List<HomeTopRatedProduct>> data  = new MutableLiveData<>();
        data.setValue(homeTopRatedProductArrayList);
        return data;
    }

    public MutableLiveData<List<ProductModel>> getProudcts()
    {
        SetProducts();

        MutableLiveData<List<ProductModel>> data  = new MutableLiveData<>();
        data.setValue(productModelArrayList);
        return data;
    }

    public void SetHomeTopRated()
    {
        homeTopRatedProductArrayList.clear();
        homeTopRatedProductArrayList.add(new HomeTopRatedProduct("1","Panadol","https://firebasestorage.googleapis.com/v0/b/freshone-f45ef.appspot.com/o/icons8-health-book-48.png?alt=media&token=b3556f69-03a8-473f-aba6-9390067b23a5"));
        homeTopRatedProductArrayList.add(new HomeTopRatedProduct("2","Dispreen","https://firebasestorage.googleapis.com/v0/b/freshone-f45ef.appspot.com/o/icons8-health-checkup-16.png?alt=media&token=03b876dc-d5be-4ad7-9feb-21cc042133c1"));
        homeTopRatedProductArrayList.add(new HomeTopRatedProduct("3","Medical","https://firebasestorage.googleapis.com/v0/b/freshone-f45ef.appspot.com/o/icons8-mental-health-50.png?alt=media&token=8ddd3bb3-69bc-4f74-b51b-668a9b01f70e"));
        homeTopRatedProductArrayList.add(new HomeTopRatedProduct("4","Vat","https://firebasestorage.googleapis.com/v0/b/freshone-f45ef.appspot.com/o/icons8-mother's-health-64.png?alt=media&token=b58f2271-6b63-4b7d-947f-a8c6e7164c32"));
    }

    public void SetCategories()
    {
        homeCategoryModelArrayList.clear();
        homeCategoryModelArrayList.add(new HomCategorymodel("1","Panadol","https://firebasestorage.googleapis.com/v0/b/freshone-f45ef.appspot.com/o/icons8-health-book-48.png?alt=media&token=b3556f69-03a8-473f-aba6-9390067b23a5"));
        homeCategoryModelArrayList.add(new HomCategorymodel("2","Dispreen","https://firebasestorage.googleapis.com/v0/b/freshone-f45ef.appspot.com/o/icons8-health-checkup-16.png?alt=media&token=03b876dc-d5be-4ad7-9feb-21cc042133c1"));
        homeCategoryModelArrayList.add(new HomCategorymodel("3","Medical","https://firebasestorage.googleapis.com/v0/b/freshone-f45ef.appspot.com/o/icons8-mental-health-50.png?alt=media&token=8ddd3bb3-69bc-4f74-b51b-668a9b01f70e"));
        homeCategoryModelArrayList.add(new HomCategorymodel("4","Vat","https://firebasestorage.googleapis.com/v0/b/freshone-f45ef.appspot.com/o/icons8-mother's-health-64.png?alt=media&token=b58f2271-6b63-4b7d-947f-a8c6e7164c32"));
    }
    public void SetSlider()
    {

        homeTopRatedProductArrayList.clear();
        sliderArrayList.add(new SlideModel("https://bit.ly/2YoJ77H", ScaleTypes.CENTER_CROP));
        sliderArrayList.add(new SlideModel("https://bit.ly/2BteuF2",ScaleTypes.CENTER_CROP));
        sliderArrayList.add(new SlideModel("https://bit.ly/3fLJf72",ScaleTypes.CENTER_CROP));

    }

    public void SetProducts()
    {
        productModelArrayList.clear();

        productModelArrayList.add(new ProductModel("https://sc01.alicdn.com/kf/HTB1qR5oelTH8KJjy0Fiq6ARsXXa6.jpg_350x350.jpg","Dicloject injection","mg" , "100","70","20",false));
        productModelArrayList.add(new ProductModel("https://sc01.alicdn.com/kf/H4dd9a8efcbc34173b1cc6242c2b849600.jpg_350x350.jpg","TY-DEXT 10","mg" , "100","70","20",true));
        productModelArrayList.add(new ProductModel("https://image.made-in-china.com/202f0j00ZdNTABOncCzp/Good-Factory-Veterinary-Injection-Factory-Supply-Best-Ivermectin-Price-Malaysia-Veterinary-Medicine-for-Big-Animals-Treatment.jpg","HBXS","mg" , "100","70","20",true));
        productModelArrayList.add(new ProductModel("https://w7.pngwing.com/pngs/796/385/png-transparent-dog-cat-veterinarian-veterinary-medicine-live-dog-animals-sheep-laboratory.png","Hematex","mg" , "100","70","20",true));
        productModelArrayList.add(new ProductModel("https://sc01.alicdn.com/kf/HTB1qR5oelTH8KJjy0Fiq6ARsXXa6.jpg_350x350.jpg","Dicloject injection","mg" , "100","70","20",false));
        productModelArrayList.add(new ProductModel("https://sc01.alicdn.com/kf/H4dd9a8efcbc34173b1cc6242c2b849600.jpg_350x350.jpg","TY-DEXT 10","mg" , "100","70","20",true));

    }


}
