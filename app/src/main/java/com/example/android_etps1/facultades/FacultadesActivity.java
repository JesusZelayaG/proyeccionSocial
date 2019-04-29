package com.example.android_etps1.facultades;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android_etps1.facultades.facultadesClases.AdapterFacRecyclerView;
import com.example.android_etps1.facultades.facultadesClases.DatosRecyclerViewFac;
import com.example.android_etps1.R;
import com.example.android_etps1.facultades.listaEscuelas.ListasEscuelasActivity;

import java.util.ArrayList;

public class FacultadesActivity extends AppCompatActivity implements AdapterFacRecyclerView.OnItemClick {
    Toolbar toolBarFacultad;
    RecyclerView recyclerViewFac;
    ArrayList<DatosRecyclerViewFac> listDatos;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_facultades, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.new_facultad :
                Intent next = new Intent(getApplicationContext(), NewFacultadActivity.class);
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
        setContentView(R.layout.activity_facultades);

        toolBarFacultad = findViewById(R.id.tb_facultades);
        recyclerViewFac = findViewById(R.id.rv_facultades);

        setSupportActionBar(toolBarFacultad);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("LISTA DE FACULTADES");

        listDatos = new ArrayList<>();
        recyclerViewFac.setLayoutManager(new LinearLayoutManager(this));

        fillRecyclerView();
        AdapterFacRecyclerView adapter = new AdapterFacRecyclerView(listDatos, this);
        recyclerViewFac.setAdapter(adapter);
        recyclerViewFac.addItemDecoration(
                new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));


    }
    private void showDialog(){
        AlertDialog.Builder alerta = new AlertDialog.Builder(FacultadesActivity.this);
        alerta
                .setTitle("Alerta")
                .setMessage("Seleccione una opción")
                .setCancelable(true)
                .setPositiveButton("EDITAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent next = new Intent(getApplicationContext(), EditFacultadActivity.class);
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
        listDatos.add(new DatosRecyclerViewFac("FACULTAD DE INFORMATICA Y CIENCIAS APLICADAS","4 PROYECTOS"));
        listDatos.add(new DatosRecyclerViewFac("FACULTAD DE DERECHO","1 PROYECTO"));
        listDatos.add(new DatosRecyclerViewFac("FACULTAD DE CIENCIAS SOCIALES","0 PROYECTOS"));
        listDatos.add(new DatosRecyclerViewFac("FACULTAD DE CIENCIAS EMPRESARIALES","3 PROYECTOS"));
    }


    @Override
    public void onMenuClick(DatosRecyclerViewFac facultad) {

        showDialog();
    }

    @Override
    public void onContainerClick(DatosRecyclerViewFac facultad) {
        Intent intent = new Intent(getApplicationContext(), ListasEscuelasActivity.class);
        startActivity(intent);

    }
}
