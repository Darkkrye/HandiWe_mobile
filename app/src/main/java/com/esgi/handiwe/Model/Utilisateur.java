package com.esgi.handiwe.Model;

import java.util.Date;

/**
 * Created by Pico on 05/10/2016.
 */

import com.google.gson.annotations.SerializedName;

public class Utilisateur {

    @SerializedName("idUSER")
    private int     _id;

    @SerializedName("lastName")
    private String  _nom;

    @SerializedName("firstName")
    private String  _prenom;

    @SerializedName("birthdayDate")
    private Date    _naissance;

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

    @SerializedName("")
    private String  _moteDePasse;

    @SerializedName("")
    private String  _image;

    @SerializedName("")
    private boolean isPrivate;


    public Utilisateur(){}

    public Utilisateur(Date naissance,  String mail, String moteDePasse) {
        set_naissance(naissance);
        set_mail(mail);
        set_moteDePasse(moteDePasse);
    }

    public Utilisateur(int _id, String _nom, String _prenom, Date _naissance, String _adresse, String _codePostal, String _ville, String _mail, String _telephone, String _moteDePasse, String _image, boolean isPrivate) {
        this._id = _id;
        this._nom = _nom;
        this._prenom = _prenom;
        this._naissance = _naissance;
        this._adresse = _adresse;
        this._codePostal = _codePostal;
        this._ville = _ville;
        this._mail = _mail;
        this._telephone = _telephone;
        this._moteDePasse = _moteDePasse;
        this._image = _image;
        this.isPrivate = isPrivate;
    }

    //region GETTER

    public int get_id() {
        return _id;
    }

    public String get_nom() {
        return _nom;
    }

    public String get_prenom() {
        return _prenom;
    }

    public Date get_naissance() {
        return _naissance;
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

    public String get_moteDePasse() {
        return _moteDePasse;
    }


    public String get_image() {
        return _image;
    }

    public boolean isPrivate() {
        return isPrivate;
    }


    //endregion

    //ajouter verif mail/tel/cp/mdp
    //region SETTER

    public void set_id(int id) {
        this._id = id;
    }

    public void set_nom(String nom) {
        this._nom = nom;
    }

    public void set_prenom(String prenom) {
        this._prenom = prenom;
    }

    public void set_naissance(Date naissance) {
        this._naissance = naissance;
    }

    public void set_adresse(String adresse) {
        this._adresse = adresse;
    }

    public void set_codePostal(String codePostal) {
        this._codePostal = codePostal;
    }

    public void set_ville(String ville) {
        this._ville = ville;
    }

    public void set_mail(String mail) {
        this._mail = mail;
    }

    public void set_telephone(String telephone) {
        this._telephone = telephone;
    }

    public void set_moteDePasse(String moteDePasse) {
        this._moteDePasse = moteDePasse;
    }

    public void set_image(String image) {
        this._image = image;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }


    //endregion
}
