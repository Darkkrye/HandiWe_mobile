package com.esgi.handiwe.DAL;

/**
 * Created by nico on 06/10/2016.
 */

import com.esgi.handiwe.Model.Conversation;
import com.esgi.handiwe.Model.Disponibilite;
import com.esgi.handiwe.Model.Heure;
import com.esgi.handiwe.Model.Lieux;
import com.esgi.handiwe.Model.Message;
import com.esgi.handiwe.Model.Profil;
import com.esgi.handiwe.Model.Sport;
import com.esgi.handiwe.Model.TypeHandicap;
import com.esgi.handiwe.Model.Utilisateur;
import com.esgi.handiwe.Model.Vehicule;

import java.util.ArrayList;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.Call;
import retrofit2.http.Path;



public interface ApiService {


    public static final String ENDPOINT = "https://handiweapi.herokuapp.com";

    @GET("/users")
    Call<ArrayList<Utilisateur>> listUtilisateur();

    @GET("/conversations")
    Call<ArrayList<Conversation>> listConversation();

    @GET("/disponibilite")
    Call<ArrayList<Disponibilite>> listDisponibilite();

    @GET("/cars")
    Call<ArrayList<Vehicule>> listVehicule();

    @PUT("/cars/reserve/{id}")
    void setVehiculeReserve(@Path("id") int id);






}