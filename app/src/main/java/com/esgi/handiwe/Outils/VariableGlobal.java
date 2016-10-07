package com.esgi.handiwe.Outils;

import android.app.Application;

import com.esgi.handiwe.BLL.UtilisateurSportManager;

/**
 * Created by Asif on 07/10/2016.
 */

public class VariableGlobal extends Application {

    UtilisateurSportManager utilisateurSportManager = null;

    public UtilisateurSportManager getUtilisateurSportManager() {

        if(utilisateurSportManager == null){
            utilisateurSportManager = new UtilisateurSportManager();
        }

        return utilisateurSportManager;
    }

    public void setUtilisateurSportManager(UtilisateurSportManager utilisateurSportManager) {
        this.utilisateurSportManager = utilisateurSportManager;
    }
}
