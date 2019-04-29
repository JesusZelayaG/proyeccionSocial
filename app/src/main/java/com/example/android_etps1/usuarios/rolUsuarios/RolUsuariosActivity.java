package com.example.android_etps1.usuarios.rolUsuarios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android_etps1.R;
import com.example.android_etps1.usuarios.rolUsuarios.rolUsuariosClases.AdapterRolRecyclerView;
import com.example.android_etps1.usuarios.rolUsuarios.rolUsuariosClases.DatosRecyclerViewRol;

import java.util.ArrayList;

public class RolUsuariosActivity extends AppCompatActivity {

    Toolbar toolBarRol;
    RecyclerView recyclerViewRol;
    ArrayList<DatosRecyclerViewRol> listDatos;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_rol, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.new_rol:
                Intent next = new Intent(getApplicationContext(), NewRolActivity.class);
                startActivity(next);
                break;
            case android.R.id.home:
                finish();
                break;

        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rol_usuarios);

        toolBarRol = findViewById(R.id.tb_rol);
        recyclerViewRol = findViewById(R.id.rv_rol);

        setSupportActionBar(toolBarRol);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("LISTA DE ROLES");
        listDatos = new ArrayList<>();
        recyclerViewRol.setLayoutManager(new LinearLayoutManager(this));

        fillRecyclerView();
        AdapterRolRecyclerView adapter = new AdapterRolRecyclerView(listDatos);
        recyclerViewRol.setAdapter(adapter);
        recyclerViewRol.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

    private void fillRecyclerView() {
        listDatos.add(new DatosRecyclerViewRol("ADMINISTRADOR"));
        listDatos.add(new DatosRecyclerViewRol("COLABORADOR"));

    }

}

