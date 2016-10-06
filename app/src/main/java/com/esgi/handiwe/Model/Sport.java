package com.esgi.handiwe.Model;

/**
 * Created by Pico on 05/10/2016.
 */

import com.google.gson.annotations.SerializedName;

public class Sport {

    private int     _id;
    private String  _nom;
    private String  _image;

    public Sport(int _id, String _nom, String _image) {
        this._id = _id;
        this._nom = _nom;
        this._image = _image;
    }

//region GETTER

    public int get_id() {
        return _id;
    }

    public String get_nom() {
        return _nom;
    }

    public String get_image() {
        return _image;
    }

    //endregion

    //region SETTER

    public void set_id(int id) {
        this._id = id;
    }

    public void set_nom(String nom) {
        this._nom = nom;
    }

    public void set_image(String _image) {
        this._image = _image;
    }


    //endregion
}
