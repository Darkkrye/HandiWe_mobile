package com.esgi.handiwe.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.esgi.handiwe.Model.Utilisateur;
import com.esgi.handiwe.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfilEditionActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonValidation;
    // ET = editText
    EditText nomET, prenomET, dateNaissanceET, adresseET, villeET, codePostalET, telephoneET,
            typeHandicapET, nomSportET, freqET, lieuPrefET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_edition);

        buttonValidation = (Button)findViewById(R.id.buttonValider);
        buttonValidation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        modificationUtilisateur();
        finish();
    }

    private void modificationUtilisateur(){
        initEditTexts();
        setUtilisateur(); // update bdd
    }

    private void initEditTexts(){
        nomET = (EditText) findViewById(R.id.editTextNom);
        prenomET = (EditText) findViewById(R.id.editTextPrenom);
        dateNaissanceET = (EditText) findViewById(R.id.editTextDateN);
        adresseET = (EditText) findViewById(R.id.editTextAdresse);
        villeET = (EditText)findViewById(R.id.editTextVille);
        codePostalET = (EditText) findViewById(R.id.editTextCodeP);
        telephoneET = (EditText) findViewById(R.id.editTextTel);
        typeHandicapET = (EditText) findViewById(R.id.editTextTypeH);
        nomSportET = (EditText) findViewById(R.id.editTextNomSport);
        freqET = (EditText) findViewById(R.id.editTextFreq);
        lieuPrefET = (EditText) findViewById(R.id.editTextLieuPref);
    }

    private Utilisateur setUtilisateur(){

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.set_nom(nomET.getText().toString());
        utilisateur.set_prenom(prenomET.getText().toString());
        utilisateur.set_naissance(stringToDate(dateNaissanceET.getText().toString()));
        utilisateur.set_adresse(adresseET.getText().toString());
        utilisateur.set_ville(villeET.getText().toString());
        utilisateur.set_codePostal(codePostalET.getText().toString());
        utilisateur.set_telephone(telephoneET.getText().toString());
        /*utilisateur.set_typeHandicap(typeHandicapET.getText().toString());
        utilisateur.set_nomSport(nomSportET.getText().toString());
        utilisateur.set_freq(freqET.getText().toString());
        utilisateur.set_lieuPref(lieuPrefET.getText().toString());*/

        return utilisateur;
    }

    private Date stringToDate(String date){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dateFormat = format.parse(date);
            return dateFormat;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
