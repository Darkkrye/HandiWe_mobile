package com.esgi.handiwe.Model;

/**
 * Created by Pico on 05/10/2016.
 */

public class Heure {

    private int _id;
    private int _idDisponibilite;
    private int _heureDebut;
    private int _heureFin;


    //region GETTER

    public int get_id() {
        return _id;
    }

    public int get_idDisponibilite() {
        return _idDisponibilite;
    }

    public int get_heureDebut() {
        return _heureDebut;
    }

    public int get_heureFin() {
        return _heureFin;
    }


    //endregion

    //region SETTER

    public void set_id(int id) {
        this._id = id;
    }

    public void set_idDisponibilite(int idDisponibilite) {
        this._idDisponibilite = idDisponibilite;
    }

    public void set_heureDebut(int heureDebut) {
        this._heureDebut = heureDebut;
    }

    public void set_heureFin(int heureFin) {
        this._heureFin = heureFin;
    }


    //endregion
}
