package com.campos0022715.labosindustrial;

/**
 * Created by Ale Campos on 25/6/2017.
 */

public class Laboratorio {
    String materia, nombre, horario, instructor;

    public Laboratorio(String materia, String nombre, String horario) {
        this.materia = materia;
        this.nombre = nombre;
        this.horario = horario;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
