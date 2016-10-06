package com.esgi.handiwe.BLL;


import android.util.Log;

import com.esgi.handiwe.DAL.ApiService;
import com.esgi.handiwe.Model.Conversation;
import com.esgi.handiwe.Model.Vehicule;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nico on 06/10/2016.
 */

public abstract class VehiculeManager {

    public ArrayList<Vehicule> listVehicule = new ArrayList<Vehicule>();

    public VehiculeManager() {
        apiGetAllVehicule();
    }

    //region API

    public void apiGetAllVehicule() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<ArrayList<Vehicule>> call = apiService.listVehicule();

        Log.d("CALL", "Test 1");
        call.enqueue(new Callback<ArrayList<Vehicule>>(){
            @Override
            public void onResponse(Call<ArrayList<Vehicule>> call, Response<ArrayList<Vehicule>> response) {
                Log.d("CALL", "Test");

                int statusCode = response.code();
                ArrayList<Vehicule> vehicules = response.body();
                Log.d("VEHICULE", vehicules.get(5).get_marque());
                Log.d("VEHICULE", vehicules.get(0).get_marque());
                Log.d("VEHICULE", vehicules.get(2).get_marque());
                Log.d("VEHICULE", vehicules.get(11).get_marque());
                setAllVehicule(vehicules, statusCode);

                onFinish();

            }

            @Override
            public void onFailure(Call<ArrayList<Vehicule>> call, Throwable throwable) {
                Log.d("CALL", "On Failure");
                Log.d("CALL", throwable.getMessage());
                setAllVehicule(new ArrayList<Vehicule>(), 0);
            }
        });
    }

    public void apiSetVehiculeReserve(int id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        apiService.setVehiculeReserve(id);

    }
    //endregion

    public void setAllVehicule(ArrayList<Vehicule> list, int statusCode){
        listVehicule = list;
    }

    public ArrayList<Vehicule> getListVehicule() {
        return listVehicule;
    }

    public void setVehiculeReserve(int id) {
        for (Vehicule item : listVehicule) {
            if (item.get_id() == id) {
                item.setReserve(true);
            }
        }
        apiSetVehiculeReserve(id);
    }
    public abstract void onFinish();
}