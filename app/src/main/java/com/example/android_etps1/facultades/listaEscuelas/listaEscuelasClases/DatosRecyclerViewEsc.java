package com.example.android_etps1.facultades.listaEscuelas.listaEscuelasClases;

import android.os.Parcel;
import android.os.Parcelable;

public class DatosRecyclerViewEsc{

    private String escuela;
    private String proyecto;

    public DatosRecyclerViewEsc(String escuela, String proyecto) {
        this.escuela = escuela;
        this.proyecto = proyecto;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }






}
