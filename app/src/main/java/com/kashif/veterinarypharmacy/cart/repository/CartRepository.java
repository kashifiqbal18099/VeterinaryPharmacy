package com.kashif.veterinarypharmacy.cart.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.kashif.veterinarypharmacy.base.ApplicationDatabase;
import com.kashif.veterinarypharmacy.cart.db.CartDao;
import com.kashif.veterinarypharmacy.cart.db.CartModel;

import java.util.List;

public class CartRepository {
    CartDao cartDao;
    private LiveData<List<CartModel>> cartlist;

    public CartRepository(Application application)
    {
        ApplicationDatabase db  =  ApplicationDatabase.getInstance(application);
        cartDao  =  db.cartDao();

        if(cartlist!=null && cartlist.getValue()!=null)
            cartlist.getValue().clear();

        cartlist  = cartDao.getAll();
    }

    public LiveData<List<CartModel>> getCartlist()
    {
        return cartlist;
    }

    public Integer getQty(String id)
    {
        return cartDao.getQty(id);
    }

    public void UpdateQty(String product_id, int newqty)
    {
        new UpadteQtyAsyncTask(cartDao,product_id,newqty).execute();
    }

    public void addToCart(CartModel cartModel)
    {

        new InsertAsyncTask(cartDao).execute(cartModel);
    }

    public LiveData<Integer> getAllQty()
    {
       return cartDao.getAllQty();
    }

    public LiveData<Float> getTotalPrice()
    {
        return cartDao.getTotalAmount();
    }

    public LiveData<Float> getTotalDiscount()
    {
        return cartDao.getTotalDiscount();
    }




    public void DeleteProduct(String id)
    {
       new  DeleteProductAsyncTask(cartDao,id).execute();
    }


    private static class InsertAsyncTask extends AsyncTask<CartModel, Void, Void> {

        private CartDao cartDao;

        InsertAsyncTask(CartDao personDao) {
            this.cartDao = personDao;
        }

        @Override
        protected Void doInBackground(final CartModel... params) {
            cartDao.insert(params[0]);
            return null;
        }
    }

    private static class UpadteQtyAsyncTask extends AsyncTask<Void, Void, Void> {

        private CartDao cartDao;
        String product_id;
        int newqty;

        public UpadteQtyAsyncTask(CartDao cartDao, String product_id, int newqty) {
            this.cartDao = cartDao;
            this.product_id = product_id;
            this.newqty = newqty;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            cartDao.updateQty(product_id,newqty);
            return null;
        }

    }

    private static class DeleteProductAsyncTask extends AsyncTask<Void, Void, Void> {

        private CartDao cartDao;
        String product_id;

        public DeleteProductAsyncTask(CartDao cartDao, String product_id) {
            this.cartDao = cartDao;
            this.product_id = product_id;

        }

        @Override
        protected Void doInBackground(final Void... params) {
            cartDao.DeleteProductFromCart(product_id);
            return null;
        }

    }
}
