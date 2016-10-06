package com.esgi.handiwe.Model;

/**
 * Created by Pico on 06/10/2016.
 */
import com.google.gson.annotations.SerializedName;

public class UserSport {

    @SerializedName("idUSER")
    private int _idUtilisateur;

    @SerializedName("idFAVORITE")
    private int _idSport;

    //region GETTER

    public int get_idUtilisateur() {
        return _idUtilisateur;
    }

    public int get_idSport() {
        return _idSport;
    }


    //endregion


    //region SETTER

    public void set_idUtilisateur(int _idUtilisateur) {
        this._idUtilisateur = _idUtilisateur;
    }

    public void set_idSport(int _idSport) {
        this._idSport = _idSport;
    }


    //endregion

}
