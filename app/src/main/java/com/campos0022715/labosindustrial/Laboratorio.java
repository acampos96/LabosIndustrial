package com.campos0022715.labosindustrial;

import java.io.Serializable;

/**
 * Created by Ale Campos on 25/6/2017.
 */

public class Laboratorio implements Serializable{
    int idLaboXMateria;
    String nombre, materia, dia, horario, instructor, salon;

    public Laboratorio(int idLaboXMateria, String materia, String nombre, String dia, String horario, String instructor, String salon) {
        this.idLaboXMateria = idLaboXMateria;
        this.nombre = nombre;
        this.materia = materia;
        this.dia=dia;
        this.horario = horario;
        this.instructor = instructor;
        this.salon = salon;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getIdLaboXMateria() {
        return idLaboXMateria;
    }

    public void setIdLaboXMateria(int idLaboXMateria) {
        this.idLaboXMateria = idLaboXMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
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

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }
}