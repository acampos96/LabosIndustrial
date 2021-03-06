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

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MisLabos extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Usuario user;

    AdapterML adapter;
    RecyclerView reciclador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_labos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        String parametro = "mislabos";
        user= (Usuario) getIntent().getSerializableExtra("usuario");
        reciclador= (RecyclerView) findViewById(R.id.MisLabosAlumnos);

        try {
            new OpenData(this,adapter,reciclador, parametro, user, user.getIdUsuario().toString()).execute().get();
        }catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException f) {
            f.printStackTrace();
        }
        /*



        ArrayList<Laboratorio> labos = new ArrayList<>();

        //POB
        labos.add(new Laboratorio(1, "Ciencia de los Materiales","Laboratorio 01", "Lunes","13:30-15:10", "Nestor Santiago Aldana Rodriguez","L-1"));
        labos.add(new Laboratorio(6, "Materia X","Laboratorio 03", "Miercoles", "13:30-15:10", "Nestor Santiago Aldana Rodriguez","L-2"));


        lista.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        lista.setLayoutManager(manager);
        lista.setAdapter(new AdapterML(this, labos, user));*/
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
