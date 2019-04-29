package com.example.android_etps1.facultades.listaEscuelas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.android_etps1.R;

public class NewListaActivity extends AppCompatActivity {
    Toolbar toolbarNewEscuela;

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
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
        setContentView(R.layout.activity_new_lista);

        toolbarNewEscuela = findViewById(R.id.tb_new_escuela);

        setSupportActionBar(toolbarNewEscuela);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("NUEVA ESCUELA");
    }
    public void saveEscuela(View btn_save_escuela){
        finish();
    }
}
