package com.esgi.handiwe.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.esgi.handiwe.R;

public class ProfilAffichageActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonModification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_affichage);

        buttonModification = (Button)findViewById(R.id.buttonModifier);
        buttonModification.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ProfilEditionActivity.class);
        startActivity(intent);
    }
}
