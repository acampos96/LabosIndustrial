package com.campos0022715.labosindustrial;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by Josmar on 27/6/2017.
 */

public class OpenData extends AsyncTask<Void, Void, String> {

    AdapterAn adapter;
    RecyclerView rv;
    Usuario user;
    Adapter adapterL;
    ContactAdapter adapterC;

    static final String TAG = "LoadData";
    private Context context;

    private String response = "";
    private String parameter;

    //Arreglo de anuncios

    ArrayList<Anuncio> anuncios = new ArrayList<>();

    //Arreglo de laboratorios

    ArrayList<Laboratorio> laboratorios = new ArrayList<>();

    //Arreglo de contactos

    ArrayList<Contact> contactos = new ArrayList<>();



    //URLS para acceder a Webserver
    String ip = "192.168.100.6";
    String url_anuncios="http://"+ip+"/WebServiceProyecto/obtener_anuncios.php";
    String url_laboratorios="http://"+ip+"/WebServiceProyecto/obtener_laboratorioxmateria.php";
    String url_contactos="http://"+ip+"/WebServiceProyecto/obtener_contactos.php";

    public OpenData(){}
    //Constructor para anuncios

    public OpenData(Context c, AdapterAn adaptador,RecyclerView recycler, String condition, Usuario  user){
        context = c;
        adapter=adaptador;
        rv=recycler;
        parameter=condition;
        this.user=user;
    }
    //Constructor para laboratorios
    public OpenData(Context c, Adapter adaptador,RecyclerView recycler, String condition, Usuario  user){
        context = c;
        adapterL=adaptador;
        rv=recycler;
        parameter=condition;
        this.user=user;
    }

    //Constructor para contactos
    public OpenData(Context c, ContactAdapter adaptador,RecyclerView recycler, String condition){
        context = c;
        adapterC=adaptador;
        rv=recycler;
        parameter=condition;
        //this.user=user;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();


    }
    @Override
    protected String doInBackground(Void... params) {

        Log.d(TAG, "doInBackground:"+response+"");

        switch (parameter){
            case "anuncios":
                response = readURL(url_anuncios);
                break;
            case "labos":
                response =readURL(url_laboratorios);
                break;
            case "contactos":
                response =readURL(url_contactos);
                break;
            case "news":
                //response = enviarjuegosGET(gameName,url_news,parameter);
        }
       // pDialog.dismiss();
        return null;
    }

    @Override
    protected void onPostExecute(String content) {
        //getGameDescriptionJSON(response);

        switch (parameter){
            case "anuncios":
                getAnuncios(response);
                break;
            case "labos":
                getLaboratorios(response);
                break;
            case "contactos":
                getContacts(response);
                break;
            case "algo":
        }

    }
    //La funcion que envia el formato json
    public String enviarjuegosGET(String namegame,String url,String parameter){
        URL uri = null;
        String parametro = parameter;
        String linea ="";
        StringBuilder result = null;
        int respuesta = 0;
        Log.d(TAG, "enviarjuegosGET: Todo cool "+namegame+"");
        try {
            if (parametro.equals("news")){
                uri = new URL(url);
            }
            else {
                uri = new URL(url+namegame+"");
            }
            Log.d(TAG, "enviarjuegosGET: "+uri+"");
            HttpURLConnection httpCon = (HttpURLConnection)uri.openConnection();
            httpCon.setReadTimeout(20000);
            httpCon.setConnectTimeout(20000);
            httpCon.setDoInput(true);
            httpCon.setDoOutput(true);
            respuesta =httpCon.getResponseCode();
            result = new StringBuilder();
            if (respuesta == HttpURLConnection.HTTP_OK){
                Log.d(TAG, "enviarjuegosGET: Funciona");
                InputStream in =new BufferedInputStream(httpCon.getInputStream());
                BufferedReader read = new BufferedReader(new InputStreamReader(in));
                while ((linea=read.readLine())!=null){
                    result.append(linea);
                }
            }
        }
        catch (Exception e){

        }
        Log.d(TAG, "enviarjuegosGET:"+result.toString()+"");
        return result.toString();
    }
    //Ver si se viene vacio el json
    public int obtDatosJSON(String response){
        int res = 0;
        try {
            JSONArray json=new JSONArray(response);
            if (json.length()>0){
                res = 1;
            }
        }catch (Exception e){}
        return res;
    }

    private static String readURL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL(theUrl);
            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();
            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }


    public void  getAnuncios(String jsoncad){

        try {
            JSONObject jsonObject = new JSONObject(jsoncad);
            // JSONArray jsonArray =  jsonObject.getJSONArray("products");
            JSONArray jsonArray =  jsonObject.getJSONArray("anuncios");

            for(int i =0;i<jsonArray.length(); i++){
                JSONObject productObject = jsonArray.getJSONObject(i);
                anuncios.add(new Anuncio(
                        Integer.parseInt(productObject.getString("idAnuncio")),
                        productObject.getString("Nombre"),
                        productObject.getString("Titulo"),
                        productObject.getString("Anuncio"),
                        productObject.getString("nomMateria")
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        adapter = new AdapterAn(context,anuncios,user);
        rv.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
    }

    public void  getLaboratorios(String jsoncad){

        try {
            JSONObject jsonObject = new JSONObject(jsoncad);
            // JSONArray jsonArray =  jsonObject.getJSONArray("products");
            JSONArray jsonArray =  jsonObject.getJSONArray("labos");

            for(int i =0;i<jsonArray.length(); i++){
                JSONObject productObject = jsonArray.getJSONObject(i);
                laboratorios.add(new Laboratorio(
                        Integer.parseInt(productObject.getString("idLaboXMateria")),
                        productObject.getString("NomMateria"),
                        productObject.getString("Nombre"),
                        productObject.getString("Dia"),
                        productObject.getString("Horario"),
                        productObject.getString("NomUsuario"),
                        productObject.getString("NomLabo")
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapterL = new Adapter(context, laboratorios, user);
        rv.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapterL);
    }

    public void  getContacts(String jsoncad){

        try {
            JSONObject jsonObject = new JSONObject(jsoncad);
            // JSONArray jsonArray =  jsonObject.getJSONArray("products");
            JSONArray jsonArray =  jsonObject.getJSONArray("contactos");

            for(int i =0;i<jsonArray.length(); i++){
                JSONObject productObject = jsonArray.getJSONObject(i);
                contactos.add(new Contact(
                        Integer.parseInt(productObject.getString("idUsuario")),
                        productObject.getString("NomUsuario"),
                        productObject.getString("Tipo"),
                        productObject.getString("email")
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapterC = new ContactAdapter(context, contactos);
        rv.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapterC);
    }


}
