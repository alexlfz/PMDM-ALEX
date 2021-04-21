package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Hamburguesa extends AppCompatActivity {

    CheckBox c1,c2,c3,c4,c5,c6;
    Button botonRealizar;
    float precioFinal = 0f;
    ToggleButton toggleButton;
    String mensaje = "Hamburguesa: ";
    Spinner spinner;

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

        c1=findViewById(R.id.checkBox1);
        c2=findViewById(R.id.checkBox2);
        c3=findViewById(R.id.checkBox3);
        c4=findViewById(R.id.checkBox4);
        c5=findViewById(R.id.checkBox5);
        c6=findViewById(R.id.checkBox6);
        toggleButton=findViewById(R.id.toggleButton);
        spinner=findViewById(R.id.spinner2);
        
        
        View.OnClickListener manejador = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(c3.isChecked()){
                    precioFinal += 8.5f;
                    mensaje += "Ternera, ";
                }
                if(c1.isChecked()){
                    precioFinal += 7.5f;
                    mensaje += "Pollo, ";
                }

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        mensaje += "Queso " + parent.getItemAtPosition(position).toString() + ", ";
                        precioFinal += 2f;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        mensaje += "Sin queso, ";
                    }
                });

                if(c4.isChecked()){
                    precioFinal += 1;
                    mensaje += "patatas pequeñas, ";
                }
                if(c5.isChecked()){
                    precioFinal += 1.5f;
                    mensaje += "patatas medianas, ";
                }
                if(c6.isChecked()){
                    precioFinal += 2.25f;
                    mensaje += "patatas grandes, ";
                }

                if(toggleButton.isChecked()){
                    precioFinal += 1.50f;
                    mensaje += "y ensalada.";
                }else{
                    mensaje += "sin ensalada.";
                }

                if(c2.isChecked()){
                    titulo.show();
                }else{
                    Toast.makeText(getApplicationContext(),mensaje + "\nPrecio final: " + precioFinal + "€",Toast.LENGTH_LONG).show();
                    precioFinal = 0f;
                    mensaje = "";
                }

            }
        };

        botonRealizar=findViewById(R.id.button);
        botonRealizar.setOnClickListener(manejador);
        
    }
    
  


}