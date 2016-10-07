package com.esgi.handiwe.BLL;

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
 * Created by Pico on 06/10/2016.
 */

public class VehiculeManager {

    private ArrayList<Vehicule> listVehicule;

    public VehiculeManager(ArrayList<Vehicule> listVehicule) {
        apiGetAllVehicule();
    }

    //region API

    public void apiGetAllVehicule() {
        ArrayList<Vehicule> listVehicule = new ArrayList<Vehicule>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<ArrayList<Vehicule>> call = apiService.listVehicule();
        call.enqueue(new Callback<ArrayList<Vehicule>>(){
            @Override
            public void onResponse(Call<ArrayList<Vehicule>> call, Response<ArrayList<Vehicule>> response) {
                int statusCode = response.code();
                ArrayList<Vehicule> vehicules = response.body();
                setAllVehicule(vehicules, statusCode);
            }

            @Override
            public void onFailure(Call<ArrayList<Vehicule>> call, Throwable throwable) {
                setAllVehicule(new ArrayList<Vehicule>(), 0);
            }


        });
    }

    public void apiSetVehiculeReserve(int id) {
        Log.d("TEST", "IN SET RESERVE");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d("TEST", "IN SET RESERVE");

        ApiService apiService = retrofit.create(ApiService.class);
        Log.d("TEST", "IN SET RESERVE");

        Call<Integer> idCar = apiService.setVehiculeReserve(id);
        idCar.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {

                Log.d("TEST", "Response is "+response);
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });
        Log.d("TEST", "IN SET RESERVE");

    }
    //endregion

    public void setAllVehicule(ArrayList<Vehicule> list, int statusCode){
        listVehicule = list;
    }

    public ArrayList<Vehicule> getListVehicule() {
        return listVehicule;
    }

    public void setVehiculeReserve(int id){
        for (Vehicule item : listVehicule) {
            if (item.get_id()==id){
                item.setReserve(true);
            }
        }
        apiSetVehiculeReserve(id);
    }

}
