package com.example.android_etps1.index;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_etps1.Controllers.LoginController;
import com.example.android_etps1.Entities.Usuarios;
import com.example.android_etps1.R;
import com.example.android_etps1.index.HomeActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtUsuario, edtClave;
    Button btn_ingresar;

    String usuario, clave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsuario = findViewById(R.id.edt_usuario);
        edtClave = findViewById(R.id.edt_clave);
        btn_ingresar = findViewById(R.id.btn_ingresar);
        LoginController login = new LoginController();

    }

    public void ingresarApp(View btn_ingresar)
    {
        usuario = edtUsuario.getText().toString().trim();
        clave = edtClave.getText().toString().trim();
        Toast.makeText(getApplicationContext(),"Usuario: "+usuario+" Clave: "+clave,Toast.LENGTH_LONG).show();
        /*
        Intent obj = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(obj);
        */
    }
}
