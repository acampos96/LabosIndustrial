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

    public void entrar(View view){
        user=carne.getText().toString();
        pass=contraseña.getText().toString();
        //Validar con WebService
        Intent intent= new Intent(this,AlumnosMain.class);
        startActivity(intent);
    }
}