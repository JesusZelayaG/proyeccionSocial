package com.example.android_etps1.proveedores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.android_etps1.R;

public class NewProveedorActivity extends AppCompatActivity {

    Toolbar toolBarNewProv;

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
        setContentView(R.layout.activity_new_proveedor);

        toolBarNewProv = findViewById(R.id.tb_new_prov);

        setSupportActionBar(toolBarNewProv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("NUEVO PROVEEDOR");
    }
    public void saveProv(View btn_save){
        finish();
    }
}
