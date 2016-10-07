package com.esgi.handiwe.Model;

/**
 * Created by Pico on 05/10/2016.
 */

import com.google.gson.annotations.SerializedName;

public class Lieux {

    @SerializedName("idPLACE")
    private int _id;
    @SerializedName("name")
    private String  _nom;
    @SerializedName("type")
    private String  _type;
    @SerializedName("address")
    private String  _adresse;
    @SerializedName("zipCode")
    private String  _codePostal;
    @SerializedName("city")
    private String  _ville;
    @SerializedName("mail")
    private String  _mail;
    @SerializedName("telephone")
    private String  _telephone;
    @SerializedName("accountantName")
    private String  _responsable;
    @SerializedName("hasMaterial")
    private boolean hasMateriel;
    @SerializedName("hasFreeAccess")
    private boolean hasFreeAccess;

    public Lieux(){}

    public Lieux(int _id, String _nom, String _type, String _adresse, String _codePostal, String _ville, String _mail, String _telephone, String _responsable, boolean hasMateriel, boolean hasFreeAccess) {
        this._id = _id;
        this._nom = _nom;
        this._type = _type;
        this._adresse = _adresse;
        this._codePostal = _codePostal;
        this._ville = _ville;
        this._mail = _mail;
        this._telephone = _telephone;
        this._responsable = _responsable;
        this.hasMateriel = hasMateriel;
        this.hasFreeAccess = hasFreeAccess;
    }


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
