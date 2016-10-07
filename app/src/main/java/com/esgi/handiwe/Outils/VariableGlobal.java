package com.esgi.handiwe.Outils;

import android.app.Application;

import com.esgi.handiwe.BLL.ConversationMessageManager;
import com.esgi.handiwe.BLL.DisponibiliteHeureManager;
import com.esgi.handiwe.BLL.UtilisateurSportManager;

/**
 * Created by Asif on 07/10/2016.
 */

public class VariableGlobal extends Application {

    UtilisateurSportManager utilisateurSportManager = null;
    ConversationMessageManager conversationMessageManager = null;
    DisponibiliteHeureManager disponibiliteHeureManager = null;


    public UtilisateurSportManager getUtilisateurSportManager() {

        if (utilisateurSportManager == null) {
            utilisateurSportManager = new UtilisateurSportManager();
        }

        return utilisateurSportManager;
    }

    public void setUtilisateurSportManager(UtilisateurSportManager utilisateurSportManager) {
        this.utilisateurSportManager = utilisateurSportManager;
    }

    public ConversationMessageManager getConversationMessageManager() {

        if (conversationMessageManager == null) {
            conversationMessageManager = new ConversationMessageManager();
        }
        return conversationMessageManager;
    }

    public void setConversationMessageManager(ConversationMessageManager conversationMessageManager) {
        this.conversationMessageManager = conversationMessageManager;
    }

     public DisponibiliteHeureManager getDisponibiliteHeureManager() {

        if (disponibiliteHeureManager == null) {
            disponibiliteHeureManager = new DisponibiliteHeureManager();
        }
        return disponibiliteHeureManager;
    }

    public void setDisponibiliteHeureManager(DisponibiliteHeureManager disponibiliteHeureManager) {
        this.disponibiliteHeureManager = disponibiliteHeureManager;
    }



}