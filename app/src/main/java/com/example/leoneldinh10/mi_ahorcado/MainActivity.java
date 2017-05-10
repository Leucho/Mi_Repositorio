package com.example.leoneldinh10.mi_ahorcado;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.leoneldinh10.mi_ahorcado.Acceso_Base_Datos.BD_OpenHelper;




import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;







public class MainActivity extends AppCompatActivity {


    private String palabra = "";
    private int total_coincidencias_varGlobal=0;
    private BD_OpenHelper base_datos;
    private String probando_palabra_modificada="";




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

        Log.d("Palabra BD -> ", palabra);

        probando_palabra_modificada = palabra;


        limpiarLetras();
        letrasVisibles(palabra.length());

        Log.d("Palabra Original -> ", palabra);
        Log.d("Largo palabra orig -> ", palabra.length() + "");


        verificar_diccionario_letras_BD();
    }



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
            Log.d("Palabra Nro.  " + i + " --> ",base_datos.recuperarPalabrota(i));
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


    public void cambiar_palabra(View v)
    {
        Hilo_Clase hilito = new Hilo_Clase();
        hilito.execute();
    }




    private class Hilo_Clase extends AsyncTask<Void, Integer, Void>
    {
      private String pal="";

        @Override
        protected void onPreExecute()
        {

            /*
                - ESTAS LINEAS IBAN CUANDO SE OBTENIAN PALABRAS DE LA BASE DE DATOS SQLITE LOCAL DEL CELULAR EMULADOR

                palabra = base_datos.recuperarPalabrota(obtener_aleatorio());
                total_coincidencias_varGlobal = 0;
                letrasVisibles(palabra.length());                                       //ESTO SOLUCIONA EL PROBLEMA DE QUE NO SE VISIBILIZABAN LAS LETRAS DE ALGUNAS PALABRAS LARGAS
                probando_palabra_modificada = palabra;
            */
        }


        @Override
        protected Void doInBackground(Void... params)
        {

            //Agregado para obtener la palabra del Servicio Rest
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet del = new HttpGet("http://serviciopalabras.somee.com/Api/Palabras");
            //HttpGet del = new HttpGet("http://192.168.1.6:10518/Api/Palabras");               //ESTO ES PARA OBTENER PALABRAS DEL SERVICIO REST LOCAL, HECHO EN VISUAL STUDIO
            del.setHeader("content-type", "application/json");
            //Fin de lo agregado para el Servicio Rest


            try
            {
                //Agregado para obtener la palabra del Servicio Rest
                HttpResponse resp = httpClient.execute(del);
                String respStr = EntityUtils.toString(resp.getEntity());
                JSONObject respJSON = new JSONObject(respStr);
                pal = respJSON.getString("palabra");
                //Fin de lo agregado para el servicio Rest


                //Esta linea es nueva, iguala a la variable global "palabra" con la palabra "pal" que es traida del Servicio Rest
                palabra = pal;


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
