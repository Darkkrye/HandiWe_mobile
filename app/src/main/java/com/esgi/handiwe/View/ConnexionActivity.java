package com.esgi.handiwe.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;


import com.esgi.handiwe.BLL.UtilisateurSportManager;
import com.esgi.handiwe.Model.Utilisateur;
import com.esgi.handiwe.R;

public class ConnexionActivity extends AppCompatActivity implements View.OnClickListener {

    EditText emailET, motPasseET;
    ImageButton connexionIB, inscriptionIB;
    UtilisateurSportManager utilisateurManager;
    String email, mdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        emailET = (EditText)findViewById(R.id.editTextEmail);
        motPasseET = (EditText)findViewById(R.id.editTextMotPasse);

        connexionIB = (ImageButton)findViewById(R.id.imageButtonConnexion);
        inscriptionIB = (ImageButton)findViewById(R.id.imageButtonInscription);

        connexionIB.setOnClickListener(this);
        inscriptionIB.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == connexionIB){

            email = emailET.getText().toString();
            mdp = motPasseET.getText().toString();

            utilisateurManager = new UtilisateurSportManager(email,mdp);
        }
    }

    public static void testFunction(Utilisateur utilisateur){
        Log.i("retrofit","Utilisateur : "+utilisateur.get_nom() + ", Connexion reussi !");
    }
}
