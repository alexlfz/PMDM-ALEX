package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Calculadora3 extends AppCompatActivity {

    private TextView tNumero1, tNumero2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora3);

        Bundle datos = getIntent().getExtras();

        tNumero1 = findViewById(R.id.tNum1);
        tNumero1.setText(datos.getString("numero1"));

        Toast.makeText(getApplicationContext(),datos.getString("numero1"),Toast.LENGTH_LONG).show();

        tNumero2 = findViewById(R.id.tNum2);
        tNumero2.setText(datos.getString("numero2"));
    }



}