package com.esgi.handiwe.Model;

/**
 * Created by Pico on 05/10/2016.
 */


import com.google.gson.annotations.SerializedName;


public class Disponibilite {

    @SerializedName("idAVAILABILITY")
    private int     _id;

    @SerializedName("idUSER")
    private int     _idUtilisateur;

    @SerializedName("idSPORT")
    private int     _idSport;

    //@SerializedName("")
    private Jours   _jours;

    public Disponibilite(int _id, int _idUtilisateur, int _idSport, Jours _jours) {
        this._id = _id;
        this._idUtilisateur = _idUtilisateur;
        this._idSport = _idSport;
        this._jours = _jours;
    }

    //region GETTER

    public int get_id() {
        return _id;
    }

    public int get_idUtilisateur() {
        return _idUtilisateur;
    }

    public int get__idSport() {
        return _idSport;
    }

    public Jours get_jours() {
        return _jours;
    }


    //endregion

    //region SETTER

    public void set_id(int id) {
        this._id = id;
    }


    public void set_idSport(int idSport) {
        this._id = idSport;
    }

    public void set_idUtilisateur(int idUtilisateurs) {
        this._idUtilisateur = idUtilisateurs;
    }

    public void set_jours(Jours jours) {
        this._jours = jours;
    }


    //endregion
}
