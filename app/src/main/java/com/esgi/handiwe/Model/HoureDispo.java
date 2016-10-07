package com.esgi.handiwe.Model;

/**
 * Created by Pico on 06/10/2016.
 */

import com.google.gson.annotations.SerializedName;


public class HoureDispo {

    @SerializedName("idHOUR")
    private int _idHeure;
    @SerializedName("idAVAILABILITY")
    private int _idDisponibilite;

    public HoureDispo() {
        this._idHeure = _idHeure;
    }

    public int get_idHeure() {
        return _idHeure;
    }

    public void set_idHeure(int _idHeure) {
        this._idHeure = _idHeure;
    }

    public int get_idDisponibilite() {
        return _idDisponibilite;
    }

    public void set_idDisponibilite(int _idDisponibilite) {
        this._idDisponibilite = _idDisponibilite;
    }
}
