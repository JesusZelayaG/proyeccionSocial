package com.example.android_etps1.Conexion;

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

    //Inicializamos el constructor
    public Conexion()
    {
        instancia = FirebaseDatabase.getInstance();
        referencia = instancia.getReference();
        autenticacion = FirebaseAuth.getInstance();
    }

    public FirebaseAuth autenticacion()
    {
        return autenticacion;
    }

    public FirebaseDatabase instancia()
    {
        return instancia;
    }

    public DatabaseReference referencia()
    {
        return referencia;
    }
}
