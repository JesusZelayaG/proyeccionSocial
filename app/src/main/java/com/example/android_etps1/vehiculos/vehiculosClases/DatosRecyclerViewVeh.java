package com.example.android_etps1.vehiculos.vehiculosClases;

public class DatosRecyclerViewVeh {
    private String vehiculo;
    private String precio;

    public DatosRecyclerViewVeh(String vehiculo, String precio) { ;
        this.vehiculo = vehiculo;
        this.precio = precio;
    }


    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }
    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}


