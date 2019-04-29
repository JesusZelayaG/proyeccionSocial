package com.example.android_etps1.vehiculos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.android_etps1.R;

public class EditVehiculosActivity extends AppCompatActivity {

    Toolbar toolBarEditVeh;

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
        setContentView(R.layout.activity_edit_vehiculos);

        toolBarEditVeh = findViewById(R.id.tb_edit_veh);

        setSupportActionBar(toolBarEditVeh);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("EDITAR VEHICULO");
    }

    public void editVeh(View btn_edit_veh){
        finish();
    }
}
