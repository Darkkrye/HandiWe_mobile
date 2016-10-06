package com.esgi.handiwe.DAL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pico on 06/10/2016.
 */

public class HeureDBHandler extends SQLiteOpenHelper {


    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "database.db";
    private static final String DATABASE_TABLE = "HEURE";

    private static final String KEY_ID = "ID_HEURE";
    private static final String KEY_DISPONIBILITE = "ID_DISPONIBILITE";
    private static final String KEY_HEURE_DEBUT = "HEURE_DEBUT";
    private static final String KEY_HEURE_FIN = "HEURE_FIN";


    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +DATABASE_TABLE+" ("
            + KEY_ID+" INTEGER PRIMARY KEY, "
            + KEY_DISPONIBILITE+" INTEGER,"
            + KEY_HEURE_DEBUT+" INTEGER "
            + KEY_HEURE_FIN+" INTEGER)";


    public HeureDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
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
