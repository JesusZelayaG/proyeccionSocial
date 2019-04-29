package com.example.android_etps1.index;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android_etps1.R;
import com.example.android_etps1.index.HomeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ingresarApp(View btn_ingresar){
        Intent obj = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(obj);

    }
}
