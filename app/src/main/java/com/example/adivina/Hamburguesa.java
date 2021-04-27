package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

        
        View.OnClickListener manejador = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mensaje = "Hamburguesa";
                precioFinal = 0;

                if(tEnsalada.isChecked()){
                    precioFinal += 1.50f;
                    mensaje += " con ensalada: ";
                }else{
                    mensaje += " sin ensalada: ";
                }

                if(cTernera.isChecked()){
                    precioFinal += 8.5f;
                    mensaje += "Carne de ternera ";
                }
                if(cPollo.isChecked()){
                    precioFinal += 7.5f;
                    mensaje += "Carne de pollo ";
                }
                if(cTofu.isChecked()){
                    titulo.show();
                    return;
                }

                switch(puntoCarne.getProgress()) {
                    case 0:
                        mensaje += "poco hecha, ";
                        break;
                    case 1:
                        mensaje += "al punto, ";
                        break;
                    case 2:
                        mensaje += "muy hecha, ";
                        break;
                }


                mensaje += "queso " + sQuesos.getSelectedItem().toString() + ", ";


                if(cPatatasPeq.isChecked()){
                    precioFinal += 1;
                    mensaje += "patatas pequeñas ";
                }
                if(cPatatasMed.isChecked()){
                    precioFinal += 1.5f;
                    mensaje += "patatas medianas ";
                }
                if(cPatatasGra.isChecked()){
                    precioFinal += 2.25f;
                    mensaje += "patatas grandes ";
                }


                Toast.makeText(getApplicationContext(),mensaje + "\nPrecio final: " + precioFinal + "€",Toast.LENGTH_LONG).show();

            }
        };

        botonRealizar=findViewById(R.id.button);
        botonRealizar.setOnClickListener(manejador);
        
    }
    
  


}