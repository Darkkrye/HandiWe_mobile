package com.esgi.handiwe.BLL;

import android.util.Log;

import com.esgi.handiwe.DAL.ApiService;
import com.esgi.handiwe.Model.Sport;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pico on 05/10/2016.
 */

public abstract class SportManager {

    private ArrayList<Sport> listSport = new ArrayList<Sport>();

    public SportManager(){
        apiSetAllSport();
        Log.d("Test", "fin sport");
    }

    //region API
    public void apiSetAllSport() {
        ArrayList<Sport> listSport;// = new ArrayList<Sport>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<ArrayList<Sport>> call = apiService.getAllSport();
        call.enqueue(new Callback<ArrayList<Sport>>(){
            @Override
            public void onResponse(Call<ArrayList<Sport>> call, Response<ArrayList<Sport>> response) {
                int statusCode = response.code();
                ArrayList<Sport> sports = response.body();
                Log.d("response", response.body().toString());
                Log.d("test,", sports.toString());
                setAllSport(sports, statusCode);
                onFinish();
            }

            @Override
            public void onFailure(Call<ArrayList<Sport>> call, Throwable throwable) {
                setAllSport(new ArrayList<Sport>(), 0);

            }


        });
    }
    //endregion

    public void setAllSport(ArrayList<Sport> list, int statusCode){
        listSport = list;
        Log.d("Test", list.toString());
    }

    public ArrayList<Sport> getListSport() {
        return listSport;
    }

    public abstract void onFinish();




}
