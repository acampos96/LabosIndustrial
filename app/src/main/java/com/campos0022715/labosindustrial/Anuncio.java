package com.campos0022715.labosindustrial;

import java.io.Serializable;

/**
 * Created by Ale Campos on 25/6/2017.
 */

public class Anuncio implements Serializable{
    int idAnuncio;
    String LaboXMateria;
    String Titulo, Anuncio, Materia;

    public Anuncio(int idAnuncio, String laboXMateria, String titulo, String anuncio, String materia) {
        this.idAnuncio = idAnuncio;
        this.LaboXMateria = laboXMateria;
        this.Titulo = titulo;
        this.Anuncio = anuncio;
        this.Materia=materia;

    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String materia) {
        Materia = materia;
    }

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getLaboXMateria() {
        return LaboXMateria;
    }

    public void setLaboXMateria(String laboXMateria) {
        LaboXMateria = laboXMateria;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAnuncio() {
        return Anuncio;
    }

    public void setAnuncio(String anuncio) {
        Anuncio = anuncio;
    }
}
