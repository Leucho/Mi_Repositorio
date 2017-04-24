package com.example.leoneldinh10.mi_ahorcado.Acceso_Base_Datos;

import android.provider.BaseColumns;


public class Tabla_PalabraBD
{

    public abstract class Palabra_Abstract implements BaseColumns
    {

        public static final String Tabla_Palabra = "PALABRA_Tabla";

        public static final int id_palabra = 0;
        public static final String palabra_cadena="palabra_cadena";


    }

}
