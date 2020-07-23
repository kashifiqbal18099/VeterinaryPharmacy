package com.kashif.veterinarypharmacy.cart.db;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CartDao {

    @Query("SELECT * FROM CART")
    LiveData<List<CartModel>> getAll();

    @Query("SELECT qty FROM CART WHERE product_id =:id")
    int getQty(String id);

    @Query("UPDATE CART SET qty = :newqty WHERE product_id = :id")
    void updateQty(String id,int newqty);

    @Query("SELECT COALESCE(sum(COALESCE(qty,0)), 0)From CART")
    LiveData<Integer> getAllQty();

    @Query("SELECT COALESCE(sum(COALESCE(product_price * qty,0)), 0)  From CART")
    LiveData<Float> getTotalAmount();

    @Query("SELECT COALESCE(sum(COALESCE(discount * qty,0)), 0) From CART")
    LiveData<Float> getTotalDiscount();

    @Query("DELETE FROM cart WHERE product_id=:id")
    void DeleteProductFromCart(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CartModel cartModel);
}
