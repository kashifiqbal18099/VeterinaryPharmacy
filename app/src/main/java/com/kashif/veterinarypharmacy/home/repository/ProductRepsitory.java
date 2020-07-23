package com.kashif.veterinarypharmacy.home.repository;

import androidx.lifecycle.MutableLiveData;

import com.kashif.veterinarypharmacy.home.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class ProductRepsitory {
    private ArrayList<ProductModel> productModelArrayList  = new ArrayList<>();
    public static ProductRepsitory instance;

    public static ProductRepsitory getInstance(){
        if(instance == null){
            instance = new ProductRepsitory();
        }
        return instance;
    }



    public MutableLiveData<List<ProductModel>> getProudcts()
    {
        SetProducts();

        MutableLiveData<List<ProductModel>> data  = new MutableLiveData<>();
        data.setValue(productModelArrayList);
        return data;
    }


    public void SetProducts()
    {
        productModelArrayList.clear();

        productModelArrayList.add(new ProductModel("https://sc01.alicdn.com/kf/HTB1qR5oelTH8KJjy0Fiq6ARsXXa6.jpg_350x350.jpg,https://sc01.alicdn.com/kf/HTB1qR5oelTH8KJjy0Fiq6ARsXXa6.jpg_350x350.jpg,https://sc01.alicdn.com/kf/HTB1qR5oelTH8KJjy0Fiq6ARsXXa6.jpg_350x350.jpg","https://sc01.alicdn.com/kf/HTB1qR5oelTH8KJjy0Fiq6ARsXXa6.jpg_350x350.jpg","Dicloject injection","mg" , "100","70","20",false,"1"));
        productModelArrayList.add(new ProductModel("https://sc01.alicdn.com/kf/H4dd9a8efcbc34173b1cc6242c2b849600.jpg_350x350.jpg,https://sc01.alicdn.com/kf/HTB1qR5oelTH8KJjy0Fiq6ARsXXa6.jpg_350x350.jpg","https://sc01.alicdn.com/kf/H4dd9a8efcbc34173b1cc6242c2b849600.jpg_350x350.jpg","TY-DEXT 10","mg" , "100","70","20",true,"2"));
        productModelArrayList.add(new ProductModel("https://image.made-in-china.com/202f0j00ZdNTABOncCzp/Good-Factory-Veterinary-Injection-Factory-Supply-Best-Ivermectin-Price-Malaysia-Veterinary-Medicine-for-Big-Animals-Treatment.jpg,https://sc01.alicdn.com/kf/H4dd9a8efcbc34173b1cc6242c2b849600.jpg_350x350.jpg","https://image.made-in-china.com/202f0j00ZdNTABOncCzp/Good-Factory-Veterinary-Injection-Factory-Supply-Best-Ivermectin-Price-Malaysia-Veterinary-Medicine-for-Big-Animals-Treatment.jpg","HBXS","mg" , "100","70","20",true,"3"));
        productModelArrayList.add(new ProductModel("https://w7.pngwing.com/pngs/796/385/png-transparent-dog-cat-veterinarian-veterinary-medicine-live-dog-animals-sheep-laboratory.png,https://image.made-in-china.com/202f0j00ZdNTABOncCzp/Good-Factory-Veterinary-Injection-Factory-Supply-Best-Ivermectin-Price-Malaysia-Veterinary-Medicine-for-Big-Animals-Treatment.jpg","https://w7.pngwing.com/pngs/796/385/png-transparent-dog-cat-veterinarian-veterinary-medicine-live-dog-animals-sheep-laboratory.png","Hematex","mg" , "100","70","20",true,"4"));
        productModelArrayList.add(new ProductModel("https://sc01.alicdn.com/kf/HTB1qR5oelTH8KJjy0Fiq6ARsXXa6.jpg_350x350.jpg,https://w7.pngwing.com/pngs/796/385/png-transparent-dog-cat-veterinarian-veterinary-medicine-live-dog-animals-sheep-laboratory.png","https://sc01.alicdn.com/kf/HTB1qR5oelTH8KJjy0Fiq6ARsXXa6.jpg_350x350.jpg","Dicloject injection","mg" , "100","70","20",false,"5"));
        productModelArrayList.add(new ProductModel("https://sc01.alicdn.com/kf/H4dd9a8efcbc34173b1cc6242c2b849600.jpg_350x350.jpg,https://sc01.alicdn.com/kf/HTB1qR5oelTH8KJjy0Fiq6ARsXXa6.jpg_350x350.jpg","https://sc01.alicdn.com/kf/H4dd9a8efcbc34173b1cc6242c2b849600.jpg_350x350.jpg","TY-DEXT 10","mg" , "100","70","20",true,"6"));

    }


}
