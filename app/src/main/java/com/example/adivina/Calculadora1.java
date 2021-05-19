package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Calculadora1 extends AppCompatActivity {

    private Button bSeleccionar;
    private Button bCal;
    private int LAUNCH_GETNUMBER_TOP = 1;
    private int LAUNCH_GETNUMBER_DOWN = 2;
    private TextView tNumero1, tNumero2;
    private String opcion="";
    private RadioButton rSumar, rRestar, rMultiplicar, rDividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora1);

        Intent i = new Intent(this, Calculadora2.class);
        Intent i2 = new Intent(this, Calculadora3.class);

        tNumero1 = findViewById(R.id.tNum1);
        tNumero2 = findViewById(R.id.tNumero2);

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

        rSumar = findViewById(R.id.bSumar);
        rRestar = findViewById(R.id.bRestar);
        rMultiplicar = findViewById(R.id.bMultiplicar);
        rDividir = findViewById(R.id.bDividir);



        View.OnClickListener elQueManeja3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rSumar.isChecked()){
                    opcion = "+";
                }else{
                    if(rRestar.isChecked()){
                        opcion = "-";
                    }
                    else{
                        if(rMultiplicar.isChecked()){
                            opcion = "*";
                        }else{
                            if(rDividir.isChecked()){
                                opcion = "/";
                            }
                        }
                    }
                }

                i2.putExtra("numero1",tNumero1.getText());
                i2.putExtra("numero2",tNumero2.getText());
                i2.putExtra("operacion", opcion);
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