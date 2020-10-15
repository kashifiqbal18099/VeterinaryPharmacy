package com.kashif.veterinarypharmacy.network;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This class act as the decider to cache the response/ fetch from the service always
 * Author: Lajesh D
 * Email: lajeshds2007@gmail.com
 * Created: 7/24/2018
 * Modified: 7/24/2018
 */
public abstract class NetworkBoundResource<T, V> {

    private final MediatorLiveData<Resource<T>> result = new MediatorLiveData<>();


    @MainThread
    protected NetworkBoundResource() {
        result.setValue(Resource.loading(null));

        // Always load the data from DB intially so that we have
        LiveData<T> dbSource = loadFromDb();

        result.removeSource(dbSource);
        if (shouldFetch()) {
            fetchFromNetwork(dbSource);
        } else {
            result.addSource(dbSource, newData -> {
                if(null != newData)
                    result.setValue(Resource.success(newData)); ;
            });
        }

        // Fetch the data from network and add it to the resource
        /*result.addSource(dbSource, data -> {

        });*/
    }

    /**
     * This method fetches the data from remoted service and save it to local db
     * @param dbSource - Database source
     */
    private void fetchFromNetwork(final LiveData<T> dbSource) {
        result.addSource(dbSource, newData -> result.setValue(Resource.loading(newData)));
        createCall().enqueue(new Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                result.removeSource(dbSource);

               if(response.isSuccessful())
               {
                   saveResultAndReInit(response.body());
               }

               else  if(response.code()==400)
               {
                   try {
                       JSONObject jsonObject=new JSONObject(response.errorBody().toString());
                       result.addSource(dbSource, newData -> {
                           try {
                               result.setValue(Resource.error(jsonObject.getString("msg"), newData));
                           } catch (JSONException e) {
                               e.printStackTrace();
                           }
                       });

                   }

                   catch (JSONException e) {
                       e.printStackTrace();
                   }
               }
               else if(response.code()==405)
               {

                   result.addSource(dbSource, newData -> result.setValue(Resource.error("405", newData)));

               }
               else{
                   result.addSource(dbSource, newData -> result.setValue(Resource.error("network Connection Error", newData)));

               }

            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                result.removeSource(dbSource);
                result.addSource(dbSource, newData -> result.setValue(Resource.error(getCustomErrorMessage(t), newData)));
            }
        });
    }

    private String getCustomErrorMessage(Throwable t){
        if (t instanceof IOException) {

      return  "network Connection Error";
            // logging probably not necessary
        }
        else if(t instanceof TimeoutException){
            return "Connection Timeout Please Check Your internet Connection";
        }
        else {
            return "Internet  Connection Error Please Check Your internet Connection";
        }
    }

    @SuppressLint("StaticFieldLeak")
    @MainThread
    private void saveResultAndReInit(T response) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                saveCallResult(response);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
              /*  result.addSource(loadFromDb(), newData -> {


                    if (null != newData)

                });*/
                result.setValue(Resource.success(response));
            }
        }.execute();
    }

    @WorkerThread
    protected abstract void saveCallResult(T item);

    @MainThread
    private boolean shouldFetch() {
        return true;
    }

    @NonNull
    @MainThread
    protected abstract LiveData<T> loadFromDb();

    @NonNull
    @MainThread
    protected abstract Call<T> createCall();

    public final LiveData<Resource<T>> getAsLiveData() {
        return result;
    }
}
