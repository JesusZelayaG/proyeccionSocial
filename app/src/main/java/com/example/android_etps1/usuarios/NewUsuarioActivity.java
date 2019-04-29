package com.example.android_etps1.usuarios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.android_etps1.R;

public class NewUsuarioActivity extends AppCompatActivity {

    Toolbar toolbarNewUser;
    Spinner spinnerNewUser;

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



        spinnerNewUser = findViewById(R.id.spn_usuarios);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.rol_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNewUser.setAdapter(adapter);

        setSupportActionBar(toolbarNewUser);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("NUEVO USUARIO");
    }
    public void newUser(View btn_new_user){
        finish();
    }
}
