package com.example.android_etps1.usuarios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
import com.google.firebase.FirebaseApp;

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
    }

    /*** Inicializamos la aplicacion y los objetos***/
    private void inicializarFirebase()
    {
        FirebaseApp.initializeApp(this);
        conexion.instancia();
        conexion.referencia();
        conexion.autenticacion();
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

            }
        }
    }

    public boolean validarCampos(Usuarios usuarios)
    {
        boolean bandera;
        if (usuarios.getUsuario().equals(""))
        {
            edt_nombre_user.setError("Ingrese su correo por favor");
            edt_nombre_user.requestFocus();
            bandera=false;
        }
        else if (usuarios.getClave().equals(""))
        {
            edt_clave_usuario.setError("Ingrese su clave por favor");
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
    /*
    private void registrarUsuario(String usuario, String clave)
    {
        this.usuario=usuario;
        this.clave=clave;
        progressDialog.setMessage("Accediendo...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(usuario,clave).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Log.d("Mensaje: ","Creacion de usuario exitosa");
                    FirebaseUser usuario = firebaseAuth.getCurrentUser();
                }
                else
                {
                    Log.w("Mensaje: ","Erro al crear el usuario",task.getException());
                    //Se hace distinta la sintaxis ya que cambia de contexto para mostrar este mensaje
                    Toast.makeText(MainActivity.this,"No se pudo registrar el usuario",Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });
    }
    */
}