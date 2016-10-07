package com.esgi.handiwe.Model;

/**
 * Created by Pico on 05/10/2016.
 */

import com.google.gson.annotations.SerializedName;

public class Heure {

    @SerializedName("idHOUR")
    private int _id;
    private int _idDisponibilite;
    @SerializedName("beginningHour")
    private int _heureDebut;
    @SerializedName("endHour")
    private int _heureFin;

    public Heure(int _id, int _idDisponibilite, int _heureDebut, int _heureFin) {
        this._id = _id;
        this._idDisponibilite = _idDisponibilite;
        this._heureDebut = _heureDebut;
        this._heureFin = _heureFin;
    }


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
