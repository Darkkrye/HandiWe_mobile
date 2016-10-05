package com.esgi.handiwe.Model;

/**
 * Created by Pico on 05/10/2016.
 */

public class Conversation {

    private int _id;
    private int _idUtilisateur1;
    private int _idUtilisateur2;

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
