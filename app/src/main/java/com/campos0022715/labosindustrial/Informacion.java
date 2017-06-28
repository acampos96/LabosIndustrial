package com.campos0022715.labosindustrial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.concurrent.ExecutionException;

public class Informacion extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Usuario user;
    ContactAdapter adapter;
    RecyclerView reciclador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        String parametro = "contactos";
        user= (Usuario) getIntent().getSerializableExtra("usuario");
        reciclador = (RecyclerView) findViewById(R.id.lista_contactos);
        // ContactRepository listacontacto = new ContactRepository();


        try {
            new OpenData(this,adapter,reciclador, parametro).execute().get();
        }catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException f) {
            f.printStackTrace();
        }

        /*
        inflist.setHasFixedSize(true);
        LinearLayoutManager lista = new LinearLayoutManager(this);
        inflist.setLayoutManager(lista);
        inflist.setAdapter(new ContactAdapter(this, listacontacto.getList()));*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.informacion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.LabosDisp) {
            Intent intent = new Intent(this,AlumnosMain.class);
            intent.putExtra("usuario", user);
            startActivity(intent);
        } else if (id == R.id.MisLabos) {
            Intent intent = new Intent(this, MisLabos.class);
            intent.putExtra("usuario", user);
            startActivity(intent);
        } else if (id == R.id.Cerrar) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra("usuario", user);
            startActivity(intent);
        } else if (id == R.id.Personal) {
            Intent intent = new Intent(this, Informacion.class);
            intent.putExtra("usuario", user);
            startActivity(intent);
        } else if(id== R.id.AnunciosM){
            Intent intent = new Intent(this, AnuncioMain.class);
            intent.putExtra("usuario", user);
            startActivity(intent);
        } else if(id== R.id.Informacion){
            Intent intent = new Intent(this, IntroCarrera.class);
            intent.putExtra("usuario",user);
            startActivity(intent);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
