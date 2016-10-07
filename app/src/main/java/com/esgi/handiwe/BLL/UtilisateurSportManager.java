package com.esgi.handiwe.BLL;

import android.util.Log;

import com.esgi.handiwe.DAL.ApiService;
import com.esgi.handiwe.Model.Sport;
import com.esgi.handiwe.Model.UserSport;
import com.esgi.handiwe.Model.Utilisateur;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Pico on 05/10/2016.
 */

public class UtilisateurSportManager {

    private ArrayList<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();
    private ArrayList<UserSport> listUserSport = new ArrayList<UserSport>();
    private ArrayList<Sport> listSport = new ArrayList<Sport>();

    public UtilisateurSportManager(){
        apiGetAllSport();
        apiGetUtilisateurBySport();
        apiGetAllUtilisateur();
    }


    public UtilisateurSportManager(String mail, String mdp){
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
                Log.d("test", "test entre");
                Log.d("response", response.body().toString());
                int statusCode = response.code();
                ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
                utilisateurs = response.body();
                Log.d("response 2", utilisateurs.toString());
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
             }

             @Override
             public void onFailure(Call<Utilisateur> call, Throwable throwable) {

             }

    });
    }

    public void apiGetUtilisateurBySport() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<ArrayList<UserSport>> call = apiService.getListUserBySport();
        call.enqueue(new Callback<ArrayList<UserSport>>(){
            @Override
            public void onResponse(Call<ArrayList<UserSport>> call, Response<ArrayList<UserSport>> response) {
                int statusCode = response.code();

                ArrayList<UserSport>  userSport = response.body();
                Log.d("response 2", response.body().toString());
                setUserSport(userSport, statusCode);
            }

            @Override
            public void onFailure(Call<ArrayList<UserSport>> call, Throwable t) {

            }
        });
    }

    public void apiGetAllSport() {
        ArrayList<Sport> listSport = new ArrayList<Sport>();

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
                setAllSport(sports, statusCode);
            }

            @Override
            public void onFailure(Call<ArrayList<Sport>> call, Throwable throwable) {
                setAllSport(new ArrayList<Sport>(), 0);
            }


        });
    }
    //endregion

    public void setUtilisateur(Utilisateur user, int statusCode){
        if(listUtilisateur == null) {
            listUtilisateur = new ArrayList<Utilisateur>();
        }
        listUtilisateur.add(user);
    }

    public void setUserSport(ArrayList<UserSport> usersport, int statusCode){
        if(listUserSport == null) {
            listUserSport = new ArrayList<UserSport>();
        }
        listUserSport = usersport;
    }

    public void setAllUtilisateur(ArrayList<Utilisateur> list, int statusCode){
        listUtilisateur = list;
        Log.d("setter", listUtilisateur.get(1).get_nom());
    }

    public ArrayList<Utilisateur> getListUtilisateur() {
        return listUtilisateur;
    }

    public Utilisateur getUtilisateurById(int id){
        Utilisateur user = new Utilisateur();
        for (Utilisateur item:listUtilisateur) {
            if (item.get_id() == id) {
                user = item;
            }
        }
        return user;
    }

    public Utilisateur getUtilisateurByMailPassword(String mail, String password){
        Utilisateur user = null;
        for (Utilisateur item:listUtilisateur) {
            if (item.get_mail().equals(mail) && item.get_moteDePasse().equals(password)) {
                user = item;
            }
        }
        return user;
    }

    public void setAllSport(ArrayList<Sport> list, int statusCode){
        listSport = list;
    }

    public ArrayList<Sport> getListSport() {
        return listSport;
    }

    public ArrayList<Utilisateur> getUtilisateurBySport(int idSport){

        ArrayList<Integer> user = new ArrayList<>();
        for (UserSport item: listUserSport) {
            if (item.get_idSport() == idSport) {
                user.add(item.get_idUtilisateur());
            }
        }

        ArrayList<Utilisateur> userFinal = new ArrayList<>();
        for (Integer item: user){
            userFinal.add(getUtilisateurById(item));
        }
        return  userFinal;
    }
}
