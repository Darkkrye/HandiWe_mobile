package com.esgi.handiwe.View;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.LoginEvent;
import com.esgi.handiwe.BLL.UtilisateurSportManager;
import com.esgi.handiwe.Model.Utilisateur;
import com.esgi.handiwe.Outils.VariableGlobal;
import com.esgi.handiwe.R;

import java.util.Calendar;

import io.fabric.sdk.android.Fabric;

public class ConnexionActivity extends AppCompatActivity implements View.OnClickListener {

    EditText emailET, motPasseET;
    ImageButton connexionIB, inscriptionIB, inscriptionValiderIB, inscriptionAnnulerIB, calIB;
    String email, mdp;
    VariableGlobal variableGlobal;
    UtilisateurSportManager utilisateurSportManager;
    Utilisateur utilisateur;
    LinearLayout linearLayoutInscription, linearLayoutValiderAnnuler, linearLayoutConnexion;

    static final int DATE_PICKER_ID = 1111;
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_connexion);

        variableGlobal = (VariableGlobal) getApplicationContext();
        utilisateurSportManager = variableGlobal.getUtilisateurSportManager();

        emailET = (EditText) findViewById(R.id.editTextEmail);
        motPasseET = (EditText) findViewById(R.id.editTextMotPasse);

        linearLayoutInscription = (LinearLayout) findViewById(R.id.layoutInscription);
        linearLayoutValiderAnnuler = (LinearLayout) findViewById(R.id.layoutValiderAnnuler);
        linearLayoutConnexion = (LinearLayout) findViewById(R.id.layoutConnexion);

        connexionIB = (ImageButton) findViewById(R.id.imageButtonConnexion);
        inscriptionIB = (ImageButton) findViewById(R.id.imageButtonInscription);

        connexionIB.setOnClickListener(this);
        inscriptionIB.setOnClickListener(this);

        inscriptionValiderIB = (ImageButton) findViewById(R.id.imageButtonVal);
        inscriptionAnnulerIB = (ImageButton) findViewById(R.id.imageButtonCancel);

        inscriptionValiderIB.setOnClickListener(this);
        inscriptionAnnulerIB.setOnClickListener(this);

        calIB = (ImageButton)findViewById(R.id.imageButtonCal);
        calIB.setOnClickListener(this);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public void onClick(View v) {

        if (v == connexionIB) {
            checkConnexion();
        } else if (v == inscriptionIB) {
            showInscription();
        } else if (v == inscriptionValiderIB) {
            ajouterUtilisateur();
        } else if (v == inscriptionAnnulerIB) {
            hideInscription();
        } else if(v == calIB){
            showDialog(DATE_PICKER_ID);
        }
    }

    private void checkConnexion() {
        email = emailET.getText().toString();
        mdp = motPasseET.getText().toString();
        utilisateur = utilisateurSportManager.getUtilisateurByMailPassword(email, mdp);

        if (utilisateur != null) {
            Toast.makeText(this, "Connexion reussi", Toast.LENGTH_SHORT).show();
            variableGlobal.setIdUser(utilisateur.get_id());
            Intent intent = new Intent(this, ListePersonneActivity.class);
            startActivity(intent);
            // fabriq.io tracking
            Answers.getInstance().logLogin(new LoginEvent().putCustomAttribute("mail", email).putSuccess(true));
        } else {
            Toast.makeText(this, "Connexion failed", Toast.LENGTH_SHORT).show();

            Answers.getInstance().logLogin(new LoginEvent().putCustomAttribute("mail", email).putSuccess(false));
        }
    }

    private void ajouterUtilisateur(){
        Toast.makeText(this,"Comming soon !",Toast.LENGTH_SHORT).show();
    }

    private void showInscription() {
        linearLayoutInscription.setVisibility(View.VISIBLE);
        linearLayoutValiderAnnuler.setVisibility(View.VISIBLE);
        linearLayoutConnexion.setVisibility(View.INVISIBLE);
    }

    private void hideInscription(){
        linearLayoutInscription.setVisibility(View.INVISIBLE);
        linearLayoutValiderAnnuler.setVisibility(View.INVISIBLE);
        linearLayoutConnexion.setVisibility(View.VISIBLE);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_PICKER_ID:

                return new DatePickerDialog(this, pickerListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        @Override
        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {

            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;
        }
    };
}
