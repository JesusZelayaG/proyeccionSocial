package com.example.android_etps1.Entities;
import com.example.android_etps1.Conexion.Conexion;

public class Usuarios
{
    private String id;
    private int rol;
    private String usuario;
    private  String clave;
    Object refrenciaUsuarios;
    Conexion conexion;
    public Usuarios()
    {
        conexion = new Conexion();
        refrenciaUsuarios = conexion.refrenciaUsuarios();
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
}