package com.example.android_etps1.vehiculos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.android_etps1.R;

public class NewVehiculosActivity extends AppCompatActivity {


    Toolbar toolBarNewVeh;

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
        setContentView(R.layout.activity_new_vehiculos);

        toolBarNewVeh = findViewById(R.id.tb_new_veh);

        setSupportActionBar(toolBarNewVeh);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("NUEVO VEHICULO");
    }

    public void saveVeh(View btn_save_veh){
        finish();
    }
}
