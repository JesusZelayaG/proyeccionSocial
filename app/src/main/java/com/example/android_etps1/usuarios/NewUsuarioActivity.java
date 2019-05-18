package com.example.android_etps1.usuarios;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android_etps1.Conexion.Conexion;
import com.example.android_etps1.Entities.Usuarios;
import com.example.android_etps1.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class NewUsuarioActivity extends AppCompatActivity {

    Toolbar toolbarNewUser;
    Spinner spinnerNewUser,spn_usuarios,tv_rol_user;
    EditText edt_nombre_user,edt_clave_usuario;
    Button btn_new_user;
    String usuario,clave;
    int rol;

    /***Objetos***/
    ProgressBar progressBar;
    Usuarios usuarios;
    Conexion conexion;
    Context contexto;
    FirebaseAuth autenticacion;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home :
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_usuario);

        toolbarNewUser = findViewById(R.id.tb_new_user);

        edt_nombre_user = findViewById(R.id.edt_nombre_user);
        edt_clave_usuario = findViewById(R.id.edt_clave_usuario);
        btn_new_user = findViewById(R.id.btn_new_user);

        spinnerNewUser = findViewById(R.id.spn_usuarios);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.rol_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNewUser.setAdapter(adapter);

        setSupportActionBar(toolbarNewUser);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("NUEVO USUARIO");

        /*** Objetos exeternos***/
        progressBar = new ProgressBar(this);
        conexion = new Conexion();
        inicializarFirebase();
        usuarios = new Usuarios();
        contexto = getApplicationContext();
        conexion.setContexto(contexto);
        conexion.setAutenticacion(autenticacion);
    }

    /*** Inicializamos la aplicacion y los objetos***/
    private void inicializarFirebase()
    {
        FirebaseApp.initializeApp(conexion.getContexto());
        conexion.getInstancia();
        conexion.getReferencia();
        conexion.getAutenticacion();
    }


    public void newUser(View btn_new_user)
    {
        usuario = edt_nombre_user.getText().toString().trim();
        clave = edt_clave_usuario.getText().toString().trim();
        usuarios.setUsuario(usuario);
        usuarios.setClave(clave);
        if (validarCampos(usuarios))
        {
            if (validarEmail(usuarios))
            {
                registrarUsuario(usuarios.getUsuario(),usuarios.getClave());
            }
            else
            {
                edt_nombre_user.setError("Email no valido");
                edt_nombre_user.requestFocus();
            }
        }
    }

    public boolean validarCampos(Usuarios usuarios)
    {
        boolean bandera;
        if (usuarios.getUsuario().equals(""))
        {
            edt_nombre_user.setError("Ingrese correo por favor");
            edt_nombre_user.requestFocus();
            bandera=false;
        }
        else if (usuarios.getClave().equals(""))
        {
            edt_clave_usuario.setError("Ingrese clave por favor");
            edt_clave_usuario.requestFocus();
            bandera=false;
        }
        else
        {
            bandera=true;
        }
        return  bandera;
    }

    public boolean validarEmail(Usuarios usuarios)
    {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(usuarios.getUsuario()).matches();
    }

    /**** ES PARA REGISTRAR USUARIO ****/
    private void registrarUsuario(String usuario, String clave)
    {
        this.usuario=usuario;
        this.clave=clave;
         conexion.getAutenticacion().createUserWithEmailAndPassword(usuario,clave)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Log.d("Mensaje: ","Creacion de usuario exitosa");
                    FirebaseUser usuario = conexion.getAutenticacion().getCurrentUser();
                    String user=usuario.getEmail();
                    Toast.makeText(conexion.getContexto(),"Usuario creado: "+user,Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException)
                    {
                        Toast.makeText(conexion.getContexto(), "Ese usuario ya existe", Toast.LENGTH_LONG).show();
                        Log.w("Mensaje: ","Error al crear el usuario porque ya existe",task.getException());
                    }
                    else
                    {
                        Log.w("Mensaje: ","Error al crear el usuario",task.getException());
                        //Se hace distinta la sintaxis ya que cambia de contexto para mostrar este mensaje
                        Toast.makeText(conexion.getContexto(),"No se pudo registrar el usuario",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}