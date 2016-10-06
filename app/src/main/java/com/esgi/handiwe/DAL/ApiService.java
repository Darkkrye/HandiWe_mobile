package com.esgi.handiwe.DAL;

/**
 * Created by Pico on 06/10/2016.
 */

import com.esgi.handiwe.Model.Conversation;
import com.esgi.handiwe.Model.Disponibilite;
import com.esgi.handiwe.Model.Heure;
import com.esgi.handiwe.Model.HoureDispo;
import com.esgi.handiwe.Model.Lieux;
import com.esgi.handiwe.Model.Message;
import com.esgi.handiwe.Model.Profil;
import com.esgi.handiwe.Model.Sport;
import com.esgi.handiwe.Model.TypeHandicap;
import com.esgi.handiwe.Model.UserSport;
import com.esgi.handiwe.Model.Utilisateur;
import com.esgi.handiwe.Model.Vehicule;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.Call;
import retrofit2.http.Path;



public interface ApiService {


    public static final String ENDPOINT = "https://handiweapi.herokuapp.com";

    @GET("/users")
    Call<ArrayList<Utilisateur>> listUtilisateur();

    @GET("/users/{id}")
    Call<Utilisateur> getUtilisateurById(@Path("id") int id);

    @GET("/users/mail/{mail}/{password}")
    Call<Utilisateur> getUtilisateurByMailPassword(
            @Path("mail") String mail, @Path("password") String password );

    @GET("/cars")
    Call<ArrayList<Vehicule>> listVehicule();

    @GET("/handicaps")
    Call<ArrayList<TypeHandicap>> listHandicap();

    @PUT("/cars/reserve/{id}")
    void setVehiculeReserve(@Path("id") int id);


    @GET("/places")
    Call<ArrayList<Lieux>> listLieux();

    @GET("/places/{id}")
    Call<Utilisateur> getLieuxById(@Path("id") int id);

    @GET("/places/name/{name}")
    Call<ArrayList<Lieux>> getLieuxByName(@Path("name") String name);

    @GET("/conversations/{idUser}")
    Call<ArrayList<Conversation>> getConversationById(@Path("idUser") int id);

    @GET("/messages/{idUserA}/{idUserB}")
    Call<ArrayList<Message>> getMessageByBothUser(@Path("idUserA") String idA,@Path("idUserB") String idB);

    @GET("/sports")
    Call<ArrayList<Sport>> getAllSport();

    @GET("/users/by/sport")
    Call<ArrayList<UserSport>> getListUserBySport();

    @GET("/organize/{idUser}")
     Call<ArrayList<Disponibilite>> getListDisponibilite(@Path("idUser") int idUser);

    @GET("/hours/from/{idAvailability}")
    Call<ArrayList<HoureDispo>> getListHourDispo(@Path("idAvailability") int idConversation);

    @GET("/hours/{idHour}")
    Call<ArrayList<Heure>> getListHour(@Path("idHour") int idHeure);



    /**
     *
     *
     * sports - GET
     /sports/:id - GET
     /sports/name/:name - GET


     */







}
