package com.esgi.handiwe.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.esgi.handiwe.BLL.UtilisateurManager;
import com.esgi.handiwe.BLL.UtilisateurSportManager;
import com.esgi.handiwe.Model.Utilisateur;
import com.esgi.handiwe.Outils.VariableGlobal;
import com.esgi.handiwe.R;

public class ConnexionActivity extends AppCompatActivity implements View.OnClickListener {

    EditText emailET, motPasseET;
    ImageButton connexionIB, inscriptionIB;
    String email, mdp;
    VariableGlobal variableGlobal;
    UtilisateurSportManager utilisateurSportManager;
    Utilisateur utilisateur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        variableGlobal = (VariableGlobal) getApplicationContext();
        utilisateurSportManager = variableGlobal.getUtilisateurSportManager();

        emailET = (EditText) findViewById(R.id.editTextEmail);
        motPasseET = (EditText) findViewById(R.id.editTextMotPasse);

        connexionIB = (ImageButton) findViewById(R.id.imageButtonConnexion);
        inscriptionIB = (ImageButton) findViewById(R.id.imageButtonInscription);

        connexionIB.setOnClickListener(this);
        inscriptionIB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == connexionIB) {
            checkConnexion();
        } else if (v == inscriptionIB) {

        }
    }

    private void checkConnexion() {
        email = emailET.getText().toString();
        mdp = motPasseET.getText().toString();
        utilisateur = utilisateurSportManager.getUtilisateurByMailPassword(email, mdp);

        if (utilisateur != null) {
            Toast.makeText(this, "Connexion reussi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ListePersonneActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Connexion failed", Toast.LENGTH_SHORT).show();
        }
    }
}
