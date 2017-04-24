package com.example.leoneldinh10.mi_ahorcado.Acceso_Base_Datos;


public class Palabra
{
    int id;
    String palabra="";


    public Palabra(int id, String palabra)
    {
        this.id = id;
        this.palabra = palabra;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
}
