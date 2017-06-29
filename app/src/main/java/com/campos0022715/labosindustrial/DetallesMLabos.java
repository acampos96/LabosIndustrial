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

public class DetallesMLabos extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Usuario user;
    static final String LABORATORIO = "laboratorio",NOMBRE ="nombre", HORARIO="horario", DIA="dia", SALON="salon", INSTRUCTOR="instructor", MATERIA="materia", IDL="id";
    int id;
    Laboratorio labo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_mlabos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        user= (Usuario) getIntent().getSerializableExtra("usuario");
        labo=(Laboratorio) getIntent().getSerializableExtra("labo");
        TextView subject = (TextView) findViewById(R.id.DeMateria);
        TextView name = (TextView) findViewById(R.id.DeLabo);
        TextView day = (TextView) findViewById(R.id.DeDia);
        TextView schedule = (TextView) findViewById(R.id.DeHorario);
        TextView room = (TextView) findViewById(R.id.DeSalon);
        TextView tutor = (TextView) findViewById(R.id.DeInstructor);
        subject.setText(labo.getMateria());
        name.setText(labo.getNombre());
        day.setText(labo.getDia());
        schedule.setText(labo.getHorario());
        room.setText(labo.getSalon());
        tutor.setText(labo.getInstructor());
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
    public void clic(View view){
        Snackbar.make(view, "Pasar a Pantalla Ver Notas", Snackbar.LENGTH_SHORT).show();
        Intent intent = new Intent(this, VerNotas.class);
        intent.putExtra("usuario", user);
        intent.putExtra("labo",labo);
        intent.putExtra(MATERIA, labo.getMateria());
        startActivity(intent);
    }
}
