package com.esgi.handiwe.View;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

import com.esgi.handiwe.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ListePersonneActivity extends AppCompatActivity implements OnItemSelectedListener, View.OnClickListener {

    private Spinner spinner;
    private EditText villeET;
    private TextView dateTV;
    private CheckBox matinCH, apresMidiCH;
    ImageButton imageButtonCal, imageButtonSearch;
    static final int DATE_PICKER_ID = 1111;
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_personne);

        setSpinner();

        villeET = (EditText)findViewById(R.id.editTextVille);
        dateTV = (TextView)findViewById(R.id.textViewDate);
        matinCH = (CheckBox)findViewById(R.id.checkBoxMatin);
        apresMidiCH = (CheckBox)findViewById(R.id.checkBoxApreMidi);

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
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");

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
