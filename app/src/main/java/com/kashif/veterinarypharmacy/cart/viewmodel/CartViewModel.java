package com.kashif.veterinarypharmacy.cart.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kashif.veterinarypharmacy.cart.db.CartModel;
import com.kashif.veterinarypharmacy.cart.repository.CartRepository;

import java.util.List;

public class CartViewModel extends AndroidViewModel {

    CartRepository cartRepository;
    LiveData<List<CartModel>> cartlist;

    public CartViewModel(Application application)
    {
        super(application);
        cartRepository = new CartRepository(application);

        if(cartlist!=null && cartlist.getValue()!=null)
            cartlist.getValue().clear();

        cartlist  = cartRepository.getCartlist();
    }

    public LiveData<List<CartModel>> getCartlist()
    {
        return cartlist;
    }

    public void addToCart(CartModel cartModel)
    {
        cartRepository.addToCart(cartModel);
    }
    public Integer getQty(String id)
    {
        return  cartRepository.getQty(id);
    }
    public void UpdateQty(String product_id,int newqty)
    {
        cartRepository.UpdateQty(product_id,newqty);
    }

    public void DeleteProduct(String id)
    {
        cartRepository.DeleteProduct(id);
    }

    public LiveData<Integer> getAllQty()
    {
        return cartRepository.getAllQty();
    }

    public LiveData<Float> getTotalAmount()
    {
        return cartRepository.getTotalPrice();
    }
    public LiveData<Float> getTotalDiscount()
    {
        return cartRepository.getTotalDiscount();
    }
}
