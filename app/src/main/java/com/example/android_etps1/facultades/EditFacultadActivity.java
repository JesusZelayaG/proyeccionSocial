package com.example.android_etps1.facultades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.android_etps1.R;

public class EditFacultadActivity extends AppCompatActivity {


    Toolbar toolBarEditFac;

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
        setContentView(R.layout.activity_edit_facultad);

        toolBarEditFac = findViewById(R.id.tb_edit_facultad);

        setSupportActionBar(toolBarEditFac);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("EDITAR FACULTAD");
    }

    public void editFac(View btn_edit_fac){
        finish();
    }
}

