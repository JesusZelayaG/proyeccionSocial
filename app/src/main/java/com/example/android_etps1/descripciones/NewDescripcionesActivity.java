package com.example.android_etps1.descripciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.android_etps1.R;

public class NewDescripcionesActivity extends AppCompatActivity {
    Toolbar toolBarNewDesc;

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
        setContentView(R.layout.activity_new_descripciones);

        toolBarNewDesc = findViewById(R.id.tb_new_descripciones);

        setSupportActionBar(toolBarNewDesc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("NUEVA DESCRIPCIÓN");
    }

    public void saveDesc(View btn_save){
        finish();
    }
}


