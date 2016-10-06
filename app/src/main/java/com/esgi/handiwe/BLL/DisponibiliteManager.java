package com.esgi.handiwe.BLL;

import com.esgi.handiwe.DAL.ApiService;
import com.esgi.handiwe.Model.Conversation;
import com.esgi.handiwe.Model.Disponibilite;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pico on 05/10/2016.
 */

public class DisponibiliteManager {

    private ArrayList<Disponibilite> listDisponibilite= new ArrayList<Disponibilite>();

    public DisponibiliteManager(int id_user){
        apiSetAllDispoByUser(id_user);

    }

    //region API

    public void apiSetAllDispoByUser(int id) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<ArrayList<Disponibilite>> call = apiService.getListDisponibilite(id);
        call.enqueue(new Callback<ArrayList<Disponibilite>>(){
            @Override
            public void onResponse(Call<ArrayList<Disponibilite>> call, Response<ArrayList<Disponibilite>> response) {
                int statusCode = response.code();
                ArrayList<Disponibilite> dispos = response.body();
                setAllDisponibilite(dispos, statusCode);
            }

            @Override
            public void onFailure(Call<ArrayList<Disponibilite>> call, Throwable throwable) {
                setAllDisponibilite(new ArrayList<Disponibilite>(), 0);
            }


        });
    }

    //endregion

    public void setAllDisponibilite(ArrayList<Disponibilite> list, int statusCode){
        listDisponibilite = list;
    }

    public ArrayList<Disponibilite> getListDisponibilite() {
        return listDisponibilite;
    }

}
