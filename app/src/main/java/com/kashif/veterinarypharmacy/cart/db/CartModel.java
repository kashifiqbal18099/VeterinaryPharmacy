package com.kashif.veterinarypharmacy.cart.db;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cart")
public class CartModel  extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name ="cart_id")
    String cart_id;
    @ColumnInfo(name ="qty")
    int qty;

    @ColumnInfo(name ="product_id")
    String product_id;
    @ColumnInfo(name ="product_name")
    String product_name;
    @ColumnInfo(name ="product_details")
    String product_details;
    @ColumnInfo(name ="product_price")
    float product_price;
    @ColumnInfo(name ="discount")
    float discount;
    @ColumnInfo(name ="image")
    String image;

    public CartModel() {
    }

    public CartModel(String cart_id, int qty, String product_id, String product_name, String product_details, float product_price, float discount, String image) {
        this.cart_id = cart_id;
        this.qty = qty;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_details = product_details;
        this.product_price = product_price;
        this.discount = discount;
        this.image = image;
    }

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    @Bindable
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    @Bindable
    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }


    public String getProduct_details() {
        return product_details;
    }

    public void setProduct_details(String product_details) {
        this.product_details = product_details;
    }

    @Bindable
    public float getProduct_price() {
        return product_price;
    }

    public void setProduct_price(float product_price) {
        this.product_price = product_price;
    }

    @Bindable
    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Bindable
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
