package com.example.android_etps1.index;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.example.android_etps1.R;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    EditText editTextMail, editTextPassword;
    String mail, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        editTextMail = findViewById(R.id.edt_mail);
        editTextPassword = findViewById(R.id.edt_clave);
    }

    public void ingresarApp(View btn_ingresar){

        mail = editTextMail.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(mail)){
            editTextMail.setError("Campo no puede estar vacío");
            editTextMail.requestFocus();
        }else if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            editTextMail.setError("Formato invalido");
            editTextMail.requestFocus();

        }
        else if(TextUtils.isEmpty(password)){
            editTextPassword.setError("Campo no puede estar vacío");
            editTextPassword.requestFocus();
        }
        else {
            
            Intent obj = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(obj);
        }

    }
}
