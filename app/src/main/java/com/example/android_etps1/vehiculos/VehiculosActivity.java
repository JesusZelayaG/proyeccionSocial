package com.example.android_etps1.vehiculos;

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
import android.view.View;

import com.example.android_etps1.R;
import com.example.android_etps1.vehiculos.vehiculosClases.AdapterVehRecyclerView;
import com.example.android_etps1.vehiculos.vehiculosClases.DatosRecyclerViewVeh;

import java.util.ArrayList;

public class VehiculosActivity extends AppCompatActivity implements  AdapterVehRecyclerView.OnItemClick {
    Toolbar toolBarVehiculos;
    RecyclerView recyclerViewVeh;
    ArrayList<DatosRecyclerViewVeh> listDatos;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_vehiculos, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.new_vehiculo :
                Intent next = new Intent(getApplicationContext(), NewVehiculosActivity.class);
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
        setContentView(R.layout.activity_vehiculos);

        toolBarVehiculos = findViewById(R.id.tb_vehiculos);
        recyclerViewVeh = findViewById(R.id.rv_vehiculos);

        setSupportActionBar(toolBarVehiculos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("LISTA DE VEHICULOS");

        listDatos = new ArrayList<>();
        recyclerViewVeh.setLayoutManager(new LinearLayoutManager(this));

        fillRecyclerView();
        AdapterVehRecyclerView adapter = new AdapterVehRecyclerView(listDatos, this);
        recyclerViewVeh.setAdapter(adapter);
        recyclerViewVeh.addItemDecoration(
                new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));


    }
    private void showDialog(){
        AlertDialog.Builder alerta = new AlertDialog.Builder(VehiculosActivity.this);
        alerta
                .setTitle("Alerta")
                .setMessage("Seleccione una opción")
                .setCancelable(true)
                .setPositiveButton("EDITAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent next = new Intent(getApplicationContext(), EditVehiculosActivity.class);
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
    @Override
    public void onMenuClick(DatosRecyclerViewVeh vehiculo) {

        showDialog();
    }
    private void fillRecyclerView(){
        listDatos.add(new DatosRecyclerViewVeh("VEHICULO 1","Precio $30.50"));
        listDatos.add(new DatosRecyclerViewVeh("VEHICULO 2","Precio $20.50"));
        listDatos.add(new DatosRecyclerViewVeh("VEHICULO 3","Precio $10.50"));
        listDatos.add(new DatosRecyclerViewVeh("VEHICULO 4","Precio $3.50"));
    }



}

