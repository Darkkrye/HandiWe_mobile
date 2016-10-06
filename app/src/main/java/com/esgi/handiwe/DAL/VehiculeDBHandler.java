package com.esgi.handiwe.DAL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pico on 06/10/2016.
 */

public class VehiculeDBHandler extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "database.db";
    private static final String DATABASE_TABLE = "VEHICULE";

    private static final String KEY_ID = "ID_VEHICULE";
    private static final String KEY_MARQUE = "MARQUE";
    private static final String KEY_MODELE = "MODELE";
    private static final String KEY_ANNEE = "ANNEE";
    private static final String KEY_FAUTEUIL = "FAUTEUIL";
    private static final String KEY_PLACE = "PLACE";
    private static final String KEY_PHOTO = "PHOTO";
    private static final String KEY_DEPARTEMENT = "DEPARTEMENT";
    private static final String KEY_VILLE = "VILLE";
    private static final String KEY_PRIX = "PRIX";

    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +DATABASE_TABLE+" ("
            + KEY_ID+" INTEGER PRIMARY KEY, "
            + KEY_MARQUE +" TEXT, "
            + KEY_MODELE  +" TEXT, "
            + KEY_ANNEE  +" INTEGER, "
            + KEY_FAUTEUIL +" INTEGER, "
            + KEY_PLACE  +" INTEGER, "
            + KEY_PHOTO  +" TEXT, "
            + KEY_DEPARTEMENT +" TEXT, "
            + KEY_VILLE +" BOOLEAN, "
            + KEY_PRIX+" REAL) ";


    public VehiculeDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public String getDatabaseName() {
        return DATABASE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        DATABASE_VERSION = newVersion;
        onCreate(sqLiteDatabase);
    }

}
