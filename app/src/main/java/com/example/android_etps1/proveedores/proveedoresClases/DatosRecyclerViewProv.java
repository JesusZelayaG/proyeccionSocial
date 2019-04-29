package com.example.android_etps1.proveedores.proveedoresClases;

public class DatosRecyclerViewProv {
    private String proveedor;
    private String estado;

    public DatosRecyclerViewProv(String proveedor, String estado) {
        this.proveedor = proveedor;
        this.estado = estado;
    }


    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
