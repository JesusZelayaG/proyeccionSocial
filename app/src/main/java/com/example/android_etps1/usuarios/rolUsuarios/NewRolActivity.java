package com.example.android_etps1.usuarios.rolUsuarios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;

import com.example.android_etps1.R;

public class NewRolActivity extends AppCompatActivity {
    Toolbar toolbarNewRol;

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
        setContentView(R.layout.activity_new_rol);

        toolbarNewRol = findViewById(R.id.tb_new_rol);

        setSupportActionBar(toolbarNewRol);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("EDITAR ROL");
    }

    public void newRol(View btn_new_rol){
        finish();
    }
}
