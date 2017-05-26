package com.example.leoneldinh10.mi_ahorcado;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.leoneldinh10.mi_ahorcado.Acceso_Base_Datos.BD_OpenHelper;
import com.example.leoneldinh10.mi_ahorcado.Acceso_Base_Datos.Palabra;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private String palabra = "";
    private int total_coincidencias_varGlobal=0;
    private BD_OpenHelper base_datos;
    private String probando_palabra_modificada="";

















    private int nivel = 1;          //Habra tres niveles de DIFICULTAD en el Juego -> Facil, Medio y Dificil
    private int puntos = 0;         //Estos sera lo que llevara la cuenta de las estrellas -> al llegar a tres, se pasa de nivel
















    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        base_datos = new BD_OpenHelper(getApplicationContext());

/*
        - ESTAS LINEAS HACEN FALTA DESCOMENTARLAS LA PRIMERA VEZ QUE SE EJECUTA EL PROYECTO, PARA INSERTAR PALABRAS EN LA BASE DE DATOS
        - SI O SI TIENEN QUE EJECUTARSE UNA UNICA VEZ, Y SACARLAS.
        - SI SE EJECUTAN MAS DE UNA VEZ, SE INSERTARAN PALABRAS CON "ID" RETIDOS, Y SALTARA ERROR EN EL PROGRAMA CUANDO TRATE DE TRAER UNA UNICA PALABRA EN EL METODO "recuperarPalabreta(nro_id)"


        base_datos.insertarPalabra(1,"casa");
        base_datos.insertarPalabra(2,"perro");
        base_datos.insertarPalabra(3,"gato");
        base_datos.insertarPalabra(4,"mono");
        base_datos.insertarPalabra(5,"computadora");
        base_datos.insertarPalabra(6,"elefante");
        base_datos.insertarPalabra(7,"rinoceronte");
        base_datos.insertarPalabra(8,"teclado");
        base_datos.insertarPalabra(9,"celular");
        base_datos.insertarPalabra(10,"monitor");
        base_datos.insertarPalabra(11,"raton");
        base_datos.insertarPalabra(12,"jirafa");
        base_datos.insertarPalabra(13,"leon");
        base_datos.insertarPalabra(14,"tigre");
        base_datos.insertarPalabra(15,"virus");
        base_datos.insertarPalabra(16,"gusano");
        base_datos.insertarPalabra(17,"arquitectura");
        base_datos.insertarPalabra(18,"antivirus");
        base_datos.insertarPalabra(19,"loro");
        base_datos.insertarPalabra(20,"moneda");

*/




        palabra = base_datos.recuperarPalabrota(obtener_aleatorio());







        //Esto lo agregue porque la primera vez que cargaba la app, se mostraba una palabra cualquiera de la BD, sin importar el nivel en el cual se encontraba el jugador!
        Hilo_Clase hilito = new Hilo_Clase();
        hilito.execute();
















        Log.d("Palabra BD -> ", palabra);

        probando_palabra_modificada = palabra;


        limpiarLetras();
        letrasVisibles(palabra.length());

        Log.d("Palabra Original -> ", palabra);
        Log.d("Largo palabra orig -> ", palabra.length() + "");


        verificar_diccionario_letras_BD();
    }




