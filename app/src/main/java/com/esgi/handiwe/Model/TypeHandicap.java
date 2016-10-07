package com.esgi.handiwe.Model;

/**
 * Created by Pico on 05/10/2016.
 */

import com.google.gson.annotations.SerializedName;

public class TypeHandicap {

    @SerializedName("idHANDICAP")
    private int     _id;
    @SerializedName("name")
    private String  _libelle;
    @SerializedName("type")
    private String _type;

    public TypeHandicap(){}

    public TypeHandicap(int _id, String _libelle, String _type) {
        this._id = _id;
        this._libelle = _libelle;
        this._type = _type;
    }

    //region GETTER

    public int get_id() {
        return _id;
    }

    public String get_libelle() {
        return _libelle;
    }

    public String get_type() {
        return _type;
    }

    //endregion

    //region SETTER

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_libelle(String _libelle) {
        this._libelle = _libelle;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    //endregion
}
