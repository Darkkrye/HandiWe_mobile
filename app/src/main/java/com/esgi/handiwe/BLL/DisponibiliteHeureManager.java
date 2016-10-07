package com.esgi.handiwe.BLL;

import com.esgi.handiwe.DAL.ApiService;
import com.esgi.handiwe.Model.Conversation;
import com.esgi.handiwe.Model.Disponibilite;
import com.esgi.handiwe.Model.Heure;
import com.esgi.handiwe.Model.HoureDispo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pico on 05/10/2016.
 */

public class DisponibiliteHeureManager {

    private ArrayList<Disponibilite> listDisponibilite= new ArrayList<Disponibilite>();
    private ArrayList<Heure> listeHeure= new ArrayList<>();
    private ArrayList<HoureDispo> listeHeureDispo= new ArrayList<>();

    public DisponibiliteHeureManager(int id_user){
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

    public void apiGetListHourDispo(int idDispo){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<ArrayList<HoureDispo>> call = apiService.getListHourDispo(idDispo);
        call.enqueue(new Callback<ArrayList<HoureDispo>>(){
            @Override
            public void onResponse(Call<ArrayList<HoureDispo>> call, Response<ArrayList<HoureDispo>> response) {
                int statusCode = response.code();
                ArrayList<HoureDispo> dispos = response.body();
                setAllHourDispo(dispos);
            }

            @Override
            public void onFailure(Call<ArrayList<HoureDispo>> call, Throwable throwable) {
                setAllHourDispo(new ArrayList<HoureDispo>());
            }
        });
    }

    public void apiGetListHeure(int idHeure, final int idDispo){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<ArrayList<Heure>> call = apiService.getListHour(idHeure);
        call.enqueue(new Callback<ArrayList<Heure>>(){
            @Override
            public void onResponse(Call<ArrayList<Heure>> call, Response<ArrayList<Heure>> response) {
                int statusCode = response.code();
                ArrayList<Heure> heure = response.body();

                setAllHeure(heure, idDispo);
            }

            @Override
            public void onFailure(Call<ArrayList<Heure>> call, Throwable throwable) {
                setAllHeure(new ArrayList<Heure>(),idDispo);
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

    public void setAllHourDispo(ArrayList<HoureDispo>list){
        for (HoureDispo item: list) {
            listeHeureDispo.add(item);
        }



    }

    public void setAllHeure(ArrayList<Heure>list, int idDispo){
        for (Heure item: list) {
            item.set_idDisponibilite(idDispo);
            listeHeure.add(item);
        }



    }
}

