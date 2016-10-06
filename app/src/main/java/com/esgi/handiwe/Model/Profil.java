package com.esgi.handiwe.Model;

/**
 * Created by nico on 06/10/2016.
 */
import java.util.ArrayList;
import java.util.List;

public class Profil {

    private int     _id;
    private int     _idUtilisateur;
    private int     _idSport;
    private int     _idLieu;
    private int     _idTypeHandicap;

    private List<Integer> listDisponibilite;
    private boolean isInClub;
    private String  _nomClub;
    private String  _licence;

    public Profil() {
        this.listDisponibilite = new ArrayList<Integer>();
    }


    //region GETTER

    public int get_id() {
        return _id;
    }

    public int get_idUtilisateur() {
        return _idUtilisateur;
    }

    public int get_idSport() {
        return _idSport;
    }

    public int get_idLieu() {
        return _idLieu;
    }

    public List<Integer> getListDisponibilite() {
        return listDisponibilite;
    }

    public boolean isInClub() {
        return isInClub;
    }

    public String get_nomClub() {
        return _nomClub;
    }

    public String get_licence() {
        return _licence;
    }


    //endregion

    //region SETTER

    public void set_id(int id) {
        this._id = id;
    }

    public void set_idUtilisateur(int idUtilisateur) {
        this._idUtilisateur = idUtilisateur;
    }

    public void set_idSport(int idSport) {
        this._idSport = idSport;
    }

    public void set_idLieu(int idLieu) {
        this._idLieu = idLieu;
    }

    public void setListDisponibilite(List<Integer> listDisponibilite) {
        this.listDisponibilite = listDisponibilite;
    }

    public void setInClub(boolean inClub) {
        isInClub = inClub;
    }

    public void set_nomClub(String nomClub) {
        this._nomClub = nomClub;
    }

    public void set_licence(String licence) {
        this._licence = licence;
    }


    //endregion



}
