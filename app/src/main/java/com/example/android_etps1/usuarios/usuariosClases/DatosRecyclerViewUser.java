package com.example.android_etps1.usuarios.usuariosClases;

public class DatosRecyclerViewUser {

    private String usuario;
    private String rol;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public DatosRecyclerViewUser(String usuario, String rol){
        this.usuario = usuario;
        this.rol = rol;
    }
}
