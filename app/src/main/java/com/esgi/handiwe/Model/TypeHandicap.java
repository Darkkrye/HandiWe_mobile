package com.esgi.handiwe.Model;

/**
 * Created by Pico on 05/10/2016.
 */

import com.google.gson.annotations.SerializedName;

public class TypeHandicap {

    private int     _id;
    private String  _libelle;




    //region GETTER

    public int get_id() {
        return _id;
    }

    public String get_libelle() {
        return _libelle;
    }


    //endregion

    //region SETTER

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_libelle(String _libelle) {
        this._libelle = _libelle;
    }


    //endregion
}
