package com.example.android_etps1.Entities;
import com.example.android_etps1.Conexion.Conexion;

public class Usuarios
{
    private String id;
    private int rol;
    private String usuario;
    private  String clave;
    Conexion conexion;

    public Usuarios()
    {
        conexion = new Conexion();
    }
    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getId()
    {
        return  id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}