package com.campos0022715.labosindustrial;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Ale Campos on 25/6/2017.
 */

public class InscribirLabo extends AppCompatActivity {
    static final String NOMBRE ="nombre", HORARIO="horario", DIA="dia", SALON="salon", INSTRUCTOR="instructor", MATERIA="materia", IDL="id";
    String materia, nombre, dia, horario, salon, instructor;
    int id;
    Laboratorio labo;
    public void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_inscribir);

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

    public void clic(View view){
        Snackbar.make(view, "inscripcion exitosa", Snackbar.LENGTH_SHORT).show();
    }
}
