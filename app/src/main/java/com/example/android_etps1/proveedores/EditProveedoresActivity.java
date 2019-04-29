package com.example.android_etps1.proveedores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.android_etps1.R;

public class EditProveedoresActivity extends AppCompatActivity {

    Toolbar toolBarEditProv;

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
        setContentView(R.layout.activity_edit_proveedores);

        toolBarEditProv = findViewById(R.id.tb_edit_prov);

        setSupportActionBar(toolBarEditProv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("EDITAR PROVEEDOR");
    }
    public void editProv(View btn_edit){
        finish();
    }
}
