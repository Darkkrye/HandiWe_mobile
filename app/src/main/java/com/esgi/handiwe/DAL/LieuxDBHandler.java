package com.esgi.handiwe.DAL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pico on 06/10/2016.
 */

public class LieuxDBHandler extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "database.db";
    private static final String DATABASE_TABLE = "LIEUX";

    private static final String KEY_ID = "ID_LIEUX";
    private static final String KEY_NOM = "NOM";
    private static final String KEY_TYPE = "TYPE";
    private static final String KEY_ADRESSE = "ADRESSE";
    private static final String KEY_CODE_POSTAL = "CODE_POSTAL";
    private static final String KEY_VILLE = "VILLE";
    private static final String KEY_MAIL = "MAIL";
    private static final String KEY_TELEPHONE = "TELEPHONE";
    private static final String KEY_MATERIEL = "MATERIEL";
    private static final String KEY_ACCES_LIBRE = "ACCES_LIBRE";

    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +DATABASE_TABLE+" ("
            + KEY_ID+" INTEGER PRIMARY KEY, "
            + KEY_NOM +" TEXT, "
            + KEY_TYPE  +" TEXT, "
            + KEY_ADRESSE  +" TEXT, "
            + KEY_CODE_POSTAL +" TEXT, "
            + KEY_VILLE  +" TEXT, "
            + KEY_MAIL  +" TEXT, "
            + KEY_TELEPHONE +" TEXT, "
            + KEY_MATERIEL +" BOOLEAN, "
            + KEY_ACCES_LIBRE+" BOOLEAN) ";


    public LieuxDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
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
