package com.esgi.handiwe.Model;

/**
 * Created by Pico on 05/10/2016.
 */

import com.google.gson.annotations.SerializedName;

public class Lieux {

    private int _id;
    private String  _nom;
    private String  _type;
    private String  _adresse;
    private String  _codePostal;
    private String  _ville;
    private String  _mail;
    private String  _telephone;
    private String  _responsable;
    private boolean hasMateriel;
    private boolean hasFreeAccess;




    //region GETTER

    public int get_id() {
        return _id;
    }

    public String get_nom() {
        return _nom;
    }

    public String get_type() {
        return _type;
    }

    public String get_adresse() {
        return _adresse;
    }

    public String get_codePostal() {
        return _codePostal;
    }

    public String get_ville() {
        return _ville;
    }

    public String get_mail() {
        return _mail;
    }

    public String get_telephone() {
        return _telephone;
    }

    public String get_responsable() {
        return _responsable;
    }

    public boolean isHasMateriel() {
        return hasMateriel;
    }

    public boolean isHasFreeAccess() {
        return hasFreeAccess;
    }


    //endregion

    //region SETTER

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_nom(String _nom) {
        this._nom = _nom;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public void set_adresse(String _adresse) {
        this._adresse = _adresse;
    }

    public void set_codePostal(String _codePostal) {
        this._codePostal = _codePostal;
    }

    public void set_ville(String _ville) {
        this._ville = _ville;
    }

    public void set_mail(String _mail) {
        this._mail = _mail;
    }

    public void set_telephone(String _telephone) {
        this._telephone = _telephone;
    }

    public void set_responsable(String _responsable) {
        this._responsable = _responsable;
    }

    public void setHasMateriel(boolean hasMateriel) {
        this.hasMateriel = hasMateriel;
    }

    public void setHasFreeAccess(boolean hasFreeAccess) {
        this.hasFreeAccess = hasFreeAccess;
    }


    //endregion

}
