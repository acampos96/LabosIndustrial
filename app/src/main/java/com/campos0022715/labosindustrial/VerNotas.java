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
import android.widget.TextView;

import java.util.ArrayList;

public class VerNotas extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String subject, lab;
    static final String LABO="laboratorio", MATERIA="materia";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_notas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        TextView laboratorio = (TextView) findViewById(R.id.NotaLabo);
        TextView materia = (TextView) findViewById(R.id.NotaMateria);
        lab=getIntent().getStringExtra(LABO);
        subject=getIntent().getStringExtra(MATERIA);
        laboratorio.setText(lab);
        materia.setText(subject);
        RecyclerView lista = (RecyclerView) findViewById(R.id.NotasLista);
        ArrayList<Nota> arreglo= new ArrayList<>();
        arreglo.add(new Nota("Nota 1", 9.56));
        arreglo.add(new Nota("Nota 2", 6.25));
        arreglo.add(new Nota("Nota 3", 4.7));
        arreglo.add(new Nota("Nota 4", 7.5));
        arreglo.add(new Nota("Nota Final", (9.56+6.25+4.7+7.5)/4));
        lista.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        lista.setLayoutManager(manager);
        lista.setAdapter(new AdapterNts(this, arreglo));
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
        getMenuInflater().inflate(R.menu.ver_notas, menu);
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
            startActivity(intent);
        } else if (id == R.id.MisLabos) {
            Intent intent = new Intent(this, MisLabos.class);
            startActivity(intent);
        } else if (id == R.id.Cerrar) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.Personal) {
            Intent intent = new Intent(this, Informacion.class);
            startActivity(intent);
        } else if(id== R.id.AnunciosM){
            Intent intent = new Intent(this, AnuncioMain.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
