package com.example.android_etps1.facultades.facultadesClases;

import android.os.Parcel;
import android.os.Parcelable;

public class DatosRecyclerViewFac implements Parcelable {

    private String proyecto;
    private String facultad;

    public DatosRecyclerViewFac(String facultad, String proyecto) { ;
        this.facultad = facultad;
        this.proyecto = proyecto;
    }


    public String getFacultad() {

        return facultad;
    }

    public void setFacultad(String facultad)
    {
        this.facultad = facultad;
    }
    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {

        this.proyecto = proyecto;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.proyecto);
        dest.writeString(this.facultad);
    }

    protected DatosRecyclerViewFac(Parcel in) {
        this.proyecto = in.readString();
        this.facultad = in.readString();
    }

    public static final Parcelable.Creator<DatosRecyclerViewFac> CREATOR = new Parcelable.Creator<DatosRecyclerViewFac>() {
        @Override
        public DatosRecyclerViewFac createFromParcel(Parcel source) {
            return new DatosRecyclerViewFac(source);
        }

        @Override
        public DatosRecyclerViewFac[] newArray(int size) {
            return new DatosRecyclerViewFac[size];
        }
    };
}
