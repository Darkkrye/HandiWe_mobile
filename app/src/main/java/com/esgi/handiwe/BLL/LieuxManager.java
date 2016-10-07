package com.esgi.handiwe.BLL;

import com.esgi.handiwe.DAL.ApiService;
import com.esgi.handiwe.Model.Lieux;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pico on 05/10/2016.
 */

public class LieuxManager {

    private ArrayList<Lieux> listLieux;

    //region API
    public void apiGetAllLieux() {
        ArrayList<Lieux> listlieux = new ArrayList<Lieux>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<ArrayList<Lieux>> call = apiService.listLieux();
        call.enqueue(new Callback<ArrayList<Lieux>>(){
            @Override
            public void onResponse(Call<ArrayList<Lieux>> call, Response<ArrayList<Lieux>> response) {
                int statusCode = response.code();
                ArrayList<Lieux> lieux = response.body();
                setAllLieux(lieux, statusCode);
            }

            @Override
            public void onFailure(Call<ArrayList<Lieux>> call, Throwable throwable) {
                setAllLieux(new ArrayList<Lieux>(), 0);
            }


        });
    }


    //endregion

    public void setAllLieux(ArrayList<Lieux> list, int statusCode){
        listLieux = list;

        boolean exist=false;
        for (Lieux newLieux:list) {
            for (Lieux item : listLieux) {
                if (item.get_id() == newLieux.get_id()) {
                    exist = true;
                }
            }
            if (!exist) {
                listLieux.add(newLieux);
            }
            exist = false;
        }
    }

    public ArrayList<Lieux> getListLieux() {
        return listLieux;
    }


    public Lieux getLieuxById(int id){
        Lieux lieu = new Lieux();
        for (Lieux item:listLieux) {
            if (item.get_id() == id) {
                lieu = item;
            }
        }
        return lieu;
    }

}