/*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.porBD:
            {
                Toast.makeText(this, "Hola, esto es por BD", Toast.LENGTH_SHORT ).show();

                return true;
            }

            case R.id.porREST:
            {
                Toast.makeText(this, "Hola, esto es por REST", Toast.LENGTH_LONG ).show();

                return true;
            }

            default:
                return super.onOptionsItemSelected(item);
        }
    }


*/














    public int obtener_aleatorio()          //Es para que genere un numero del 1 al 6 inicialmente. Despues tendra qe hacerse desde el 1 hasta el total de palabras que hay en la Base de Datos.
    {
        int nro = (int) Math.floor(Math.random()*20+1) ;
        Log.d("Nro aleatorio","" + nro);
        return nro;
    }

    public void verificar_diccionario_letras_BD()   //Muestra en la consola las palabras de la BD
    {
        Log.d("MI BASE DE DATOS","");

        for(int i = 1; i <= 20; i++)        //uso hasta 20 porque se que hay solo 20 palabras en la BD, pero tendria que hacer primero un metodo qe retorne la cantidad de registros palabra en la tabla Palabras y despues usarlo en este ciclo for
        {
            Log.d("Palabra BD --> Nro." + i + " -- ",base_datos.recuperarPalabrota(i));
        }

        Log.d("TOTAL PALABRAS -> ",base_datos.total_palabras_en_BD() + "");

    }



    public void limpiarLetras()
    {
        TextView letra = (TextView) findViewById(R.id.letra1);
        letra.setText("_");
        TextView letra2 = (TextView) findViewById(R.id.letra2);
        letra2.setText("_");
        TextView letra3 = (TextView) findViewById(R.id.letra3);
        letra3.setText("_");
        TextView letra4 = (TextView) findViewById(R.id.letra4);
        letra4.setText("_");
        TextView letra5 = (TextView) findViewById(R.id.letra5);
        letra5.setText("_");
        TextView letra6 = (TextView) findViewById(R.id.letra6);
        letra6.setText("_");
        TextView letra7 = (TextView) findViewById(R.id.letra7);
        letra7.setText("_");
        TextView letra8 = (TextView) findViewById(R.id.letra8);
        letra8.setText("_");
        TextView letra9 = (TextView) findViewById(R.id.letra9);
        letra9.setText("_");
        TextView letra10 = (TextView) findViewById(R.id.letra10);
        letra10.setText("_");
        TextView letra11 = (TextView) findViewById(R.id.letra11);
        letra11.setText("_");
        TextView letra12 = (TextView) findViewById(R.id.letra12);
        letra12.setText("_");
        TextView letra13 = (TextView) findViewById(R.id.letra13);
        letra13.setText("_");
        TextView letra14 = (TextView) findViewById(R.id.letra14);
        letra14.setText("_");
    }



    public int cantidadLetras(String pala)
    {
        int cant = pala.length();
        return cant;
    }



    public void letrasVisibles(int largo_palabra)
    {
        int cant_letras_viejas = cantidadLetras(palabra);

        Log.d("Largo letras viejas -> " , cant_letras_viejas+"");

        int cant_letras = largo_palabra;

      switch (cant_letras)
        {
            case 3:
            {
                Log.d("Case -> ", cant_letras +"");
                TextView letra = (TextView) findViewById(R.id.letra1);
                letra.setVisibility(View.VISIBLE);
                TextView letra2 = (TextView) findViewById(R.id.letra2);
                letra2.setVisibility(View.VISIBLE);
                TextView letra3 = (TextView) findViewById(R.id.letra3);
                letra3.setVisibility(View.VISIBLE);
                TextView letra4 = (TextView) findViewById(R.id.letra4);
                letra4.setVisibility(View.INVISIBLE);
                TextView letra5 = (TextView) findViewById(R.id.letra5);
                letra5.setVisibility(View.INVISIBLE);
                TextView letra6 = (TextView) findViewById(R.id.letra6);
                letra6.setVisibility(View.INVISIBLE);
                TextView letra7 = (TextView) findViewById(R.id.letra7);
                letra7.setVisibility(View.INVISIBLE);
                TextView letra8 = (TextView) findViewById(R.id.letra8);
                letra8.setVisibility(View.INVISIBLE);
                TextView letra9 = (TextView) findViewById(R.id.letra9);
                letra9.setVisibility(View.INVISIBLE);
                TextView letra10 = (TextView) findViewById(R.id.letra10);
                letra10.setVisibility(View.INVISIBLE);
                TextView letra11 = (TextView) findViewById(R.id.letra11);
                letra11.setVisibility(View.INVISIBLE);
                TextView letra12 = (TextView) findViewById(R.id.letra12);
                letra12.setVisibility(View.INVISIBLE);
                TextView letra13 = (TextView) findViewById(R.id.letra13);
                letra13.setVisibility(View.INVISIBLE);
                TextView letra14 = (TextView) findViewById(R.id.letra14);
                letra14.setVisibility(View.INVISIBLE);
                break;
            }

            case 4:
            {
                Log.d("Case -> ", cant_letras +"");
                TextView letra = (TextView) findViewById(R.id.letra1);
                letra.setVisibility(View.VISIBLE);
                TextView letra2 = (TextView) findViewById(R.id.letra2);
                letra2.setVisibility(View.VISIBLE);
                TextView letra3 = (TextView) findViewById(R.id.letra3);
                letra3.setVisibility(View.VISIBLE);
                TextView letra4 = (TextView) findViewById(R.id.letra4);
                letra4.setVisibility(View.VISIBLE);
                TextView letra5 = (TextView) findViewById(R.id.letra5);
                letra5.setVisibility(View.INVISIBLE);
                TextView letra6 = (TextView) findViewById(R.id.letra6);
                letra6.setVisibility(View.INVISIBLE);
                TextView letra7 = (TextView) findViewById(R.id.letra7);
                letra7.setVisibility(View.INVISIBLE);
                TextView letra8 = (TextView) findViewById(R.id.letra8);
                letra8.setVisibility(View.INVISIBLE);
                TextView letra9 = (TextView) findViewById(R.id.letra9);
                letra9.setVisibility(View.INVISIBLE);
                TextView letra10 = (TextView) findViewById(R.id.letra10);
                letra10.setVisibility(View.INVISIBLE);
                TextView letra11 = (TextView) findViewById(R.id.letra11);
                letra11.setVisibility(View.INVISIBLE);
                TextView letra12 = (TextView) findViewById(R.id.letra12);
                letra12.setVisibility(View.INVISIBLE);
                TextView letra13 = (TextView) findViewById(R.id.letra13);
                letra13.setVisibility(View.INVISIBLE);
                TextView letra14 = (TextView) findViewById(R.id.letra14);
                letra14.setVisibility(View.INVISIBLE);
                break;
            }

            case 5:
            {
                Log.d("Case -> ", cant_letras +"");
                TextView letra = (TextView) findViewById(R.id.letra1);
                letra.setVisibility(View.VISIBLE);
                TextView letra2 = (TextView) findViewById(R.id.letra2);
                letra2.setVisibility(View.VISIBLE);
                TextView letra3 = (TextView) findViewById(R.id.letra3);
                letra3.setVisibility(View.VISIBLE);
                TextView letra4 = (TextView) findViewById(R.id.letra4);
                letra4.setVisibility(View.VISIBLE);
                TextView letra5 = (TextView) findViewById(R.id.letra5);
                letra5.setVisibility(View.VISIBLE);
                TextView letra6 = (TextView) findViewById(R.id.letra6);
                letra6.setVisibility(View.INVISIBLE);
                TextView letra7 = (TextView) findViewById(R.id.letra7);
                letra7.setVisibility(View.INVISIBLE);
                TextView letra8 = (TextView) findViewById(R.id.letra8);
                letra8.setVisibility(View.INVISIBLE);
                TextView letra9 = (TextView) findViewById(R.id.letra9);
                letra9.setVisibility(View.INVISIBLE);
                TextView letra10 = (TextView) findViewById(R.id.letra10);
                letra10.setVisibility(View.INVISIBLE);
                TextView letra11 = (TextView) findViewById(R.id.letra11);
                letra11.setVisibility(View.INVISIBLE);
                TextView letra12 = (TextView) findViewById(R.id.letra12);
                letra12.setVisibility(View.INVISIBLE);
                TextView letra13 = (TextView) findViewById(R.id.letra13);
                letra13.setVisibility(View.INVISIBLE);
                TextView letra14 = (TextView) findViewById(R.id.letra14);
                letra14.setVisibility(View.INVISIBLE);
                break;
            }


            case 6:
            {
                Log.d("Case -> ", cant_letras +"");
                TextView letra = (TextView) findViewById(R.id.letra1);
                letra.setVisibility(View.VISIBLE);
                TextView letra2 = (TextView) findViewById(R.id.letra2);
                letra2.setVisibility(View.VISIBLE);
                TextView letra3 = (TextView) findViewById(R.id.letra3);
                letra3.setVisibility(View.VISIBLE);
                TextView letra4 = (TextView) findViewById(R.id.letra4);
                letra4.setVisibility(View.VISIBLE);
                TextView letra5 = (TextView) findViewById(R.id.letra5);
                letra5.setVisibility(View.VISIBLE);
                TextView letra6 = (TextView) findViewById(R.id.letra6);
                letra6.setVisibility(View.VISIBLE);
                TextView letra7 = (TextView) findViewById(R.id.letra7);
                letra7.setVisibility(View.INVISIBLE);
                TextView letra8 = (TextView) findViewById(R.id.letra8);
                letra8.setVisibility(View.INVISIBLE);
                TextView letra9 = (TextView) findViewById(R.id.letra9);
                letra9.setVisibility(View.INVISIBLE);
                TextView letra10 = (TextView) findViewById(R.id.letra10);
                letra10.setVisibility(View.INVISIBLE);
                TextView letra11 = (TextView) findViewById(R.id.letra11);
                letra11.setVisibility(View.INVISIBLE);
                TextView letra12 = (TextView) findViewById(R.id.letra12);
                letra12.setVisibility(View.INVISIBLE);
                TextView letra13 = (TextView) findViewById(R.id.letra13);
                letra13.setVisibility(View.INVISIBLE);
                TextView letra14 = (TextView) findViewById(R.id.letra14);
                letra14.setVisibility(View.INVISIBLE);
                break;
            }



            case 7:
            {
                Log.d("Case -> ", cant_letras +"");
                TextView letra = (TextView) findViewById(R.id.letra1);
                letra.setVisibility(View.VISIBLE);
                TextView letra2 = (TextView) findViewById(R.id.letra2);
                letra2.setVisibility(View.VISIBLE);
                TextView letra3 = (TextView) findViewById(R.id.letra3);
                letra3.setVisibility(View.VISIBLE);
                TextView letra4 = (TextView) findViewById(R.id.letra4);
                letra4.setVisibility(View.VISIBLE);
                TextView letra5 = (TextView) findViewById(R.id.letra5);
                letra5.setVisibility(View.VISIBLE);
                TextView letra6 = (TextView) findViewById(R.id.letra6);
                letra6.setVisibility(View.VISIBLE);
                TextView letra7 = (TextView) findViewById(R.id.letra7);
                letra7.setVisibility(View.VISIBLE);
                TextView letra8 = (TextView) findViewById(R.id.letra8);
                letra8.setVisibility(View.INVISIBLE);
                TextView letra9 = (TextView) findViewById(R.id.letra9);
                letra9.setVisibility(View.INVISIBLE);
                TextView letra10 = (TextView) findViewById(R.id.letra10);
                letra10.setVisibility(View.INVISIBLE);
                TextView letra11 = (TextView) findViewById(R.id.letra11);
                letra11.setVisibility(View.INVISIBLE);
                TextView letra12 = (TextView) findViewById(R.id.letra12);
                letra12.setVisibility(View.INVISIBLE);
                TextView letra13 = (TextView) findViewById(R.id.letra13);
                letra13.setVisibility(View.INVISIBLE);
                TextView letra14 = (TextView) findViewById(R.id.letra14);
                letra14.setVisibility(View.INVISIBLE);
                break;
            }


            case 8:
            {
                Log.d("Case -> ", cant_letras +"");
                TextView letra = (TextView) findViewById(R.id.letra1);
                letra.setVisibility(View.VISIBLE);
                TextView letra2 = (TextView) findViewById(R.id.letra2);
                letra2.setVisibility(View.VISIBLE);
                TextView letra3 = (TextView) findViewById(R.id.letra3);
                letra3.setVisibility(View.VISIBLE);
                TextView letra4 = (TextView) findViewById(R.id.letra4);
                letra4.setVisibility(View.VISIBLE);
                TextView letra5 = (TextView) findViewById(R.id.letra5);
                letra5.setVisibility(View.VISIBLE);
                TextView letra6 = (TextView) findViewById(R.id.letra6);
                letra6.setVisibility(View.VISIBLE);
                TextView letra7 = (TextView) findViewById(R.id.letra7);
                letra7.setVisibility(View.VISIBLE);
                TextView letra8 = (TextView) findViewById(R.id.letra8);
                letra8.setVisibility(View.VISIBLE);
                TextView letra9 = (TextView) findViewById(R.id.letra9);
                letra9.setVisibility(View.INVISIBLE);
                TextView letra10 = (TextView) findViewById(R.id.letra10);
                letra10.setVisibility(View.INVISIBLE);
                TextView letra11 = (TextView) findViewById(R.id.letra11);
                letra11.setVisibility(View.INVISIBLE);
                TextView letra12 = (TextView) findViewById(R.id.letra12);
                letra12.setVisibility(View.INVISIBLE);
                TextView letra13 = (TextView) findViewById(R.id.letra13);
                letra13.setVisibility(View.INVISIBLE);
                TextView letra14 = (TextView) findViewById(R.id.letra14);
                letra14.setVisibility(View.INVISIBLE);
                break;
            }

            case 9:
            {
                Log.d("Case -> ", cant_letras +"");
                TextView letra = (TextView) findViewById(R.id.letra1);
                letra.setVisibility(View.VISIBLE);
                TextView letra2 = (TextView) findViewById(R.id.letra2);
                letra2.setVisibility(View.VISIBLE);
                TextView letra3 = (TextView) findViewById(R.id.letra3);
                letra3.setVisibility(View.VISIBLE);
                TextView letra4 = (TextView) findViewById(R.id.letra4);
                letra4.setVisibility(View.VISIBLE);
                TextView letra5 = (TextView) findViewById(R.id.letra5);
                letra5.setVisibility(View.VISIBLE);
                TextView letra6 = (TextView) findViewById(R.id.letra6);
                letra6.setVisibility(View.VISIBLE);
                TextView letra7 = (TextView) findViewById(R.id.letra7);
                letra7.setVisibility(View.VISIBLE);
                TextView letra8 = (TextView) findViewById(R.id.letra8);
                letra8.setVisibility(View.VISIBLE);
                TextView letra9 = (TextView) findViewById(R.id.letra9);
                letra9.setVisibility(View.VISIBLE);
                TextView letra10 = (TextView) findViewById(R.id.letra10);
                letra10.setVisibility(View.INVISIBLE);
                TextView letra11 = (TextView) findViewById(R.id.letra11);
                letra11.setVisibility(View.INVISIBLE);
                TextView letra12 = (TextView) findViewById(R.id.letra12);
                letra12.setVisibility(View.INVISIBLE);
                TextView letra13 = (TextView) findViewById(R.id.letra13);
                letra13.setVisibility(View.INVISIBLE);
                TextView letra14 = (TextView) findViewById(R.id.letra14);
                letra14.setVisibility(View.INVISIBLE);
                break;
            }

            case 10:
            {
                Log.d("Case -> ", cant_letras +"");
                TextView letra = (TextView) findViewById(R.id.letra1);
                letra.setVisibility(View.VISIBLE);
                TextView letra2 = (TextView) findViewById(R.id.letra2);
                letra2.setVisibility(View.VISIBLE);
                TextView letra3 = (TextView) findViewById(R.id.letra3);
                letra3.setVisibility(View.VISIBLE);
                TextView letra4 = (TextView) findViewById(R.id.letra4);
                letra4.setVisibility(View.VISIBLE);
                TextView letra5 = (TextView) findViewById(R.id.letra5);
                letra5.setVisibility(View.VISIBLE);
                TextView letra6 = (TextView) findViewById(R.id.letra6);
                letra6.setVisibility(View.VISIBLE);
                TextView letra7 = (TextView) findViewById(R.id.letra7);
                letra7.setVisibility(View.VISIBLE);
                TextView letra8 = (TextView) findViewById(R.id.letra8);
                letra8.setVisibility(View.VISIBLE);
                TextView letra9 = (TextView) findViewById(R.id.letra9);
                letra9.setVisibility(View.VISIBLE);
                TextView letra10 = (TextView) findViewById(R.id.letra10);
                letra10.setVisibility(View.VISIBLE);
                TextView letra11 = (TextView) findViewById(R.id.letra11);
                letra11.setVisibility(View.INVISIBLE);
                TextView letra12 = (TextView) findViewById(R.id.letra12);
                letra12.setVisibility(View.INVISIBLE);
                TextView letra13 = (TextView) findViewById(R.id.letra13);
                letra13.setVisibility(View.INVISIBLE);
                TextView letra14 = (TextView) findViewById(R.id.letra14);
                letra14.setVisibility(View.INVISIBLE);
                break;
            }

            case 11:
            {
                Log.d("Case -> ", cant_letras +"");
                TextView letra = (TextView) findViewById(R.id.letra1);
                letra.setVisibility(View.VISIBLE);
                TextView letra2 = (TextView) findViewById(R.id.letra2);
                letra2.setVisibility(View.VISIBLE);
                TextView letra3 = (TextView) findViewById(R.id.letra3);
                letra3.setVisibility(View.VISIBLE);
                TextView letra4 = (TextView) findViewById(R.id.letra4);
                letra4.setVisibility(View.VISIBLE);
                TextView letra5 = (TextView) findViewById(R.id.letra5);
                letra5.setVisibility(View.VISIBLE);
                TextView letra6 = (TextView) findViewById(R.id.letra6);
                letra6.setVisibility(View.VISIBLE);
                TextView letra7 = (TextView) findViewById(R.id.letra7);
                letra7.setVisibility(View.VISIBLE);
                TextView letra8 = (TextView) findViewById(R.id.letra8);
                letra8.setVisibility(View.VISIBLE);
                TextView letra9 = (TextView) findViewById(R.id.letra9);
                letra9.setVisibility(View.VISIBLE);
                TextView letra10 = (TextView) findViewById(R.id.letra10);
                letra10.setVisibility(View.VISIBLE);
                TextView letra11 = (TextView) findViewById(R.id.letra11);
                letra11.setVisibility(View.VISIBLE);
                TextView letra12 = (TextView) findViewById(R.id.letra12);
                letra12.setVisibility(View.INVISIBLE);
                TextView letra13 = (TextView) findViewById(R.id.letra13);
                letra13.setVisibility(View.INVISIBLE);
                TextView letra14 = (TextView) findViewById(R.id.letra14);
                letra14.setVisibility(View.INVISIBLE);
                break;
            }

            case 12:
            {
                Log.d("Case -> ", cant_letras +"");
                TextView letra = (TextView) findViewById(R.id.letra1);
                letra.setVisibility(View.VISIBLE);
                TextView letra2 = (TextView) findViewById(R.id.letra2);
                letra2.setVisibility(View.VISIBLE);
                TextView letra3 = (TextView) findViewById(R.id.letra3);
                letra3.setVisibility(View.VISIBLE);
                TextView letra4 = (TextView) findViewById(R.id.letra4);
                letra4.setVisibility(View.VISIBLE);
                TextView letra5 = (TextView) findViewById(R.id.letra5);
                letra5.setVisibility(View.VISIBLE);
                TextView letra6 = (TextView) findViewById(R.id.letra6);
                letra6.setVisibility(View.VISIBLE);
                TextView letra7 = (TextView) findViewById(R.id.letra7);
                letra7.setVisibility(View.VISIBLE);
                TextView letra8 = (TextView) findViewById(R.id.letra8);
                letra8.setVisibility(View.VISIBLE);
                TextView letra9 = (TextView) findViewById(R.id.letra9);
                letra9.setVisibility(View.VISIBLE);
                TextView letra10 = (TextView) findViewById(R.id.letra10);
                letra10.setVisibility(View.VISIBLE);
                TextView letra11 = (TextView) findViewById(R.id.letra11);
                letra11.setVisibility(View.VISIBLE);
                TextView letra12 = (TextView) findViewById(R.id.letra12);
                letra12.setVisibility(View.VISIBLE);
                TextView letra13 = (TextView) findViewById(R.id.letra13);
                letra13.setVisibility(View.INVISIBLE);
                TextView letra14 = (TextView) findViewById(R.id.letra14);
                letra14.setVisibility(View.INVISIBLE);
                break;
            }

            case 13:
            {
                Log.d("Case -> ", cant_letras +"");
                TextView letra = (TextView) findViewById(R.id.letra1);
                letra.setCursorVisible(true);
                TextView letra2 = (TextView) findViewById(R.id.letra2);
                letra2.setCursorVisible(true);
                TextView letra3 = (TextView) findViewById(R.id.letra3);
                letra3.setCursorVisible(true);
                TextView letra4 = (TextView) findViewById(R.id.letra4);
                letra4.setCursorVisible(true);
                TextView letra5 = (TextView) findViewById(R.id.letra5);
                letra5.setCursorVisible(true);
                TextView letra6 = (TextView) findViewById(R.id.letra6);
                letra6.setCursorVisible(true);
                TextView letra7 = (TextView) findViewById(R.id.letra7);
                letra7.setCursorVisible(true);
                TextView letra8 = (TextView) findViewById(R.id.letra8);
                letra8.setVisibility(View.VISIBLE);
                TextView letra9 = (TextView) findViewById(R.id.letra9);
                letra9.setVisibility(View.VISIBLE);
                TextView letra10 = (TextView) findViewById(R.id.letra10);
                letra10.setVisibility(View.VISIBLE);
                TextView letra11 = (TextView) findViewById(R.id.letra11);
                letra11.setVisibility(View.VISIBLE);
                TextView letra12 = (TextView) findViewById(R.id.letra12);
                letra12.setVisibility(View.VISIBLE);
                TextView letra13 = (TextView) findViewById(R.id.letra13);
                letra13.setVisibility(View.VISIBLE);
                TextView letra14 = (TextView) findViewById(R.id.letra14);
                letra14.setVisibility(View.INVISIBLE);
                break;
            }

            case 14:
            {
                Log.d("Case -> ", cant_letras +"");
                TextView letra = (TextView) findViewById(R.id.letra1);
                letra.setCursorVisible(true);
                TextView letra2 = (TextView) findViewById(R.id.letra2);
                letra2.setCursorVisible(true);
                TextView letra3 = (TextView) findViewById(R.id.letra3);
                letra3.setCursorVisible(true);
                TextView letra4 = (TextView) findViewById(R.id.letra4);
                letra4.setCursorVisible(true);
                TextView letra5 = (TextView) findViewById(R.id.letra5);
                letra5.setCursorVisible(true);
                TextView letra6 = (TextView) findViewById(R.id.letra6);
                letra6.setCursorVisible(true);
                TextView letra7 = (TextView) findViewById(R.id.letra7);
                letra7.setCursorVisible(true);
                TextView letra8 = (TextView) findViewById(R.id.letra8);
                letra8.setVisibility(View.VISIBLE);
                TextView letra9 = (TextView) findViewById(R.id.letra9);
                letra9.setVisibility(View.VISIBLE);
                TextView letra10 = (TextView) findViewById(R.id.letra10);
                letra10.setVisibility(View.VISIBLE);
                TextView letra11 = (TextView) findViewById(R.id.letra11);
                letra11.setVisibility(View.VISIBLE);
                TextView letra12 = (TextView) findViewById(R.id.letra12);
                letra12.setVisibility(View.VISIBLE);
                TextView letra13 = (TextView) findViewById(R.id.letra13);
                letra13.setVisibility(View.VISIBLE);
                TextView letra14 = (TextView) findViewById(R.id.letra14);
                letra14.setVisibility(View.VISIBLE);
                break;
            }

            default:
            {
                Log.d("Entro en Case Default", "TODO ROTO!! LetrasVisibles()");
                break;
            }

        }   //Fin del Case


    }       //Fin metodo letrasVisibles()



    public int retornaID_letra(int posicionLetra)
    {
        int id=0;

        switch (posicionLetra)
                {
                    case 1:
                    {
                        id = R.id.letra1;
                        break;
                    }
                    case 2:
                    {
                        id = R.id.letra2;
                        break;
                    }
                    case 3:
                    {
                        id = R.id.letra3;
                        break;
                    }
                    case 4:
                    {
                        id = R.id.letra4;
                        break;
                    }
                    case 5:
                    {
                        id = R.id.letra5;
                        break;
                    }
                    case 6:
                    {
                        id = R.id.letra6;
                        break;
                    }
                    case 7:
                    {
                        id = R.id.letra7;
                        break;
                    }
                    case 8:
                    {
                        id = R.id.letra8;
                        break;
                    }
                    case 9:
                    {
                        id = R.id.letra9;
                        break;
                    }
                    case 10:
                    {
                        id = R.id.letra10;
                        break;
                    }
                    case 11:
                    {
                        id = R.id.letra11;
                        break;
                    }
                    case 12:
                    {
                        id = R.id.letra12;
                        break;
                    }
                    case 13:
                    {
                        id = R.id.letra13;
                        break;
                    }
                    case 14:
                    {
                        id = R.id.letra14;
                        break;
                    }
                    default:
                    {
                        break;
                    }

                }


        return id;
    }


    public void exxxxiste(View aa)
    {
        Button btn = (Button) aa;
        aa.setVisibility(View.INVISIBLE);
        String letra = btn.getText().toString();
        letra = letra.toLowerCase();
        verificarExistenciaLetra(letra);
    }


    public void verificarExistenciaLetra(String v)
    {
        char letra_caracter;
        TextView letra_view;

        Log.d("Parametro que llega -> ", v.charAt(0) +"");

        int alguna_coincidencia = 0;
        int cantidad_vidas = 0;
        int cantidad_monedas = 0;

        TextView corto_cabeza;                                                          //Vida 6
        TextView corto_tronco1, corto_tronco2, corto_tronco3, corto_tronco4;            //Vida 5
        TextView corto_brazoIzq;                                                        //Vida 4
        TextView corto_brazoDer;                                                        //Vida 3
        TextView corto_pieIzq;                                                          //Vida 2
        TextView corto_pieDer;                                                          //Vida 1

        TextView nroVidas = (TextView) findViewById(R.id.textNroVidas);
        TextView nroMonedas = (TextView) findViewById(R.id.textNroMonedas);



        for (int i = 0; i < cantidadLetras(palabra); i++)
        {
            letra_caracter = palabra.charAt(i);

            if ( letra_caracter == v.charAt(0) )
            {

                letra_view = (TextView) findViewById(retornaID_letra(i+1));
                letra_view.setText(letra_caracter+ "");
                alguna_coincidencia++;
                total_coincidencias_varGlobal++;


                Log.d("Palabra ---> ",palabra);
                Log.d("Btn letra apretada --> ",v);
                Log.d("Letra posicion i = " + i ,palabra);
                Log.d("Nro coincidencias " + letra_caracter , total_coincidencias_varGlobal + "");


               probando_palabra_modificada = probando_palabra_modificada.replace(probando_palabra_modificada.charAt(i),'_');
               Log.d("Palabra modi 2 -> ",probando_palabra_modificada);

            }  //FIN if

        }   //FIN ciclo for



        if(total_coincidencias_varGlobal == cantidadLetras(palabra))
        {

            Toast.makeText(this, "GANASTE!!!", Toast.LENGTH_LONG).show();
            cantidad_monedas = Integer.parseInt(nroMonedas.getText().toString());
            cantidad_monedas++;
            Button btnMoneda = (Button) findViewById(R.id.usarMoneda);

            nroMonedas.setText(cantidad_monedas + "");

            if(cantidad_monedas>0)
            {
                btnMoneda.setEnabled(true);
            }



            nroVidas.setText("6");
            total_coincidencias_varGlobal = 0;      //Se inicializa de nuevo la variable global creada
















            // Agrego lo que tiene que ver con los distintos niveles y estrellas(FEDE)
            ImageView e1 = (ImageView) findViewById(R.id.estrella1);
            ImageView e2 = (ImageView) findViewById(R.id.estrella2);
            ImageView e3 = (ImageView) findViewById(R.id.estrella3);

            TextView niv = (TextView) findViewById(R.id.textNivel);
            TextView est = (TextView) findViewById(R.id.textViewEstrellas);

            puntos++;

            agregarEstrella();


            if(puntos==3)
            {
                e1.setVisibility(View.INVISIBLE);
                e2.setVisibility(View.INVISIBLE);
                e3.setVisibility(View.INVISIBLE);
                puntos=0;
                est.setText("0/3");

                if(nivel <3)
                {
                    nivel++;
                //    Toast.makeText(this, "Subes un Nivel!!!", Toast.LENGTH_LONG).show();

                    if(nivel==2)
                    {
                        niv.setText("Medio");
                    }
                    else
                    {
                        niv.setText("Dificil");
                    }

                }
                else
                {
                  //  Toast.makeText(this, "Felicitaciones, no quedan mas niveles por avanzar!!!", Toast.LENGTH_LONG).show();

                }
            }




































            probando_palabra_modificada = palabra;

            Button btn_cambiar = (Button) findViewById(R.id.cambiarPalabra);
            btn_cambiar.callOnClick();
            btn_cambiar.setEnabled(true);

        }



        if(alguna_coincidencia <= 0)
        {
            cantidad_vidas = Integer.parseInt(nroVidas.getText().toString());

            switch (cantidad_vidas)
            {
                case 6:
                {
                    corto_cabeza = (TextView) findViewById(R.id.cubo17);
                    corto_cabeza.setText("O");
                    nroVidas.setText("5");
                    break;
                }
                case 5:
                {
                    corto_tronco1 = (TextView) findViewById(R.id.cubo23);
                    corto_tronco1.setText("|");
                    corto_tronco2 = (TextView) findViewById(R.id.cubo29);
                    corto_tronco2.setText("|");
                    corto_tronco3 = (TextView) findViewById(R.id.cubo35);
                    corto_tronco3.setText("|");
                    corto_tronco4 = (TextView) findViewById(R.id.cubo41);
                    corto_tronco4.setText("|");
                    nroVidas.setText("4");
                    break;
                }
                case 4:
                {
                    corto_brazoIzq = (TextView) findViewById(R.id.cubo28);
                    corto_brazoIzq.setText("/");
                    nroVidas.setText("3");
                    break;
                }
                case 3:
                {
                    corto_brazoDer = (TextView) findViewById(R.id.cubo30);
                    corto_brazoDer.setText("\\");
                    nroVidas.setText("2");
                    break;
                }
                case 2:
                {
                    corto_pieIzq = (TextView) findViewById(R.id.cubo46);
                    corto_pieIzq.setText("/");
                    nroVidas.setText("1");
                    break;
                }
                case 1:
                {
                    corto_pieDer = (TextView) findViewById(R.id.cubo48);
                    corto_pieDer.setText("\\");

                    Toast.makeText(this, "Perdiste!!!", Toast.LENGTH_LONG).show();











                    //Saco una estrella pq pierde(FEDE)
                    sacarEstrella();














                    nroVidas.setText("0");
                    //hacer un ciclo que espere y te muestre que perdiste y que tu cantidad de vidas es 0
                    nroVidas.setText("6");

                    total_coincidencias_varGlobal = 0;  //Inicializo nuevamente la variable global

                    Button btn_cambiar = (Button) findViewById(R.id.cambiarPalabra);
                    btn_cambiar.setEnabled(true);
                    btn_cambiar.callOnClick();          //Cambia de palabra, y setea todos los valores de botones, letras y vidas


                    Log.d("Palabra Original -> " , palabra);
                    Log.d("Palabra Modifi 2 -> ", probando_palabra_modificada);

                    break;

                }   //Fin Case 0


            }   //Fin Switch


        }  //FIN del If con switch



    }       //FIN del metodo "verificarExistenciaLetra()"





























    public void agregarEstrella()
    {
        ImageView e1 = (ImageView) findViewById(R.id.estrella1);
        ImageView e2 = (ImageView) findViewById(R.id.estrella2);
        ImageView e3 = (ImageView) findViewById(R.id.estrella3);
        TextView tex = (TextView) findViewById(R.id.textViewEstrellas);
        switch(puntos){
            case 1:
            {
                e1.setVisibility(View.VISIBLE);
                tex.setText("1/3");
                break;
            }
            case 2:
            {
                e1.setVisibility(View.VISIBLE);
                e2.setVisibility(View.VISIBLE);
                tex.setText("2/3");
                break;
            }
            case 3:
            {
                e3.setVisibility(View.VISIBLE);
                tex.setText("3/3");
                break;
            }
        }
    }



    public void sacarEstrella()
    {
        ImageView e1 = (ImageView) findViewById(R.id.estrella1);
        ImageView e2 = (ImageView) findViewById(R.id.estrella2);
        TextView tex = (TextView) findViewById(R.id.textViewEstrellas);

        switch(puntos)
        {

            case 1:
            {
                e1.setVisibility(View.INVISIBLE);
                tex.setText("0/3");
                break;
            }
            case 2:
            {
                e2.setVisibility(View.INVISIBLE);
                tex.setText("1/3");
                break;
            }
        }
    }



































    public void botones_visibles()
    {
        Button btn_a = (Button) findViewById(R.id.btnA);
        btn_a.setVisibility(View.VISIBLE);

        Button btn_b = (Button) findViewById(R.id.btnB);
        btn_b.setVisibility(View.VISIBLE);

        Button btn_c = (Button) findViewById(R.id.btnC);
        btn_c.setVisibility(View.VISIBLE);

        Button btn_d = (Button) findViewById(R.id.btnD);
        btn_d.setVisibility(View.VISIBLE);

        Button btn_e = (Button) findViewById(R.id.btnE);
        btn_e.setVisibility(View.VISIBLE);

        Button btn_f = (Button) findViewById(R.id.btnF);
        btn_f.setVisibility(View.VISIBLE);

        Button btn_g = (Button) findViewById(R.id.btnG);
        btn_g.setVisibility(View.VISIBLE);

        Button btn_h = (Button) findViewById(R.id.btnH);
        btn_h.setVisibility(View.VISIBLE);

        Button btn_i = (Button) findViewById(R.id.btnI);
        btn_i.setVisibility(View.VISIBLE);

        Button btn_j = (Button) findViewById(R.id.btnJ);
        btn_j.setVisibility(View.VISIBLE);

        Button btn_k = (Button) findViewById(R.id.btnK);
        btn_k.setVisibility(View.VISIBLE);

        Button btn_l = (Button) findViewById(R.id.btnL);
        btn_l.setVisibility(View.VISIBLE);

        Button btn_m = (Button) findViewById(R.id.btnM);
        btn_m.setVisibility(View.VISIBLE);

        Button btn_n = (Button) findViewById(R.id.btnN);
        btn_n.setVisibility(View.VISIBLE);

        Button btn_enie = (Button) findViewById(R.id.btnEnie);
        btn_enie.setVisibility(View.VISIBLE);

        Button btn_o = (Button) findViewById(R.id.btnO);
        btn_o.setVisibility(View.VISIBLE);

        Button btn_p = (Button) findViewById(R.id.btnP);
        btn_p.setVisibility(View.VISIBLE);

        Button btn_q = (Button) findViewById(R.id.btnQ);
        btn_q.setVisibility(View.VISIBLE);

        Button btn_r = (Button) findViewById(R.id.btnR);
        btn_r.setVisibility(View.VISIBLE);

        Button btn_s = (Button) findViewById(R.id.btnS);
        btn_s.setVisibility(View.VISIBLE);

        Button btn_t = (Button) findViewById(R.id.btnT);
        btn_t.setVisibility(View.VISIBLE);

        Button btn_u = (Button) findViewById(R.id.btnU);
        btn_u.setVisibility(View.VISIBLE);

        Button btn_v = (Button) findViewById(R.id.btnV);
        btn_v.setVisibility(View.VISIBLE);

        Button btn_w = (Button) findViewById(R.id.btnW);
        btn_w.setVisibility(View.VISIBLE);

        Button btn_x = (Button) findViewById(R.id.btnX);
        btn_x.setVisibility(View.VISIBLE);

        Button btn_y = (Button) findViewById(R.id.btnY);
        btn_y.setVisibility(View.VISIBLE);

        Button btn_z = (Button) findViewById(R.id.btnZ);
        btn_z.setVisibility(View.VISIBLE);
    }


    public void limpiar_cuerpecito()
    {
        TextView corto_cabeza = (TextView) findViewById(R.id.cubo17);
        corto_cabeza.setText("");
        TextView corto_tronco1 = (TextView) findViewById(R.id.cubo23),
                corto_tronco2 = (TextView) findViewById(R.id.cubo29),
                corto_tronco3 = (TextView) findViewById(R.id.cubo35),
                corto_tronco4 = (TextView) findViewById(R.id.cubo41);
        corto_tronco1.setText("");
        corto_tronco2.setText("");
        corto_tronco3.setText("");
        corto_tronco4.setText("");
        TextView corto_brazoIzq = (TextView) findViewById(R.id.cubo28);
        corto_brazoIzq.setText("");
        TextView corto_brazoDer = (TextView) findViewById(R.id.cubo30);
        corto_brazoDer.setText("");
        TextView corto_pieIzq = (TextView) findViewById(R.id.cubo46);
        corto_pieIzq.setText("");
        TextView corto_pieDer = (TextView) findViewById(R.id.cubo48);
        corto_pieDer.setText("");
    }



    public void usar_moneda(View v)
    {
        int ubicacion = 0;

        Log.d("Palabra Original -> ",palabra);
        Log.d("Palabra modifi 2 -> ",probando_palabra_modificada);


        for (int i = 0; i < palabra.length();i++)
        {
            if(probando_palabra_modificada.charAt(i) != '_')
            {
               ubicacion= i;
            }
        }

        TextView nroMonedas = (TextView) findViewById(R.id.textNroMonedas);
        int cantidad_mone = Integer.parseInt(nroMonedas.getText().toString());
        Button btnMoneda = (Button) findViewById(R.id.usarMoneda);

        if (cantidad_mone > 0)
        {
            verificarExistenciaLetra(palabra.charAt(ubicacion)+"");
            cantidad_mone = cantidad_mone - 1;
            if(cantidad_mone == 0)
            {
                //Poner el boton USAR MONEDA en enabled = false
                btnMoneda.setEnabled(false);
            }
            nroMonedas.setText(cantidad_mone + "");
        }
        else
        {
            Toast.makeText(this, "NO tenes mas monedas!!!", Toast.LENGTH_LONG).show();
        }


    }































    public int nivel_facil_medio_dificil_a_NRO(String ni)
    {
        int nivel =1;

        if(ni == "Facil")
            nivel = 1;
        if(ni == "Medio")
            nivel = 2;
        if(ni == "Dificil")
            nivel = 3;


        return  nivel;
    }

























    public void cambiar_palabra(View v)
    {
        Hilo_Clase hilito = new Hilo_Clase();
        hilito.execute();
    }




    private class Hilo_Clase extends AsyncTask<Void, Integer, Void>
    {
      private String pal="";


      TextView texto_nivel = (TextView) findViewById(R.id.textNivel);

      int nro_nivel =  nivel_facil_medio_dificil_a_NRO(texto_nivel.getText().toString());






        @Override
        protected void onPreExecute()
        {

                // ESTAS LINEAS IBAN CUANDO SE OBTENIAN PALABRAS DE LA BASE DE DATOS SQLITE LOCAL DEL CELULAR EMULADOR
/*
                palabra = base_datos.recuperarPalabrota(obtener_aleatorio());
                total_coincidencias_varGlobal = 0;
                letrasVisibles(palabra.length());                                       //ESTO SOLUCIONA EL PROBLEMA DE QUE NO SE VISIBILIZABAN LAS LETRAS DE ALGUNAS PALABRAS LARGAS
                probando_palabra_modificada = palabra;
*/





            Log.d("Nro de nivel -> ",nro_nivel + "");


        }


        @Override
        protected Void doInBackground(Void... params)
        {


            //Agregado para obtener la palabra del Servicio Rest
            HttpClient httpClient = new DefaultHttpClient();
            //HttpGet del = new HttpGet("http://serviciopalabras.somee.com/Api/Palabras");
            HttpGet del = new HttpGet("http://192.168.1.4:10518/Api/Palabras");               //ESTO ES PARA OBTENER PALABRAS DEL SERVICIO REST LOCAL, HECHO EN VISUAL STUDIO
            del.setHeader("content-type", "application/json");
            //Fin de lo agregado para el Servicio Rest


            try
            {


                //Agregado para obtener la palabra del Servicio Rest
                HttpResponse resp = httpClient.execute(del);
                String respStr = EntityUtils.toString(resp.getEntity());
                //JSONObject respJSON = new JSONObject(respStr);
                JSONArray jsonArrays = new JSONArray(respStr);


              //  pal = respJSON.getString("palabra");      // --> Esto lo tengo qe poner de nuevo sin comentario

                //Fin de lo agregado para el servicio Rest











                List<Palabra> lista_palabras = new ArrayList();
              //  JSONObject jsonArray= null;
               // JSONArray jsonArrays = null;

                Palabra palabrin;


                //jsonArrays = respJSON.getJSONArray("Palabras");


                //En este FOR igualo todo el JSONArray que traigo desde el servicio REST, y lo paso a una lista de objetos Palabra, y asi despues poder manipularlo mejor
                for(int i=0; i<jsonArrays.length(); i++){

                   JSONObject objetus = jsonArrays.getJSONObject(i);

                    //Todos los objetos Palabra van a tener el mismo ID, pero en realidad no me importa si se repiten los id, ya que en esta instancia no trabajo con BD, sino que trabajo palabras por Nivel, y todas las palabras que estan en el bloc de notas que sera mi JSONArray son distintas entre ellas, porque
                    //nosotros somos los que cargamos a mano las palabras, pero en realidad, en un futuro, se debera tener una BD de palabras, cada una con un ID Unique, y que se permita cargar y modificar palabras

                    //Use el constructor que agregue para que no reciba por parametro el ID de palabra, ya que no me importa en este caso.
                    palabrin = new Palabra(objetus.getString("palabra"), objetus.getInt("nivel") );

                    lista_palabras.add(palabrin);

                    Log.d("Palabra REST Nro. " + (i+1), palabrin.getPalabra());

                }




                //Nueva lista de palabras que pertenecen al nivel que se selecciono, en este caso, puse por defecto que sea nivel 2 en el if
                List<Palabra> lista_palabras_Por_Nivel = new ArrayList();
                Palabra palabra_por_nivel;




                for (int j = 0; j < lista_palabras.size(); j++)
                {



                    //Aca en vez de poner nro_monedas, va a tener que ir el TextView del nivel en que se encuentra el jugador
                    if(lista_palabras.get(j).getNivel() == nro_nivel)
                    {



                        //Creo la palabra que traigo de la lista del JSON, y la palabra a crear, es cada una de las palabras del JSONArray que pertenecen al nivel del jugador
                        palabra_por_nivel = new Palabra(lista_palabras.get(j).getPalabra(),lista_palabras.get(j).getNivel());


                        //Lleno la lista de palabras por nivel
                        lista_palabras_Por_Nivel.add(palabra_por_nivel);
                    }

                }



                int nro_random = (int) Math.floor(Math.random()*(lista_palabras_Por_Nivel.size()));


                //Esta es la linea mas importante, que setea la palabra a mosrtar por una nueva de la lista de palabras pertenecientes al nivel en el que se encuentra el jugador
                palabra = lista_palabras_Por_Nivel.get(nro_random).getPalabra();




















                //Esta linea es nueva, iguala a la variable global "palabra" con la palabra "pal" que es traida del Servicio Rest
                //palabra = pal;     // --> Esta linea la comente, pero asi tiene que ir si o si



                //Estas lineas ya estaban
                total_coincidencias_varGlobal = 0;
                probando_palabra_modificada = palabra;


            }
            catch(Exception ex)
            {
                Log.e("ServicioRest","Error!", ex);

            }



            //Esto ya estaba
            if(!isCancelled())
            {    publishProgress(1);}

            return null;
        }

        @Override
        protected void onCancelled() { super.onCancelled(); }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            //Todo esto ya estaba
            TextView nroVidas = (TextView) findViewById(R.id.textNroVidas);
            nroVidas.setText("6");
            limpiarLetras();
            letrasVisibles(palabra.length());
            botones_visibles();
            limpiar_cuerpecito();

        }


        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);


            Log.d("Palabra Original -> ", palabra);
            Log.d("Largo palabra -> ", palabra.length() + "");
            Log.d("Palabra de Servicio Web",pal);


            letrasVisibles(palabra.length());
        }

    }       // FIN de Clase AsyncTask




}
