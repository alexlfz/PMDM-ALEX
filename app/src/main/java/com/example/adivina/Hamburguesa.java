package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Hamburguesa extends AppCompatActivity {

    CheckBox cPollo, cTofu, cTernera, cPatatasPeq, cPatatasMed, cPatatasGra;
    Button botonRealizar;
    float precioFinal = 0f;
    ToggleButton tEnsalada;
    String mensaje = "Hamburguesa: ";
    Spinner sQuesos;
    SeekBar puntoCarne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamburguesa);

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage("Aqui no vendemos comida para pajaros...").
                setCancelable(false).
                setPositiveButton("Pedir otra cosa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).
                setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog titulo = alerta.create();
        titulo.setTitle("Veganos NO");

        cPollo =findViewById(R.id.checkBox1);
        cTofu =findViewById(R.id.checkBox2);
        cTernera =findViewById(R.id.checkBox3);
        cPatatasPeq =findViewById(R.id.checkBox4);
        cPatatasMed =findViewById(R.id.checkBox5);
        cPatatasGra =findViewById(R.id.checkBox6);
        tEnsalada =findViewById(R.id.toggleButton);
        sQuesos =findViewById(R.id.spinner2);
        puntoCarne = findViewById(R.id.seekBar3);

        Intent i = new Intent(this, Hamburguesa2.class);
        View.OnClickListener manejador = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                precioFinal = 0;

                if(tEnsalada.isChecked()){
                    precioFinal += 1.50f;
                    i.putExtra("Ensalada","Si");
                }else{
                    i.putExtra("Ensalada","No");
                }

                if(cTernera.isChecked()){
                    precioFinal += 8.5f;
                    i.putExtra("Carne","Ternera");
                }else {
                    if (cPollo.isChecked()) {
                        precioFinal += 7.5f;
                        i.putExtra("Carne", "Pollo");
                    }else{
                        i.putExtra("Carne","No");
                    }
                }

                if(cTofu.isChecked()){
                    titulo.show();
                    return;
                }

                switch(puntoCarne.getProgress()) {
                    case 0:
                        i.putExtra("EstadoCarne", "Poco hecha");
                        break;
                    case 1:
                        i.putExtra("EstadoCarne", "Al punto");
                        break;
                    case 2:
                        i.putExtra("EstadoCarne", "Muy hecha");
                        break;
                }

                i.putExtra("Queso", sQuesos.getSelectedItem().toString());

                if(cPatatasPeq.isChecked()){
                    precioFinal += 1;
                    i.putExtra("Patatas", "Pequeñas");
                }else {
                    if (cPatatasMed.isChecked()) {
                        precioFinal += 1.5f;
                        i.putExtra("Patatas", "Medianas");
                    }else{
                        if(cPatatasGra.isChecked()){
                            precioFinal += 2.25f;
                            i.putExtra("Patatas", "Grandes");
                        }else{
                            i.putExtra("Patatas", "No");
                        }
                    }
                }
                i.putExtra("Precio", String.valueOf(precioFinal));

                startActivity(i);
            }
        };
        botonRealizar=findViewById(R.id.button);
        botonRealizar.setOnClickListener(manejador);
    }
}