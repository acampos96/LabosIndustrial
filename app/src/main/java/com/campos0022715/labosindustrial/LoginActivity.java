package com.campos0022715.labosindustrial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {
    String user, pass;
    TextInputEditText carne;
    TextInputEditText contraseña;
    Usuario a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        carne= (TextInputEditText) findViewById(R.id.carne);
        contraseña = (TextInputEditText) findViewById(R.id.contraseña);
    }

    public void entrar(View view) {


        if (carne.getText().toString().trim().equals("")) {
            carne.setError("Ingrese su carnet");
        }
        else{
            if (contraseña.getText().toString().trim().equals("")) {
                contraseña.setError("Ingrese su contraseña");
            }
            else {
                //Validar con WebService
                //Intent intent = new Intent(this, AnuncioMain.class);
                //intent.putExtra("usuario", user);
                //startActivity(intent);

                Thread tr = new Thread(){
                    @Override
                    public void run() {
                        final String resultado = enviarDatosGET(carne.getText().toString(),contraseña.getText().toString());

                        //final String resultado = enviarDatosGET("usuario1","12345");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                int r = obtenerDatosJSON(resultado);
                                if(r>0){
                                    //Usuario user= new Usuario(carne.getText().toString(), "Usuario X",1);
                                    Usuario user= llenarDatosJSON(resultado);
                                    System.out.println(user.getIdUsuario()+user.getNomUsuario()+user.getTipoUsuario());
                                    Log.d("LoadData", user.getIdUsuario()+user.getNomUsuario()+user.getTipoUsuario());
                                    Intent i = new Intent(getApplicationContext(),AnuncioMain.class);
                                    //i.putExtra("cod",txtUser.getText().toString());
                                    Toast.makeText(getApplicationContext(),"Bienvenido",Toast.LENGTH_LONG).show();
                                    i.putExtra("usuario", user);
                                    startActivity(i);
                                }else{
                                    Toast.makeText(getApplicationContext(),"Datos incorrectos",Toast.LENGTH_LONG).show();

                                }
                            }
                        });
                    }
                };
                tr.start();




            }
        }
    }



    public String enviarDatosGET(String user, String pass){
        URL url=null;
        String linea="";
        int respuesta=0;
        StringBuilder resul= null;

        try {
            url = new URL("http://192.168.1.4/WebServiceProyecto/validar.php?usu="+user+"&pas="+pass);
            HttpURLConnection conection=(HttpURLConnection)url.openConnection();
            respuesta=conection.getResponseCode();

            resul = new StringBuilder();

            if(respuesta==HttpURLConnection.HTTP_OK){
                InputStream in=new BufferedInputStream(conection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while ((linea=reader.readLine())!=null){
                    resul.append(linea);
                }
            }
        } catch (Exception e) {
        }
        return resul.toString();
    }

    public int obtenerDatosJSON(String response){
        int res=0;
        try {
            //JSONObject jsonObject = new JSONObject(response);
            // JSONArray jsonArray =  jsonObject.getJSONArray("products");
            //JSONArray jsonArray =  jsonObject.getJSONArray("usuario");
            JSONArray json =new JSONArray(response);
            if(json.length()>0){
                res=1;
            }

        }catch (Exception e){}
        return res;
    }

    public Usuario llenarDatosJSON(String response){


        try {
            //JSONObject jsonObject = new JSONObject(response);
            //JSONArray jsonArray =  jsonObject.getJSONArray("usuario");
            JSONArray jsonArray =new JSONArray(response);
            JSONObject productObject = jsonArray.getJSONObject(0);
            a = new Usuario(productObject.getString("idUsuario"),productObject.getString("NomUsuario"),
                    Integer.parseInt(productObject.getString("TipoUsuario")));

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return a;
    }
}