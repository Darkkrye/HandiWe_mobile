package com.esgi.handiwe.Model;

/**
 * Created by Pico on 05/10/2016.
 */

public class Sport {

    private int     _id;
    private String  _nom;



    //region GETTER

    public int get_id() {
        return _id;
    }

    public String get_nom() {
        return _nom;
    }


    //endregion

    //region SETTER

    public void set_id(int id) {
        this._id = id;
    }

    public void set_nom(String nom) {
        this._nom = nom;
    }


    //endregion
}
