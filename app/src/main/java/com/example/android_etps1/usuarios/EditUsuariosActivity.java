package com.example.android_etps1.usuarios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.support.v7.widget.Toolbar;

import com.example.android_etps1.R;

public class EditUsuariosActivity extends AppCompatActivity {

    Spinner spinnerEditUser;
    Toolbar toolbarEditUser;

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
        setContentView(R.layout.activity_edit_usuarios);

        spinnerEditUser = findViewById(R.id.spn_usuarios);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.rol_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEditUser.setAdapter(adapter);

        toolbarEditUser = findViewById(R.id.tb_edit_user);

        setSupportActionBar(toolbarEditUser);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("EDITAR USUARIO");
    }

    public void editUser(View btn_edit_user){
        finish();
    }
}
