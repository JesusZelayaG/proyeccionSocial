package com.example.android_etps1.index;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.android_etps1.Conexion.Conexion;
import com.example.android_etps1.Entities.Usuarios;
import com.example.android_etps1.R;
import com.example.android_etps1.index.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;

import com.google.firebase.auth.FirebaseUser;
import java.util.regex.Pattern;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    EditText edt_usuario, edt_clave;
    Button btn_ingresar;
    String usuario, clave;
    /***Objetos***/

    ProgressBar progressBar;
    Usuarios usuarios;
    Conexion conexion;
    Context contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_usuario = findViewById(R.id.edt_usuario);
        edt_clave = findViewById(R.id.edt_clave);
        btn_ingresar = findViewById(R.id.btn_ingresar);
        /*** Objetos exeternos***/
        progressBar = new ProgressBar(this);
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

    public void ingresarApp(View btn_ingresar)
    {
        usuario = edt_usuario.getText().toString().trim();
        clave = edt_clave.getText().toString().trim();
        usuarios.setUsuario(usuario);
        usuarios.setClave(clave);
        if (validarCampos(usuarios))
        {
            if (validarEmail(usuarios))
            {
                iniciarSesion(usuarios);
                //registrarUsuario(usuario,clave);
            }
            else
            {
                edt_usuario.setError("Email no valido");
                edt_usuario.requestFocus();
            }
        }
    }

    public boolean validarEmail(Usuarios usuarios)
    {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(usuarios.getUsuario()).matches();
    }

    public boolean validarCampos(Usuarios usuarios)
    {
        boolean bandera;
        if (usuarios.getUsuario().equals(""))
        {
            edt_usuario.setError("Ingrese su correo por favor");
            edt_usuario.requestFocus();
            bandera=false;
        }
        else if (usuarios.getClave().equals(""))
        {
            edt_clave.setError("Ingrese su clave por favor");
            edt_clave.requestFocus();
            bandera=false;
        }
        else
        {
            bandera=true;
        }
        return  bandera;
    }

    private void iniciarSesion(Usuarios usuarios)
    {
        Log.d("Mensaje: ", "Inicio sesion:" + usuarios.getUsuario());
        progressBar.setVisibility(View.VISIBLE);
        // [START sign_in_with_email]
        conexion.getAutenticacion().signInWithEmailAndPassword(usuarios.getUsuario(), usuarios.getClave())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            // Si existe el usuario, Iniciamos la siguiente actividad
                            Log.d("Mensaje", "Inicio sesion correctamente");
                            String id = conexion.getAutenticacion().getUid();
                            Intent obj = new Intent(getApplicationContext(), HomeActivity.class);
                            obj.putExtra("usuario",usuario);
                            obj.putExtra("id",id);
                            startActivity(obj);
                            limpiar();
                        }
                        else
                        {
                            // Sino existe el usuario, le mostramos un mensaje de error
                            Log.w("Mensaje: ", "No se puede iniciar sesion", task.getException());
                            Toast.makeText(MainActivity.this, "Autenticacion fallida, usuario o clave incorrectas.", Toast.LENGTH_SHORT).show();
                            edt_usuario.setError("Error de credenciales, el usuario no existe");
                            edt_usuario.requestFocus();
                            limpiar();
                        }
                    }
                });
        progressBar.setVisibility(View.INVISIBLE);
        // [END sign_in_with_email]
    }

    public void limpiar()
    {
        edt_usuario.setText("");
        edt_clave.setText("");
    }
}
