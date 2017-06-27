package com.campos0022715.labosindustrial;

import java.io.Serializable;

/**
 * Created by Ale Campos on 26/6/2017.
 */

public class Nota implements Serializable {
    String actividad;
    Double calificacion;

    public Nota(String actividad, Double calificacion) {
        this.actividad = actividad;
        this.calificacion = calificacion;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }
}
