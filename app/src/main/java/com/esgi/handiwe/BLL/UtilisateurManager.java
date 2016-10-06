package com.esgi.handiwe.BLL;

import com.esgi.handiwe.DAL.ApiService;
import com.esgi.handiwe.Model.Utilisateur;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Pico on 05/10/2016.
 */

public class UtilisateurManager {

    private ArrayList<Utilisateur> listUtiliasteur;

    //region API
    public void apiGetAllUtilisateur() {
        ArrayList<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<ArrayList<Utilisateur>> call = apiService.listUtilisateur();
        call.enqueue(new Callback<ArrayList<Utilisateur>>(){
            @Override
            public void onResponse(Call<ArrayList<Utilisateur>> call, Response<ArrayList<Utilisateur>> response) {
                int statusCode = response.code();
                ArrayList<Utilisateur> utilisateurs = response.body();
                setAllUtilisateur(utilisateurs, statusCode);
            }

            @Override
            public void onFailure(Call<ArrayList<Utilisateur>> call, Throwable throwable) {
                setAllUtilisateur(new ArrayList<Utilisateur>(), 0);
            }


        });
    }

    //endregion

    public void setAllUtilisateur(ArrayList<Utilisateur> list, int statusCode){
        listUtiliasteur = list;
    }

    public ArrayList<Utilisateur> getListUtiliasteur() {
        return listUtiliasteur;
    }
}
