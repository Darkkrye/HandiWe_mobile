package com.esgi.handiwe.Model;

/**
 * Created by Pico on 05/10/2016.
 */

import com.google.gson.annotations.SerializedName;

public class Message {

    private int     _id;
    private int     _idConversation;
    private String  _contenu;

    public Message() { }

    public Message(int conversation, String contenu) {
        set_idConversation(conversation);
        set_contenu(contenu);
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


    //endregion
}
