package com.campos0022715.labosindustrial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class InscripcionLabos extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    static final String NOMBRE ="nombre", HORARIO="horario", DIA="dia", SALON="salon", INSTRUCTOR="instructor", MATERIA="materia", IDL="id";
    String materia, nombre, dia, horario, salon, instructor;
    int id;
    Laboratorio labo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscripcion_labos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        materia=getIntent().getStringExtra(MATERIA);
        nombre=getIntent().getStringExtra(NOMBRE);
        dia=getIntent().getStringExtra(DIA);
        horario=getIntent().getStringExtra((HORARIO));
        salon=getIntent().getStringExtra(SALON);
        instructor=getIntent().getStringExtra(INSTRUCTOR);
        id=getIntent().getIntExtra(IDL,1);
        labo=new Laboratorio(id, materia, nombre, dia, horario, instructor, salon);
        TextView subject = (TextView) findViewById(R.id.InsMateria);
        TextView name = (TextView) findViewById(R.id.InsLabo);
        TextView day = (TextView) findViewById(R.id.InsDia);
        TextView schedule = (TextView) findViewById(R.id.InsHorario);
        TextView room = (TextView) findViewById(R.id.InsSalon);
        TextView tutor = (TextView) findViewById(R.id.InsInstructor);
        subject.setText(materia);
        name.setText(nombre);
        day.setText(dia);
        schedule.setText(horario);
        room.setText(salon);
        tutor.setText(instructor);

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
        getMenuInflater().inflate(R.menu.inscripcion_labos, menu);
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

        } else if (id == R.id.Cerrar) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.Informacion) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void clic(View view){
        Snackbar.make(view, "Inscripcion exitosa", BaseTransientBottomBar.LENGTH_SHORT).show();
    }
}