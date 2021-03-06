package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Calculadora3 extends AppCompatActivity {

    private TextView tNumero1, tNumero2;
    private TextView tOperacion, tResult;
    private int num1, num2;
    private float resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora3);

        Bundle datos = getIntent().getExtras();

        tNumero1 = findViewById(R.id.tNum1);
        tNumero1.setText(datos.getString("numero1"));

        tNumero2 = findViewById(R.id.tNum2);
        tNumero2.setText(datos.getString("numero2"));

        tOperacion = findViewById(R.id.tOperacion);
        tOperacion.setText(datos.getString("operacion"));

        num1 = Integer.parseInt(datos.getString("numero1"));
        num2 = Integer.parseInt(datos.getString("numero2"));

        switch (datos.getString("operacion")){
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                resultado = num1 / num2;
                break;
        }

        tResult = findViewById(R.id.tResult);
        tResult.setText("" + resultado);

    }
}