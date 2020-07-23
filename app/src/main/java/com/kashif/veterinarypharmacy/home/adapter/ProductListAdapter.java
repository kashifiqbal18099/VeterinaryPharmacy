package com.kashif.veterinarypharmacy.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.widget.ImageView;

import com.kashif.veterinarypharmacy.R;
import com.kashif.veterinarypharmacy.base.GenericAdapter;
import com.kashif.veterinarypharmacy.databinding.ProductListItemBinding;
import com.kashif.veterinarypharmacy.home.activity.ProductDetailsActivity;
import com.kashif.veterinarypharmacy.home.model.ProductModel;

import java.util.List;

public class ProductListAdapter extends GenericAdapter<ProductModel, ProductListItemBinding> {

    ProductListInterface productListInterface;
    Context context;

    public ProductListAdapter(Context context, List<ProductModel> arrayList,ProductListInterface productListInterface) {
        super(context, arrayList);
        this.context  = context;
        this.productListInterface   = productListInterface;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.product_list_item;
    }

    @Override
    public void onBindData(final ProductModel model, int position, final ProductListItemBinding dataBinding) {

        dataBinding.setViewmodel(model);

        dataBinding.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(model.isIs_fav())
                {
                    model.setIs_fav(false);

                }
                else
                {
                    model.setIs_fav(true);

                }

            }
        });



        dataBinding.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productListInterface.OnAddToCart(model,dataBinding.imageCopy);
            }
        });
    }

    @Override
    public void onItemClick(ProductModel model, int position, ProductListItemBinding dataBinding) {
        Intent intent  = new Intent(context, ProductDetailsActivity.class);
        intent.putExtra("product",model);
        context.startActivity(intent);
    }

    public interface  ProductListInterface
    {
        void OnAddToCart(ProductModel productModel, ImageView view);
    }
}
