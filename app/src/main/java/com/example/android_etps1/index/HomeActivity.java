package com.example.android_etps1.index;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android_etps1.Conexion.Conexion;
import com.example.android_etps1.Entities.Usuarios;
import com.example.android_etps1.R;
import com.example.android_etps1.descripciones.DescripcionesActivity;
import com.example.android_etps1.facultades.FacultadesActivity;
import com.example.android_etps1.perfiles.PerfilesActivity;
import com.example.android_etps1.proveedores.ProveedoresActivity;
import com.example.android_etps1.usuarios.UsuariosActivity;
import com.example.android_etps1.vehiculos.VehiculosActivity;
import com.google.firebase.FirebaseApp;

public class HomeActivity extends AppCompatActivity {

    Conexion conexion;
    Usuarios usuarios;
    String usuario,id;

    Context contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Bundle datosLogin = getIntent().getExtras();

        conexion = new Conexion();
        usuarios = new Usuarios();
        contexto = getApplicationContext();
        conexion.setContexto(contexto);
        inicializarFirebase();
    }

    /*** Inicializamos la aplicacion y los objetos***/
    private void inicializarFirebase()
    {
        FirebaseApp.initializeApp(conexion.getContexto());
        conexion.getInstancia();
        conexion.getReferencia();
        conexion.getAutenticacion();
    }

    public void buttonFacultades(View btn_facultades){
        Intent next = new Intent(getApplicationContext(), FacultadesActivity.class);
        startActivity(next);
    }

    public void buttonProveedores(View btn_proveedores){
        Intent next = new Intent(getApplicationContext(), ProveedoresActivity.class);
        startActivity(next);
    }

    public void buttonDescripciones(View btn_descripciones){
        Intent next = new Intent(getApplicationContext(), DescripcionesActivity.class);
        startActivity(next);
    }

    public void buttonVehiculos (View btn_vehiculos){
        Intent next = new Intent(getApplicationContext(), VehiculosActivity.class);
        startActivity(next);
    }

    public void buttonPerfiles (View btn_perfiles){
        Intent next = new Intent(getApplicationContext(), PerfilesActivity.class);
        startActivity(next);
    }

    public void buttonUsuarios (View btn_usuarios){
        Intent next = new Intent(getApplicationContext(), UsuariosActivity.class);
        startActivity(next);
    }

    public void buttonCerrar(View btn_cerrar)
    {
        conexion.getAutenticacion().signOut();
        finish();
    }
}
