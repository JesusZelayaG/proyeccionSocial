package com.example.android_etps1.facultades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.android_etps1.R;

public class NewFacultadActivity extends AppCompatActivity {


    Toolbar toolbarNewFac;

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
        setContentView(R.layout.activity_new_facultad);

        toolbarNewFac = findViewById(R.id.tb_new_facultad);

        setSupportActionBar(toolbarNewFac);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("NUEVA FACULTAD");
    }

    public void SaveFac(View btn_save){
        finish();
    }
}
