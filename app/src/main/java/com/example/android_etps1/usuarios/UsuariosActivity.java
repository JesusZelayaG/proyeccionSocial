package com.example.android_etps1.usuarios;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import com.example.android_etps1.R;
import com.example.android_etps1.usuarios.listaPersonas.ListaPersonasActivity;
import com.example.android_etps1.usuarios.rolUsuarios.RolUsuariosActivity;
import com.example.android_etps1.usuarios.usuariosClases.AdapterUserRecyclerView;
import com.example.android_etps1.usuarios.usuariosClases.DatosRecyclerViewUser;

import java.util.ArrayList;

public class UsuariosActivity extends AppCompatActivity implements AdapterUserRecyclerView.OnItemClick {

    Toolbar toolbarUsuario;
    RecyclerView recyclerViewUsuario;
    ArrayList<DatosRecyclerViewUser> listDatos;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_usuarios, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.new_usuario :
                Intent next = new Intent(getApplicationContext(), NewUsuarioActivity.class);
                startActivity(next);
                break;

            case R.id.lista_personas :
                next = new Intent(getApplicationContext(), ListaPersonasActivity.class);
                startActivity(next);
                break;
            case R.id.new_rol :
                next = new Intent(getApplicationContext(), RolUsuariosActivity.class);
                startActivity(next);
                break;
            case android.R.id.home :
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        toolbarUsuario = findViewById(R.id.tb_usuarios);
        recyclerViewUsuario = findViewById(R.id.rv_usuarios);

        setSupportActionBar(toolbarUsuario);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("LISTA DE USUARIOS");

        listDatos = new ArrayList<>();
        recyclerViewUsuario.setLayoutManager(new LinearLayoutManager(this));

        fillRecyclerView();
        AdapterUserRecyclerView adapter = new AdapterUserRecyclerView(listDatos, this);
        recyclerViewUsuario.setAdapter(adapter);
        recyclerViewUsuario.addItemDecoration(
                new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    private void showDialog(){
        AlertDialog.Builder alerta = new AlertDialog.Builder(UsuariosActivity.this);
        alerta
                .setTitle("Alerta")
                .setMessage("Seleccione una opción")
                .setCancelable(true)
                .setPositiveButton("EDITAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent next = new Intent(getApplicationContext(), EditUsuariosActivity.class);
                        startActivity(next);

                    }
                })
                .setNegativeButton("ELIMINAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog mostrar = alerta.create();
        mostrar.show();
    }

    private void fillRecyclerView(){
        listDatos.add(new DatosRecyclerViewUser("ADMINISTRADOR","ADMINISTRADOR"));
        listDatos.add(new DatosRecyclerViewUser("USUARIO 1 ","COLABORADOR"));
        listDatos.add(new DatosRecyclerViewUser("USUARIO 2 ","COLABORADOR"));
    }
    @Override
    public void onMenuClick(DatosRecyclerViewUser usuario) {

        showDialog();
    }

}
