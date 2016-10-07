package com.esgi.handiwe.BLL;

import com.esgi.handiwe.DAL.ApiService;
import com.esgi.handiwe.Model.Conversation;
import com.esgi.handiwe.Model.TypeHandicap;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pico on 05/10/2016.
 */

public class TypeHandicapManager {

    private ArrayList<TypeHandicap> listHandicaps;

    //region API
    public void apiSetAllTypeHandicap() {
        ArrayList<TypeHandicap> listTypeHandicap = new ArrayList<TypeHandicap>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<ArrayList<TypeHandicap>> call = apiService.listHandicap();
        call.enqueue(new Callback<ArrayList<TypeHandicap>>(){
            @Override
            public void onResponse(Call<ArrayList<TypeHandicap>> call, Response<ArrayList<TypeHandicap>> response) {
                int statusCode = response.code();
                ArrayList<TypeHandicap> handicaps = response.body();
                setAllHandicaps(handicaps, statusCode);
            }

            @Override
            public void onFailure(Call<ArrayList<TypeHandicap>> call, Throwable throwable) {
                setAllHandicaps(new ArrayList<TypeHandicap>(), 0);
            }


        });
    }

    //endregion

    public void setAllHandicaps(ArrayList<TypeHandicap> list, int statusCode){
        listHandicaps = list;

        listHandicaps = list;
        boolean exist=false;
        for (TypeHandicap newHandicap:list) {
            for (TypeHandicap item : listHandicaps) {
                if (item.get_id() == newHandicap.get_id()) {
                    exist = true;
                }
            }
            if (!exist) {
                listHandicaps.add(newHandicap);
            }
            exist = false;
        }
    }

    public ArrayList<TypeHandicap> getListHandicaps() {
        return listHandicaps;
    }

    public TypeHandicap getHandicapById(int id){
        TypeHandicap user = new TypeHandicap();
        for (TypeHandicap item:listHandicaps) {
            if (item.get_id() == id) {
                user = item;
            }
        }
        return user;
    }
}
