package com.example.adivina;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView texto;
    private Button prueba;
    private String aux;
    private int intentos = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage("Quieres 3 intentos más?").
                setCancelable(false).
                setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intentos = 3;
                    }
                }).
                setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog titulo = alerta.create();
        titulo.setTitle("Intentos gastados");

        int intAleatorio = (int) (Math.random() * 10) + 1;
        texto = findViewById(R.id.textoFinal);

        if(intentos < 1){
            titulo.show();
        }

        View.OnClickListener elQueManeja = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aux = (String) ((Button) v).getText();
                if (intAleatorio > Integer.parseInt(aux)) {
                    texto.setText("Te has quedado corto");
                    intentos -= 1;
                } else {
                    if (intAleatorio < Integer.parseInt(aux)) {
                        texto.setText("Te has pasado");
                        intentos -= 1;
                    } else {
                        if (intAleatorio == Integer.parseInt(aux)) {
                            texto.setText("Has acertado");
                        }
                    }
                }
                if(intentos < 1){
                    titulo.show();
                }
            }
        };


        prueba = findViewById(R.id.boton1);
        prueba.setOnClickListener(elQueManeja);

        prueba = findViewById(R.id.boton2);
        prueba.setOnClickListener(elQueManeja);

        prueba = findViewById(R.id.boton3);
        prueba.setOnClickListener(elQueManeja);

        prueba = findViewById(R.id.boton4);
        prueba.setOnClickListener(elQueManeja);

        prueba = findViewById(R.id.boton5);
        prueba.setOnClickListener(elQueManeja);

        prueba = findViewById(R.id.boton6);
        prueba.setOnClickListener(elQueManeja);

        prueba = findViewById(R.id.boton7);
        prueba.setOnClickListener(elQueManeja);

        prueba = findViewById(R.id.boton8);
        prueba.setOnClickListener(elQueManeja);

        prueba = findViewById(R.id.boton9);
        prueba.setOnClickListener(elQueManeja);

        prueba = findViewById(R.id.boton0);
        prueba.setOnClickListener(elQueManeja);
    }
}