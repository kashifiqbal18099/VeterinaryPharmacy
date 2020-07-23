package com.kashif.veterinarypharmacy.base;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.kashif.veterinarypharmacy.cart.db.CartDao;
import com.kashif.veterinarypharmacy.cart.db.CartModel;

@Database(entities = {CartModel.class}, version = 1)
public abstract  class ApplicationDatabase extends RoomDatabase {

    private static volatile ApplicationDatabase INSTANCE;
    public abstract CartDao cartDao();

    public static ApplicationDatabase getInstance(Context context) {
        if(INSTANCE == null) {
            synchronized(ApplicationDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ApplicationDatabase.class, "petcaredb.db").build();
                }
            }
        }
        return INSTANCE;
    }

}
