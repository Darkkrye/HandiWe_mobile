package com.esgi.handiwe.Model;

/**
 * Created by Pico on 06/10/2016.
 */

public class Vehicule {

    private int _id;
    private String _marque;
    private String _modele;
    private int _annee;
    private int _fauteuil;

    private String _photos;
    private String _departement;
    private float   _prix;

    public Vehicule() {
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

    public float get_prix() {
        return _prix;
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

    public void set_prix(float _prix) {
        this._prix = _prix;
    }


    //endregion


}
