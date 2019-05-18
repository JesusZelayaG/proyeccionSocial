package com.example.android_etps1.Conexion;

import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Conexion
{
    //Declaramos un objeto firebaseAuth
    private FirebaseAuth autenticacion;
    //Declaramos un objeto para la instancia
    private FirebaseDatabase instancia;
    //Declaramos un objeto para la referencia
    private DatabaseReference referencia;
    //Declaramos un objeto para el contexto donde se usaran
    private Context contexto;

    //Inicializamos el constructor
    public Conexion()
    {
        instancia = FirebaseDatabase.getInstance();
        referencia = instancia.getReference();
        autenticacion = FirebaseAuth.getInstance();
    }

    public void setAutenticacion(FirebaseAuth autenticacion)
    {
        this.autenticacion=autenticacion;
    }

    public FirebaseAuth getAutenticacion()
    {
        return autenticacion;
    }

    public void setInstancia(FirebaseDatabase instancia)
    {
        this.instancia=instancia;
    }

    public FirebaseDatabase getInstancia()
    {
        return instancia;
    }

    public void setReferencia(DatabaseReference referencia)
    {
        this.referencia=referencia;
    }

    public DatabaseReference getReferencia()
    {
        return referencia;
    }

    public void setContexto(Context conexto)
    {
        this.contexto=conexto;
    }

    public Context getContexto()
    {
        return contexto;
    }
}
