package com.esgi.handiwe.Model;

/**
 * Created by Pico on 05/10/2016.
 */

public class Disponibilite {

    private int     _id;
    private int     _idUtilisateur;
    private int     _idSport;
    private Jours   _jours;



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
