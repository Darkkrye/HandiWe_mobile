package com.esgi.handiwe.Model;

/**
 * Created by Pico on 05/10/2016.
 */

import com.google.gson.annotations.SerializedName;

public class Conversation {


    private int _id;
    @SerializedName("idUSERA")
    private int _idUtilisateur1;
    @SerializedName("idUSERB")
    private int _idUtilisateur2;

    public Conversation(int _id, int _idUtilisateur1, int _idUtilisateur2) {
        this._id = _id;
        this._idUtilisateur1 = _idUtilisateur1;
        this._idUtilisateur2 = _idUtilisateur2;
    }

    public Conversation(){}

    //region GETTER

    public int get_id() {
        return _id;
    }

    public int get_idUtilisateur1() {
        return _idUtilisateur1;
    }

    public int get_idUtilisateur2() {
        return _idUtilisateur2;
    }


    //endregion

    //region SETTER

    public void set_id(int id) {
        this._id = id;
    }

    public void set_idUtilisateur1(int idUtilisateur1) {
        this._idUtilisateur1 = idUtilisateur1;
    }

    public void set_idUtilisateur2(int idUtilisateur2) {
        this._idUtilisateur2 = idUtilisateur2;
    }


    //endregion


}
