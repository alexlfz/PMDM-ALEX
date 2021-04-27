package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Hamburguesa2 extends AppCompatActivity {

    private TextView tCarne;
    private TextView tEstado;
    private TextView tQueso;
    private TextView tEnsalada;
    private TextView tPatatas;
    private TextView tPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamburguesa2);

        Bundle datos = getIntent().getExtras();

        tCarne = findViewById(R.id.textoCarne);
        tCarne.setText(datos.getString("Carne"));

        tEstado = findViewById(R.id.textoEstado);
        tEstado.setText(datos.getString("EstadoCarne"));

        tQueso= findViewById(R.id.textoQueso);
        tQueso.setText(datos.getString("Queso"));

        tEnsalada = findViewById(R.id.textoEnsalada);
        tEnsalada.setText(datos.getString("Ensalada"));

        tPatatas = findViewById(R.id.textoPatatas);
        tPatatas.setText(datos.getString("Patatas"));

        tPrecio = findViewById(R.id.textoPrecio);
        tPrecio.setText("PRECIO: " + datos.getString("Precio") + "€");
    }
}