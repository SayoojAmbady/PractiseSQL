package com.example.practisesql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "DDUKK_COUN.db";

    public static final String TABLE_NAME="COUNTRIES";

    public static  final String _ID = "_id";
    public static  final  String _COUNTRY = "name";
    public static  final  String _CURRENCY  = "currency";

    private static final int _VERSION= 1;
    private static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME+"( "+_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ _COUNTRY +" TEXT NOT NULL, "+_CURRENCY+" TEXT)";

//    String query= "CREATE TABLE"+ TABLE_NAME +" ("+_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+_NAME+" TEXT NOT NULL, "+_CURRENCY+" TEXT)";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, _VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }
}
