package com.kashif.veterinarypharmacy.cart.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.base.BaseActivity;
import com.kashif.veterinarypharmacy.cart.adapter.CartListAdapter;
import com.kashif.veterinarypharmacy.cart.db.CartModel;
import com.kashif.veterinarypharmacy.cart.viewmodel.CartViewModel;
import com.kashif.veterinarypharmacy.databinding.ActivityCartBinding;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends BaseActivity<ActivityCartBinding> implements CartListAdapter.CartAdapterInterface{

    CartViewModel cartViewModel;
    CartListAdapter cartListAdapter;
    List<CartModel> cartModelList  = new ArrayList<>();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cartViewModel  = ViewModelProviders.of(this).get(CartViewModel.class);
        dataBinding.top.notificationIcon.setVisibility(View.GONE);
        dataBinding.top.backLinear.setVisibility(View.VISIBLE);
        dataBinding.top.title.setText(R.string.your_cart);
        dataBinding.top.logo.setVisibility(View.GONE);
        InitRecylerView();
        GetCartList();
        GetCartQtyAndTotalAmount();

    }
    public void InitRecylerView()
    {
        cartListAdapter  = new CartListAdapter(this,cartModelList,this);
        dataBinding.cartListRec.setAdapter(cartListAdapter);
    }

    public void GetCartList()
    {
        cartViewModel.getCartlist().observe(this, new Observer<List<CartModel>>() {
            @Override
            public void onChanged(List<CartModel> cartModels) {
                cartModelList.clear();
                cartModelList.addAll(cartModels);
                cartListAdapter.notifyDataSetChanged();
            }
        });
    }
    public void GetCartQtyAndTotalAmount() {

        cartViewModel.getAllQty().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer qty) {
                dataBinding.top.badgeNotification1.setVisibility(View.VISIBLE);
                dataBinding.top.badgeNotification1.setText(String.valueOf(qty));
            }
        });

        cartViewModel.getTotalAmount().observe(this, new Observer<Float>() {


            @Override
            public void onChanged(final Float total) {

                final float totalamount  = total;

                cartViewModel.getTotalDiscount().observe(CartActivity.this, new Observer<Float>() {
                    @Override
                    public void onChanged(Float discount) {

                        float finaltotal   =  (total - discount) + 500;

                        dataBinding.orderDiscountValue.setText(String.valueOf(discount) + " PKR");
                        dataBinding.orderTotalValue.setText(String.valueOf(totalamount) + " PKR");
                        dataBinding.orderShippingValue.setText("500 PKR");
                        dataBinding.totalAmountValue.setText(String.valueOf(finaltotal) + " PKR");
                    }
                });

            }
        });


    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_cart;
    }

    @Override
    public void OnCartUpdated(final CartModel model, final int val, final int position) {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                Integer qty=  cartViewModel.getQty(model.getProduct_id());

                if(qty==1 && val==-1)
                {
                    cartViewModel.DeleteProduct(model.getProduct_id());
                    cartModelList.remove(position);
                    final Runnable runnable = new Runnable() {
                        @Override
                        public void run() {

                            cartListAdapter.notifyItemRemoved(position);
                        }
                    };


                }

                if(qty>0)
                {
                    qty  = qty+val;
                    cartViewModel.UpdateQty(model.getProduct_id(),qty);
                }




            }
        });

    }

    @Override
    public void OnProductDeleted(CartModel model, int position) {
        cartViewModel.DeleteProduct(model.getProduct_id());
        cartModelList.remove(position);
        cartListAdapter.notifyItemRemoved(position);
    }
}