package com.example.practisesql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    DBHelper dbHelper;
    SQLiteDatabase database;
    Context context;

    public DBManager(Context c)
    {
        context = c;
    }

    public  DBManager Open()
    {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;


    }

    public void Close()
    {
        dbHelper.close();

    }

    public void Insert(String country, String currency)
    {
        ContentValues values = new ContentValues();
        values.put(DBHelper._COUNTRY, country);
        values.put(DBHelper._CURRENCY, currency);


        database.insert(DBHelper.TABLE_NAME,null, values);
    }

    public Cursor fetch(){

        String [] coloumns = new String[] {

                DBHelper._ID,
                DBHelper._COUNTRY,
                DBHelper._CURRENCY
        };

        Cursor query = database.query(DBHelper.TABLE_NAME, coloumns, null, null,
                null, null, null);

        if (query != null){

            query.moveToFirst();
        }

        return query;


    }

    public void Update(Long id, String country, String currency) {

        ContentValues contentValues= new ContentValues();
        contentValues.put(DBHelper._COUNTRY,country);
        contentValues.put(DBHelper._CURRENCY,currency);

        database.update(DBHelper.TABLE_NAME,contentValues,DBHelper._ID + " = " + id,null);


    }

    public void Delete(Long id) {
        ContentValues contentValues=new ContentValues();
        database.delete(DBHelper.TABLE_NAME,DBHelper._ID + " = " + id, null);
        //database.delete(DBHelper.TABLE_NAME,contentValues,DBHelper._ID+ " = " +id, null);
    }
}
