package com.campos0022715.labosindustrial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginActivity extends AppCompatActivity {
    String user, pass;
    TextInputEditText carne;
    TextInputEditText contraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        carne= (TextInputEditText) findViewById(R.id.carne);
        contraseña = (TextInputEditText) findViewById(R.id.contraseña);
    }

    public void entrar(View view) {
        Usuario user= new Usuario(carne.getText().toString(), "Usuario X",1);

        if (carne.getText().toString().trim().equals("")) {
            carne.setError("Ingrese su carnet");
        }
        else{
            if (contraseña.getText().toString().trim().equals("")) {
                contraseña.setError("Ingrese su contraseña");
            }
            else {
                //Validar con WebService
                Intent intent = new Intent(this, AnuncioMain.class);
                intent.putExtra("usuario", user);
                startActivity(intent);
            }
        }
    }
}