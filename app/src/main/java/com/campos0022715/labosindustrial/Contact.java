package com.campos0022715.labosindustrial;

/**
 * Created by Josmar on 28/6/2017.
 */

public class Contact {
    int id;
    String name;
    String rol;
    String correo;
    //Constructor
    public Contact(int id, String name, String rol, String correo){
        this.id=id;
        this.name=name;
        this.rol=rol;
        this.correo=correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}