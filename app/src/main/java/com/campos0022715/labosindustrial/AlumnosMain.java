package com.campos0022715.labosindustrial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;

public class AlumnosMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        RecyclerView lista= (RecyclerView) findViewById(R.id.LabosAlumnos);
        ArrayList<Laboratorio> labos = new ArrayList<>();

        //POB
        labos.add(new Laboratorio(1, "Ciencia de los Materiales","Laboratorio 01", "Lunes","13:30-15:10", "Nestor Santiago Aldana Rodriguez","L-1"));
        labos.add(new Laboratorio(2, "Mecánica de los Materiales","Laboratorio 02", "Martes", "13:30-15:10", "Nestor Santiago Aldana Rodriguez","L-2"));
        labos.add(new Laboratorio(3, "Materia X","Laboratorio 03", "Miercoles", " 13:30-15:10", "Nestor Santiago Aldana Rodriguez","L-1"));
        labos.add(new Laboratorio(4, "Ciencia de los Materiales","Laboratorio 01", "Lunes", "13:30-15:10", "Nestor Santiago Aldana Rodriguez","L-2"));
        labos.add(new Laboratorio(5, "Mecánica de los Materiales","Laboratorio 02", "Martes", "13:30-15:10", "Nestor Santiago Aldana Rodriguez","L-1"));
        labos.add(new Laboratorio(6, "Materia X","Laboratorio 03", "Miercoles", "13:30-15:10", "Nestor Santiago Aldana Rodriguez","L-2"));


        lista.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        lista.setLayoutManager(manager);
        lista.setAdapter(new Adapter(this, labos));
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
        getMenuInflater().inflate(R.menu.alumnos_main, menu);
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
            // Handle the camera action
        } else if (id == R.id.MisLabos) {

        } else if (id == R.id.Cerrar) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.Informacion) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
