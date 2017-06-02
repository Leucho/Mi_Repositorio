package com.example.leoneldinh10.mi_ahorcado;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class jugadoresConectados extends AppCompatActivity {
    private ListView lstOpciones;
    private usuario[] datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugadores_conectados);
        lstOpciones = (ListView)findViewById(R.id.LstOpciones);

        TareaWSListar tarea = new TareaWSListar();
        tarea.execute();
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView a, View v, int position, long id) {

                //Alternativa 1:
                int idusu =
                        ((usuario)a.getItemAtPosition(position)).getId();
                String usu= ((usuario)a.getItemAtPosition(position)).getNombre();
                Intent intent =
                        new Intent(jugadoresConectados.this, MainActivity.class);


                Bundle b = new Bundle();
                b.putInt("id", idusu);
                b.putString("nombre", usu);

                //Añadimos la información al intent
                intent.putExtras(b);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

    }



    private class TareaWSListar extends AsyncTask<String,Integer,Boolean> {



        protected Boolean doInBackground(String... params) {
        usuario usu ;
            boolean resul = true;

            HttpClient httpClient = new DefaultHttpClient();

            HttpGet del =
                    new HttpGet("http://ahoracado.somee.com/api/usuario");

            del.setHeader("content-type", "application/json");

            try
            {
                HttpResponse resp = httpClient.execute(del);
                String respStr = EntityUtils.toString(resp.getEntity());

                JSONArray respJSON = new JSONArray(respStr);

                datos = new usuario[respJSON.length()];

                for(int i=0; i<respJSON.length(); i++)
                {
                    JSONObject obj = respJSON.getJSONObject(i);

                    int Id = obj.getInt("Id");
                    String nombre = obj.getString("nombre");
                    boolean online = obj.getBoolean("online");
                    usu=new usuario(Id,nombre,online);
                    datos[i]=usu;



                }
            }
            catch(Exception ex)
            {
                Log.e("ServicioRest","Error!", ex);
                resul = false;
            }

            return resul;
        }

        protected void onPostExecute(Boolean result) {

            if (result)
            {
                //Rellenamos la lista con los nombres de los clientes
                //Rellenamos la lista con los resultados
                Adaptadorusuarios adaptador =
                        new Adaptadorusuarios(jugadoresConectados.this, datos);

                lstOpciones.setAdapter(adaptador);
            }
        }
    }



    class Adaptadorusuarios extends ArrayAdapter<usuario>
    {

        public Adaptadorusuarios(Context context, usuario[] datos)
        {
            super(context, R.layout.listusu, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listusu, null);

            TextView Lblid = (TextView)item.findViewById(R.id.Lblid);
            Lblid.setText(String.valueOf(datos[position].getId()));

            TextView lblusu = (TextView)item.findViewById(R.id.LblJugador);
            lblusu.setText(datos[position].getNombre());

            return(item);
        }

    }




}
