package com.example.android_etps1.proveedores;

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

import com.example.android_etps1.proveedores.proveedoresClases.AdapterProvRecyclerView;
import com.example.android_etps1.proveedores.proveedoresClases.DatosRecyclerViewProv;
import com.example.android_etps1.R;

import java.util.ArrayList;

public class ProveedoresActivity extends AppCompatActivity implements AdapterProvRecyclerView.OnItemClick{

    Toolbar toolBarProveedores;
    RecyclerView recyclerViewProv;
    ArrayList<DatosRecyclerViewProv> listDatos;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_proveedores, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.new_proveedor :
                Intent next = new Intent(getApplicationContext(), NewProveedorActivity.class);
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
        setContentView(R.layout.activity_proveedores);

        toolBarProveedores = findViewById(R.id.tb_proveedores);
        recyclerViewProv = findViewById(R.id.rv_proveedores);

        setSupportActionBar(toolBarProveedores);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("LISTA DE PROVEEDORES");

        listDatos = new ArrayList<>();
        recyclerViewProv.setLayoutManager(new LinearLayoutManager(this));

        fillRecyclerView();
        AdapterProvRecyclerView adapter = new AdapterProvRecyclerView(listDatos, this);
        recyclerViewProv.setAdapter(adapter);
        recyclerViewProv.addItemDecoration(
                new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));



    }
    private void showDialog(){
        AlertDialog.Builder alerta = new AlertDialog.Builder(ProveedoresActivity.this);
        alerta
                .setTitle("Alerta")
                .setMessage("Seleccione una opción")
                .setCancelable(true)
                .setPositiveButton("EDITAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent next = new Intent(getApplicationContext(), EditProveedoresActivity.class);
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
        listDatos.add(new DatosRecyclerViewProv("PROVEEDOR 1","ACTIVO"));
        listDatos.add(new DatosRecyclerViewProv("PROVEEDOR 2","INACTIVO"));
        listDatos.add(new DatosRecyclerViewProv("PROVEEDOR 3","INACTIVO"));
        listDatos.add(new DatosRecyclerViewProv("PROVEEDOR 4","ACTIVO"));
    }
    @Override
    public void onMenuClick(DatosRecyclerViewProv proveedor) {

        showDialog();
    }

}
