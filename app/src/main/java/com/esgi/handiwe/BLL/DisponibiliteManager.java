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

    private ArrayList<Disponibilite> listDisponibilite;

    //region API


    //endregion

    public void setAllDisponibilite(ArrayList<Disponibilite> list, int statusCode){
        listDisponibilite = list;
    }

    public ArrayList<Disponibilite> getListDisponibilite() {
        return listDisponibilite;
    }

}
