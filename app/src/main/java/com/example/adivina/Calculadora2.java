package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculadora2 extends AppCompatActivity {

    private TextView tNumero;
    private Button bOk, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private String nMarcado;
    private String cadena = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora2);

        tNumero = findViewById(R.id.tNumero);
        Intent i = new Intent();

        View.OnClickListener elQueManeja1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nMarcado = (String) ((Button) v).getText();
                cadena = cadena + nMarcado;
                tNumero.setText(cadena);
            }
        };


        View.OnClickListener elQueManeja2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("numero",cadena);
                setResult(Activity.RESULT_OK,i);
                finish();
            }
        };

        bOk = findViewById(R.id.button3);
        bOk.setOnClickListener(elQueManeja2);

        b0 = findViewById(R.id.b0);
        b0.setOnClickListener(elQueManeja1);

        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(elQueManeja1);

        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(elQueManeja1);

        b3 = findViewById(R.id.b3);
        b3.setOnClickListener(elQueManeja1);

        b4 = findViewById(R.id.b4);
        b4.setOnClickListener(elQueManeja1);

        b5 = findViewById(R.id.b5);
        b5.setOnClickListener(elQueManeja1);

        b6 = findViewById(R.id.b6);
        b6.setOnClickListener(elQueManeja1);

        b7 = findViewById(R.id.b7);
        b7.setOnClickListener(elQueManeja1);

        b8 = findViewById(R.id.b8);
        b8.setOnClickListener(elQueManeja1);

        b9 = findViewById(R.id.b9);
        b9.setOnClickListener(elQueManeja1);
    }
}