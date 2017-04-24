package com.example.leoneldinh10.mi_ahorcado.Acceso_Base_Datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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


    public void insertar_Palabras_en_BD()
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",39);
        values.put("nombre", "casa");
        db.insert("Palabras", null, values);

      //  db.execSQL("INSERT INTO Palabras(id,nombre) VALUES (122,'papilo')");

        db.close();
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



    /*






    public String get_palabra_Query(String id) {

        String palabrar="";
        Cursor c = getReadableDatabase().query(                                 //   QUERY
                "Palabras",
                null,
                "id" + " LIKE ?",
                new String[]{id},
                null,
                null,
                null);

        if (c.moveToFirst()) {
            do
            {
                palabrar += c.getString(1) + "  -  ";

            } while(c.moveToNext());
        }
        else
        {
            palabrar = "NADA";
        }

        return palabrar;
    }





    public String get_Palabra_RawQuery(String id)
    {
        String retorno="";
        Cursor c;
        SQLiteDatabase db = getWritableDatabase();
        String query = "Select * from Palabras WHERE id=?";
        c =  db.rawQuery(query, new String[]{"id"});                         //  RAWQUERY

        if (c.moveToFirst()) {
            do
            {
                retorno += c.getString(1) + "  -  ";

            } while(c.moveToNext());
        }
        else
        {
            retorno = "NADA";
        }


        return  retorno;
    }


*/


}
