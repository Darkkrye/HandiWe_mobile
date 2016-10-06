package com.esgi.handiwe.DAL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pico on 06/10/2016.
 */

public class MessageDBHandler extends SQLiteOpenHelper {


    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "database.db";
    private static final String DATABASE_TABLE = "MESSAGE";

    private static final String KEY_ID = "ID_MESSAGE";
    private static final String KEY_CONVERSATION = "ID_CONVERSATION";
    private static final String KEY_CONTENU = "CONTENU";


    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +DATABASE_TABLE+" ("
            + KEY_ID+" INTEGER PRIMARY KEY, "
            + KEY_CONVERSATION+" INTEGER,"
            + KEY_CONTENU+" TEXT) ";



    public MessageDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
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
