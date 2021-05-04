package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculadora1 extends AppCompatActivity {

    private Button bSeleccionar;
    private Button bCal;
    private int LAUNCH_GETNUMBER_TOP = 1;
    private int LAUNCH_GETNUMBER_DOWN = 2;
    private TextView tNumero1, tNumero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora1);

        Intent i = new Intent(this, Calculadora2.class);
        Intent i2 = new Intent(this, Calculadora3.class);

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


        View.OnClickListener elQueManeja3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i2.putExtra("numero1",tNumero1.toString());
                i2.putExtra("numero2",tNumero2.toString());
                startActivity(i2);
            }
        };


        bSeleccionar = findViewById(R.id.bSeleccionar1);
        bSeleccionar.setOnClickListener(elQueManeja);

        bSeleccionar = findViewById(R.id.bSeleccionar2);
        bSeleccionar.setOnClickListener(elQueManeja2);

        bCal = findViewById(R.id.bCalcular);
        bCal.setOnClickListener(elQueManeja3);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        tNumero1 = findViewById(R.id.tNum1);
        tNumero2 = findViewById(R.id.tNumero2);

        if (requestCode == LAUNCH_GETNUMBER_TOP) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("numero");
                tNumero1.setText(result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                tNumero1.setText("Error");
            }
        }

        if (requestCode == LAUNCH_GETNUMBER_DOWN) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("numero");
                tNumero2.setText(result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                tNumero2.setText("Error");
            }
        }
    }
}