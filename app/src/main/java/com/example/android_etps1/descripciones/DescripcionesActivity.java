package com.example.android_etps1.descripciones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android_etps1.descripciones.descripcionesClases.AdapterDescRecyclerView;
import com.example.android_etps1.descripciones.descripcionesClases.DatosRecyclerViewDesc;
import com.example.android_etps1.R;

import java.util.ArrayList;

public class DescripcionesActivity extends AppCompatActivity {

    Toolbar toolBarDescripciones;
    RecyclerView recyclerViewDesc;
    ArrayList<DatosRecyclerViewDesc> listDatos;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_descripciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.new_descripciones :
                Intent next = new Intent(getApplicationContext(), NewDescripcionesActivity.class);
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
        setContentView(R.layout.activity_descripciones);

        toolBarDescripciones = findViewById(R.id.tb_descripciones);
        recyclerViewDesc = findViewById(R.id.rv_descripciones);

        recyclerViewDesc.setHasFixedSize(true);

        setSupportActionBar(toolBarDescripciones);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("LISTA DE DESCRIPCIONES");
        listDatos = new ArrayList<>();
        recyclerViewDesc.setLayoutManager(new LinearLayoutManager(this));

        fillRecyclerView();
        AdapterDescRecyclerView adapter = new AdapterDescRecyclerView(listDatos);
        recyclerViewDesc.setAdapter(adapter);
        recyclerViewDesc.addItemDecoration(
                        new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }
    private void fillRecyclerView(){
        listDatos.add(new DatosRecyclerViewDesc("DESCRIPCION 1"));
        listDatos.add(new DatosRecyclerViewDesc("DESCRIPCION 2"));
        listDatos.add(new DatosRecyclerViewDesc("DESCRIPCION 3"));
        listDatos.add(new DatosRecyclerViewDesc("DESCRIPCION 4"));
    }

}

