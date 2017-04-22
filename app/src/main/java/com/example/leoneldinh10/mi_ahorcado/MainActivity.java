package com.example.leoneldinh10.mi_ahorcado;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    String palabra = "arquitectura";
    int total_coincidencias_varGlobal=0;

    char palabra_modificada[]=palabra.toCharArray();

//cambio para probar
    int posicion_primer_letra_vacia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        limpiarLetras();
        letrasVisibles();
    }




    public void limpiarLetras()
    {
        TextView letra = (TextView) findViewById(R.id.letra1);
        letra.setText("____");
        TextView letra2 = (TextView) findViewById(R.id.letra2);
        letra2.setText("_____");
        TextView letra3 = (TextView) findViewById(R.id.letra3);
        letra3.setText("_____");
        TextView letra4 = (TextView) findViewById(R.id.letra4);
        letra4.setText("_____");
        TextView letra5 = (TextView) findViewById(R.id.letra5);
        letra5.setText("_____");
        TextView letra6 = (TextView) findViewById(R.id.letra6);
        letra6.setText("_____");
        TextView letra7 = (TextView) findViewById(R.id.letra7);
        letra7.setText("_____");
        TextView letra8 = (TextView) findViewById(R.id.letra8);
        letra8.setText("_____");
        TextView letra9 = (TextView) findViewById(R.id.letra9);
        letra9.setText("_____");
        TextView letra10 = (TextView) findViewById(R.id.letra10);
        letra10.setText("_____");
        TextView letra11 = (TextView) findViewById(R.id.letra11);
        letra11.setText("_____");
        TextView letra12 = (TextView) findViewById(R.id.letra12);
        letra12.setText("_____");
        TextView letra13 = (TextView) findViewById(R.id.letra13);
        letra13.setText("_____");
        TextView letra14 = (TextView) findViewById(R.id.letra14);
        letra14.setText("_____");
        //}

    }



    public int cantidadLetras(String pala)
    {
        int cant = pala.length();
        return cant;
    }



    public void letrasVisibles()
    {
        int cant_letras = cantidadLetras(palabra);


      switch (cant_letras)
        {
            case 3:
            {
                TextView letra = (TextView) findViewById(R.id.letra1);
                letra.setCursorVisible(true);
                TextView letra2 = (TextView) findViewById(R.id.letra2);
                letra2.setCursorVisible(true);
                TextView letra3 = (TextView) findViewById(R.id.letra3);
                letra3.setCursorVisible(true);
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
                TextView letra = (TextView) findViewById(R.id.letra1);
                letra.setCursorVisible(true);
                TextView letra2 = (TextView) findViewById(R.id.letra2);
                letra2.setCursorVisible(true);
                TextView letra3 = (TextView) findViewById(R.id.letra3);
                letra3.setCursorVisible(true);
                TextView letra4 = (TextView) findViewById(R.id.letra4);
                letra4.setCursorVisible(true);
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
                letra12.setVisibility(View.INVISIBLE);
                TextView letra13 = (TextView) findViewById(R.id.letra13);
                letra13.setVisibility(View.INVISIBLE);
                TextView letra14 = (TextView) findViewById(R.id.letra14);
                letra14.setVisibility(View.INVISIBLE);
                break;
            }


            case 12:
            {
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
                letra13.setVisibility(View.INVISIBLE);
                TextView letra14 = (TextView) findViewById(R.id.letra14);
                letra14.setVisibility(View.INVISIBLE);
                break;
            }


            case 13:
            {
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



    public void existe_A(View a)
    {
        verificarExistenciaLetra("a");
        a.setVisibility(View.INVISIBLE);
    }
    public void existe_B(View b)
    {
        verificarExistenciaLetra("b");
        b.setVisibility(View.INVISIBLE);
    }
    public void existe_C(View c)
    {
        verificarExistenciaLetra("c");
        c.setVisibility(View.INVISIBLE);
    }
    public void existe_D(View d)
    {
        verificarExistenciaLetra("d");
        d.setVisibility(View.INVISIBLE);
    }
    public void existe_E(View e)
    {
        verificarExistenciaLetra("e");
        e.setVisibility(View.INVISIBLE);
    }
    public void existe_F(View f)
    {
        verificarExistenciaLetra("f");
        f.setVisibility(View.INVISIBLE);
    }
    public void existe_G(View g)
    {
        verificarExistenciaLetra("g");
        g.setVisibility(View.INVISIBLE);
    }
    public void existe_H(View h)
    {
        verificarExistenciaLetra("h");
        h.setVisibility(View.INVISIBLE);
    }
    public void existe_I(View i)
    {
        verificarExistenciaLetra("i");
        i.setVisibility(View.INVISIBLE);
    }
    public void existe_J(View j)
    {
        verificarExistenciaLetra("j");
        j.setVisibility(View.INVISIBLE);
    }
    public void existe_K(View k)
    {
        verificarExistenciaLetra("k");
        k.setVisibility(View.INVISIBLE);
    }
    public void existe_L(View l)
    {
        verificarExistenciaLetra("l");
        l.setVisibility(View.INVISIBLE);
    }
    public void existe_M(View m)
    {
        verificarExistenciaLetra("m");
        m.setVisibility(View.INVISIBLE);
    }
    public void existe_N(View n)
    {
        verificarExistenciaLetra("n");
        n.setVisibility(View.INVISIBLE);
    }
    public void existe_Enie(View n)
    {
        verificarExistenciaLetra("ñ");
        n.setVisibility(View.INVISIBLE);
    }
    public void existe_O(View o)
    {
        verificarExistenciaLetra("o");
        o.setVisibility(View.INVISIBLE);
    }
    public void existe_P(View p)
    {
        verificarExistenciaLetra("p");
        p.setVisibility(View.INVISIBLE);
    }
    public void existe_Q(View q)
    {
        verificarExistenciaLetra("q");
        q.setVisibility(View.INVISIBLE);
    }
    public void existe_R(View r)
    {
        verificarExistenciaLetra("r");
        r.setVisibility(View.INVISIBLE);
    }
    public void existe_S(View s)
    {
        verificarExistenciaLetra("s");
        s.setVisibility(View.INVISIBLE);
    }
    public void existe_T(View t)
    {
        verificarExistenciaLetra("t");
        t.setVisibility(View.INVISIBLE);
    }
    public void existe_U(View u)
    {
        verificarExistenciaLetra("u");
        u.setVisibility(View.INVISIBLE);
    }
    public void existe_V(View v)
    {
        verificarExistenciaLetra("v");
        v.setVisibility(View.INVISIBLE);
    }
    public void existe_W(View w)
    {
        verificarExistenciaLetra("w");
        w.setVisibility(View.INVISIBLE);
    }
    public void existe_X(View x)
    {
        verificarExistenciaLetra("x");
        x.setVisibility(View.INVISIBLE);
    }
    public void existe_Y(View y)
    {
        verificarExistenciaLetra("Y");
        y.setVisibility(View.INVISIBLE);
    }
    public void existe_Z(View z)
    {
        verificarExistenciaLetra("Z");
        z.setVisibility(View.INVISIBLE);
    }




    public void verificarExistenciaLetra(String v)
    {
        char letra_caracter;
        TextView letra_view;

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

               palabra_modificada[i] = '_';

            }





        }   //FIN ciclo for

        if(total_coincidencias_varGlobal == cantidadLetras(palabra))
        {

            Toast.makeText(this, "GANASTE Pollito", Toast.LENGTH_LONG).show();
            cantidad_monedas = Integer.parseInt(nroMonedas.getText().toString());
            cantidad_monedas++;
            nroMonedas.setText(cantidad_monedas + "");

            limpiarLetras();            //Limpia las letras de la palabra
            limpiar_cuerpecito();       //Limpia el dibujo del ahorcado
            nroVidas.setText("6");
            botones_visibles();      //Botones apretados de abecedario pasan a ser visibles
            total_coincidencias_varGlobal = 0;      //Se inicializa de nuevo la variable global creada


            palabra_modificada = palabra.toCharArray(); //NUeva linea agregada en casa del Fede -> Porque una vez qe gana, no funciona bien el USAR MONEDA

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

                    mensajePerdiste();

                    nroVidas.setText("0");
                    limpiar_cuerpecito();
                    limpiarLetras();

                    nroVidas.setText("6");

                    total_coincidencias_varGlobal = 0;  //Inicializo nuevamente la variable global

                    botones_visibles();

                    break;


                }   //Fin Case


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
//esto es un comentario
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



    public void mensajePerdiste()
    {
        Toast.makeText(this, "Perdiste Pollito", Toast.LENGTH_LONG).show();

        palabra_modificada = palabra.toCharArray();  // Agregada linea en la casa del FEDE 21-4-2017
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

        for (int i = 0; i < palabra.length();i++)
        {
            if(palabra_modificada[i] != '_')
            {
               ubicacion= i;
            }
        }

        TextView nroMonedas = (TextView) findViewById(R.id.textNroMonedas);
        int cantidad_mone = Integer.parseInt(nroMonedas.getText().toString());

        if (cantidad_mone > 0)
        {
            verificarExistenciaLetra(palabra.charAt(ubicacion)+"");
            cantidad_mone = cantidad_mone - 1;
            if(cantidad_mone == 0)
            {
                //POner el boton USAR MONEDA en enabled = false
            }
            nroMonedas.setText(cantidad_mone + "");
        }
        else
        {
            Toast.makeText(this, "NO tenes monedas Pollito", Toast.LENGTH_LONG).show();
        }


    }




    public void cambiar_palabra(View v)
    {
        botones_visibles();
    }




    /*
    CLASE DE ADS 21/04/2017
    Vimos los Unit Test     --- > Se hace sobre la minima unidad de testing, es decir sobre los metodos, y lo que se debe hacer es eliminar
                                todas las dependencias del metodos a los metodos externos al de testing
                                El Profe uso la libreria MOQ para hacer los Unit Test en .NET
    Va atener cuatro partes :
                        Arrange - >
                        Act     - >
                        Assert  - >

     */







}
