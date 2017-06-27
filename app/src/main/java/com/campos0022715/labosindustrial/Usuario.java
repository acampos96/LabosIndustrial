package com.campos0022715.labosindustrial;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ale Campos on 25/6/2017.
 */

public class Usuario implements Serializable{
    String idUsuario, nomUsuario;
    int tipoUsuario;
    ArrayList<Laboratorio> Laboratorios;

    public Usuario(String idUsuario, String nomUsuario, int tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nomUsuario = nomUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public ArrayList<Laboratorio> getLaboratorios() {
        return Laboratorios;
    }

    public void setLaboratorios(ArrayList<Laboratorio> laboratorios) {
        Laboratorios = laboratorios;
    }
}
