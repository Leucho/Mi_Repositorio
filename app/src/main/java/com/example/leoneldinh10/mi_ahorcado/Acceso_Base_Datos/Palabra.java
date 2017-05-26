package com.example.leoneldinh10.mi_ahorcado.Acceso_Base_Datos;


public class Palabra
{
    int id;
    String palabra="";
    int nivel;

    public Palabra(int id, String palabra)
    {
        this.id = id;
        this.palabra = palabra;
    }




    //Agregado el dia 25 mayo 2017 -> Para ver si se puede hacer la parte de los niveles en la segunda entrega de ADS
    public Palabra(int id, String palabra,int nivel)
    {
        this.id = id;
        this.palabra = palabra;
        this.nivel = nivel;
    }


    //Constructor agregado para transformar el JSONArray en una lista de palabras en el MainActivity, le saco el parametro ID, ya que no me importa, solo me importa el NIVEL y que PALABRA es la que voy a mostrar.
    public Palabra(String palabra,int nivel)
    {
        this.palabra = palabra;
        this.nivel = nivel;
    }


    public int getNivel() {
        return nivel;
    }

    public void setNivel(int ni) {
        this.nivel = ni;
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
