package com.campos0022715.labosindustrial;

/**
 * Created by Ale Campos on 25/6/2017.
 */

public class Anuncio {
    int idAnuncio, LaboXMateria;
    String Titulo, Anuncio;

    public Anuncio(int idAnuncio, int laboXMateria, String titulo, String anuncio) {
        this.idAnuncio = idAnuncio;
        LaboXMateria = laboXMateria;
        Titulo = titulo;
        Anuncio = anuncio;
    }

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public int getLaboXMateria() {
        return LaboXMateria;
    }

    public void setLaboXMateria(int laboXMateria) {
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
