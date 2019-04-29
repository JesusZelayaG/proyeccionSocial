package com.example.android_etps1.facultades.listaEscuelas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import com.example.android_etps1.R;
import com.example.android_etps1.facultades.listaEscuelas.listaEscuelasClases.AdapterEscRecyclerView;
import com.example.android_etps1.facultades.listaEscuelas.listaEscuelasClases.DatosRecyclerViewEsc;
import java.util.ArrayList;

public class ListasEscuelasActivity extends AppCompatActivity {
    Toolbar toolBarEscuelas;
    RecyclerView reciclerViewEscuela;
    ArrayList<DatosRecyclerViewEsc> listDatos;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_escuelas, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_escuelas);


        toolBarEscuelas = findViewById(R.id.tb_escuelas);
        reciclerViewEscuela = findViewById(R.id.rv_escuelas);

        setSupportActionBar(toolBarEscuelas);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("LISTA DE ESCUELAS");

        listDatos = new ArrayList<>();
        reciclerViewEscuela.setLayoutManager(new LinearLayoutManager(this));

        fillRecyclerView();
        AdapterEscRecyclerView adapter = new AdapterEscRecyclerView(listDatos);
        reciclerViewEscuela.setAdapter(adapter);
        reciclerViewEscuela.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_escuela:
                Intent intent = new Intent(getApplicationContext(), NewListaActivity.class);
                startActivity(intent);
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    private void fillRecyclerView() {
        listDatos.add(new DatosRecyclerViewEsc("ESCUELA DE INFORMATICA ", "2 PROYECTOS"));
        listDatos.add(new DatosRecyclerViewEsc("ESCUELA DE CIENCIAS APLICADAS", "2 PROYECTOS"));
    }


}
