package com.example.leoneldinh10.mi_ahorcado.Acceso_Base_Datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BD_OpenHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "BD_Ahorca.db";



    private static final String TABLA_1 = "CREATE TABLE Palabras (" +
                                            "id INT PRIMARY KEY, nombre TEXT " +
                                             ")";



    public BD_OpenHelper (Context contexto)
    {
        super(contexto,DATABASE_NAME,null,DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(TABLA_1);


    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Todavia no implemente el Update()
    }



    public void insertarPalabra(int id, String nom) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null)
        {
            ContentValues valores = new ContentValues();
            valores.put("nombre", nom);
            valores.put("id", id);
            db.insert("Palabras", null, valores);
            db.close();
        }
    }



    public String recuperarPalabrota(int id)
    {
        SQLiteDatabase db = getReadableDatabase();
        String palabris="No se encontro nada en BD";
        String[] valores_recuperar = {"nombre"};
        Cursor c = db.query("Palabras", valores_recuperar, "id=" + id,
                null, null, null, null,null);

        if(c != null) {
            c.moveToFirst();
            palabris = c.getString(0);
        }

        db.close();
        c.close();


        return palabris;
    }


    public int total_palabras_en_BD()
    {
        int total=0;
        SQLiteDatabase db = getReadableDatabase();
        String palabris="No se encontro nada en BD";
        String[] valores_recuperar = {"id"};
        Cursor c = db.query("Palabras", valores_recuperar, null,
                null, null, null, null,null);

        if(c != null)
        {

            if (c.moveToFirst())
            {

                do
                {
                   total++;

                } while(c.moveToNext());
            }


        }

        db.close();
        c.close();

        return  total;
    }



    /*
    public String[] get_total_palabras_BD()
    {
        int secuencia=0;
        SQLiteDatabase db = getReadableDatabase();
        String[] palabris = new String[total_palabras_en_BD()];
        String[] valores_recuperar = {"nombre"};
        Cursor c = db.query("Palabras", valores_recuperar, null,
                null, null, null, null,null);

        if(c != null)
        {

            if (c.moveToFirst())
            {

                do
                {
                   secuencia++;
                  // palabris[secuencia] = c.getString(0);
                    palabris[secuencia] = secuencia + "";

                } while(c.moveToNext());
            }


        }

        db.close();
        c.close();


        return palabris;
    }
    */

}
