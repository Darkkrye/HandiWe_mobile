package com.esgi.handiwe.Model;

/**
 * Created by Pico on 05/10/2016.
 */

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Message {

    @SerializedName("idMESSAGE")
    private int     _id;
    @SerializedName("")
    private int     _idConversation;
    @SerializedName("message")
    private String  _contenu;
    @SerializedName("sendDate")
    private Date    _sendDate;
    @SerializedName("FromCreator")
    private boolean _fromCreator;


    public Message() { }

    public Message(int conversation, String contenu) {
        set_idConversation(conversation);
        set_contenu(contenu);
    }

    public Message(int _id, int _idConversation, String _contenu) {
        this._id = _id;
        this._idConversation = _idConversation;
        this._contenu = _contenu;
    }

    //region GETTER

    public int get_id() {
        return _id;
    }

    public int get_idConversation() {
        return _idConversation;
    }

    public String get_contenu() {
        return _contenu;
    }

    public Date get_sendDate() {
        return _sendDate;
    }

    public boolean is_fromCreator() {
        return _fromCreator;
    }

    //endregion

    //region SETTER

    public void set_id(int id) {
        this._id = id;
    }

    public void set_idConversation(int idConversation) {
        this._idConversation = idConversation;
    }

    public void set_contenu(String contenu) {
        this._contenu = contenu;
    }

    public void set_sendDate(Date _sendDate) {
        this._sendDate = _sendDate;
    }

    public void set_fromCreator(boolean _fromCreator) {
        this._fromCreator = _fromCreator;
    }

    //endregion
}
