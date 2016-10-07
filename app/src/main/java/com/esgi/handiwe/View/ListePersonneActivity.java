package com.esgi.handiwe.View;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

import com.esgi.handiwe.BLL.SportManager;
import com.esgi.handiwe.BLL.UtilisateurSportManager;
import com.esgi.handiwe.Model.Sport;
import com.esgi.handiwe.Model.Utilisateur;
import com.esgi.handiwe.Outils.VariableGlobal;
import com.esgi.handiwe.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ListePersonneActivity extends AppCompatActivity implements OnItemSelectedListener, View.OnClickListener {



    private Spinner spinner;
    private EditText villeET;
    private TextView dateTV;
    private CheckBox matinCH, apresMidiCH;
    private ListView lvUtilisateur;
    ImageButton imageButtonCal, imageButtonSearch;
    static final int DATE_PICKER_ID = 1111;
    private int year;
    private int month;
    private int day;
    private SportManager sport;
    private  VariableGlobal vg;
    private UtilisateurSportManager usm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sport = new SportManager() {
            @Override
            public void onFinish() {
                List<String> categories = new ArrayList<String>();
                Log.d("on finish", sport.toString());
                for (Sport s:sport.getListSport()) {
                    Log.d("sport", s.get_nom());
                    categories.add(s.get_nom());
                }
                setSpinner();
            }
        };
        vg = (VariableGlobal) getApplicationContext();
         usm = vg.getUtilisateurSportManager();
        Log.d("test", sport.getListSport().toString());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_personne);


        villeET = (EditText)findViewById(R.id.editTextVille);
        dateTV = (TextView)findViewById(R.id.textViewDate);
        matinCH = (CheckBox)findViewById(R.id.checkBoxMatin);
        apresMidiCH = (CheckBox)findViewById(R.id.checkBoxApreMidi);
        lvUtilisateur = (ListView)findViewById(R.id.ListView1);

        // init imageButton
        imageButtonCal = (ImageButton) findViewById(R.id.ibCal);
        imageButtonCal.setOnClickListener(this);
        imageButtonSearch = (ImageButton) findViewById(R.id.ibSearch);
        imageButtonSearch.setOnClickListener(this);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // spinner selected item
        String item = parent.getItemAtPosition(position).toString();
    }

    private void setSpinner() {

        // Spinner element
        spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements




        List<String> categories = new ArrayList<String>();
        for (Sport s:sport.getListSport()) {
            categories.add(s.get_nom());
        }


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v == imageButtonCal) {
            showDialog(DATE_PICKER_ID);
        }else if(v == imageButtonSearch){
            String name = (String)spinner.getSelectedItem();
            Sport s = new Sport(0,"", "");
            for (Sport item : sport.getListSport()){
                if(item.get_nom().equals(name)){
                    s= item;
                }
            }
            ArrayList<Utilisateur> listUser = usm.getUtilisateurBySport(s.get_id());
            Log.d("imageButtonSearch", "list "+listUser.toString());
            Utilisateur[] users = new Utilisateur[listUser.size()];
            for(int i = 0; i < listUser.size(); i++)
                users[i] = listUser.get(i);
            lvUtilisateur.setAdapter(new AdapterListePersonne(getApplication(), users));

        }
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

            /*String date = day+"/"+month+"/"+year;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date dateFormat = format.parse(date);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }*/

            // Show selected date
            /*Output.setText(new StringBuilder().append(month + 1)
                    .append("-").append(day).append("-").append(year)
                    .append(" "));*/

        }
    };

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
