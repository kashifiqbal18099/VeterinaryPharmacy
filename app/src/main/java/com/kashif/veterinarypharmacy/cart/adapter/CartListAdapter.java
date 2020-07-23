package com.kashif.veterinarypharmacy.cart.adapter;

import android.content.Context;
import android.view.View;

import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.base.GenericAdapter;
import com.kashif.veterinarypharmacy.cart.db.CartModel;
import com.kashif.veterinarypharmacy.databinding.CartListItemBinding;

import java.util.List;

public class CartListAdapter extends GenericAdapter<CartModel, CartListItemBinding> {


    CartAdapterInterface cartAdapterInterface;


    public CartListAdapter(Context context, List<CartModel> arrayList, CartAdapterInterface cartAdapterInterface) {
        super(context, arrayList);
        this.cartAdapterInterface  = cartAdapterInterface;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.cart_list_item;
    }

    @Override
    public void onBindData(final CartModel model, final int position, CartListItemBinding dataBinding) {


        dataBinding.setViewmodel(model);

        dataBinding.addQty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartAdapterInterface.OnCartUpdated(model,+1,position);
            }
        });

        dataBinding.removeQty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartAdapterInterface.OnCartUpdated(model,-1,position);
            }
        });


        dataBinding.removeProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cartAdapterInterface.OnProductDeleted(model,position);
            }
        });
    }

    @Override
    public void onItemClick(CartModel model, int position, CartListItemBinding dataBinding) {

    }

    public interface CartAdapterInterface
    {
        void OnCartUpdated(CartModel model,int val,int position);
        void OnProductDeleted(CartModel model,int position);
    }
}
