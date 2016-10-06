package com.esgi.handiwe.DAL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pico on 06/10/2016.
 */

public class ProfilDBHandler extends SQLiteOpenHelper {


    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "database.db";
    private static final String DATABASE_TABLE = "PROFIL";

    private static final String KEY_ID = "ID_PROFIL";
    private static final String KEY_UTILISATEUR = "ID_UTILISATEUR";
    private static final String KEY_SPORT = "ID_SPORT";
    private static final String KEY_LIEUX = "ID_LIEUX";
    private static final String KEY_ISCLUB = "IS_IN_CLUB";
    private static final String KEY_CLUB = "CLUB";
    private static final String KEY_LICENCE = "LICENCE";


    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +DATABASE_TABLE+" ("
            + KEY_ID+" INTEGER PRIMARY KEY, "
            + KEY_UTILISATEUR+" INTEGER,"
            + KEY_SPORT+" INTEGER, "
            + KEY_LIEUX+" TEXT, "
            + KEY_ISCLUB+" BOOLEAN, "
            + KEY_CLUB+" TEXT, "
            + KEY_LICENCE+" TEXT)";


    public ProfilDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
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
