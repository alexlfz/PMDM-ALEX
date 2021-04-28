package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Calculadora1 extends AppCompatActivity {

    private Button bSeleccionar;
    int LAUNCH_GETNUMBER_TOP = 1;
    int LAUNCH_GETNUMBER_DOWN = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora1);

        Intent i = new Intent(this, Calculadora2.class);

        View.OnClickListener elQueManeja = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(i, LAUNCH_GETNUMBER_TOP);
            }
        };

        View.OnClickListener elQueManeja2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(i, LAUNCH_GETNUMBER_DOWN);
            }
        };

        bSeleccionar = findViewById(R.id.bSeleccionar1);
        bSeleccionar.setOnClickListener(elQueManeja);

        bSeleccionar = findViewById(R.id.bSeleccionar2);
        bSeleccionar.setOnClickListener(elQueManeja2);
    }
}