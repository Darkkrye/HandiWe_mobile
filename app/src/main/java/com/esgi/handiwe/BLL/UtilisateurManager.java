package com.esgi.handiwe.BLL;

import android.util.Log;

import com.esgi.handiwe.DAL.ApiService;
import com.esgi.handiwe.Model.Utilisateur;
import com.esgi.handiwe.View.ConnexionActivity;

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

    public UtilisateurManager(){
        apiGetAllUtilisateur();
    }
    public UtilisateurManager(String mail, String mdp){
        apiGetAllUtiligetUtilisateurByMailPassword(mail, mdp);
    }


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

    public void apiGetAllUtiligetUtilisateurByMailPassword(String mail, String password){
        Utilisateur utilisateur = new Utilisateur();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<Utilisateur> call = apiService.getUtilisateurByMailPassword(mail,password);
        call.enqueue(new Callback<Utilisateur>(){
             @Override
             public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {
                 int statusCode = response.code();
                 Utilisateur utilisateur = response.body();
                 setUtilisateur(utilisateur, statusCode);

                 if(utilisateur != null){
                     ConnexionActivity.testFunction(utilisateur);
                 }
             }

             @Override
             public void onFailure(Call<Utilisateur> call, Throwable throwable) {

             }

    });
    }
    //endregion

    public void setUtilisateur(Utilisateur user, int statusCode){
        if(listUtiliasteur == null) {
            listUtiliasteur = new ArrayList<Utilisateur>();
        }
        listUtiliasteur.add(user);
    }




    public void setAllUtilisateur(ArrayList<Utilisateur> list, int statusCode){
        listUtiliasteur = list;
        boolean exist=false;
        for (Utilisateur newUser:list) {
            for (Utilisateur item : listUtiliasteur) {
                if (item.get_id() == newUser.get_id()) {
                    exist = true;
                }
            }
            if (!exist) {
                listUtiliasteur.add(newUser);
            }
            exist = false;
        }
    }

    public ArrayList<Utilisateur> getListUtiliasteur() {
        return listUtiliasteur;
    }

    public Utilisateur getUtilisateurById(int id){
        Utilisateur user = new Utilisateur();
        for (Utilisateur item:listUtiliasteur) {
            if (item.get_id() == id) {
                user = item;
            }
        }
        return user;
    }

}
