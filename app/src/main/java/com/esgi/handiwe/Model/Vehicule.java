package com.esgi.handiwe.Model;

/**
 * Created by nico on 06/10/2016.
 */

import com.google.gson.annotations.SerializedName;

public class Vehicule {

    @SerializedName("idCARS")
    private int _id;

    @SerializedName("marque")
    private String _marque;

    @SerializedName("modele")
    private String _modele;

    @SerializedName("annee")
    private int _annee;

    @SerializedName("seat")
    private int _fauteuil;

    @SerializedName("wheelchairSeat")
    private int _place;

    @SerializedName("image")
    private String _photos;

    @SerializedName("county")
    private String _departement;

    @SerializedName("city")
    private String _ville;

    @SerializedName("priceDay")
    private int _prix;

    @SerializedName("ownerName")
    private String  _prorpietaire;

    @SerializedName("ramp")
    private String  _rampe;

    @SerializedName("isReserved")
    private boolean   isReserve;

    public Vehicule() {}

    public Vehicule(String _marque, String _modele, int _annee, int _fauteuil, int _place, String _departement, int _prix) {
        this._marque = _marque;
        this._modele = _modele;
        this._annee = _annee;
        this._fauteuil = _fauteuil;
        this._place = _place;
        this._departement = _departement;
        this._prix = _prix;
    }

    public Vehicule(int _id, String _marque, String _modele, int _annee, int _fauteuil, int _place, String _photos, String _departement, String _ville, int _prix, String _prorpietaire, String _rampe, boolean isReserve) {

        this._id = _id;
        this._marque = _marque;
        this._modele = _modele;
        this._annee = _annee;
        this._fauteuil = _fauteuil;
        this._place = _place;
        this._photos = _photos;
        this._departement = _departement;
        this._ville = _ville;
        this._prix = _prix;
        this._prorpietaire = _prorpietaire;
        this._rampe = _rampe;
        this.isReserve = isReserve;
    }

    //region GETTER

    public int get_id() {
        return _id;
    }

    public String get_marque() {
        return _marque;
    }

    public String get_modele() {
        return _modele;
    }

    public int get_annee() {
        return _annee;
    }

    public int get_fauteuil() {
        return _fauteuil;
    }

    public String get_photos() {
        return _photos;
    }

    public String get_departement() {
        return _departement;
    }

    public int get_prix() {
        return _prix;
    }

    public int get_place() {
        return _place;
    }

    public String get_ville() {
        return _ville;
    }

    public String get_prorpietaire() {
        return _prorpietaire;
    }

    public String get_rampe() {
        return _rampe;
    }

    public boolean isReserve() {
        return isReserve;
    }

    //endregion

    //region SETTER

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_marque(String _marque) {
        this._marque = _marque;
    }

    public void set_modele(String _modele) {
        this._modele = _modele;
    }

    public void set_annee(int _annee) {
        this._annee = _annee;
    }

    public void set_fauteuil(int _fauteuil) {
        this._fauteuil = _fauteuil;
    }

    public void set_photos(String _photos) {
        this._photos = _photos;
    }

    public void set_departement(String _departement) {
        this._departement = _departement;
    }

    public void set_prix(int _prix) {
        this._prix = _prix;
    }

    public void set_place(int _place) {
        this._place = _place;
    }

    public void set_ville(String _ville) {
        this._ville = _ville;
    }

    public void set_prorpietaire(String _prorpietaire) {
        this._prorpietaire = _prorpietaire;
    }

    public void set_rampe(String _rampe) {
        this._rampe = _rampe;
    }

    public void setReserve(boolean reserve) {
        isReserve = reserve;
    }

    //endregion


}
