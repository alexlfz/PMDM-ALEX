package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ListadoActividad2 extends AppCompatActivity {

    TextView tvVisitante, tvLocal, tvScoreVisitante, tvScoreLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_actividad2);

        tvLocal = findViewById(R.id.txtLocal);
        tvVisitante = findViewById(R.id.txtVisitante);
        tvScoreLocal = findViewById(R.id.txtScoreLocal);
        tvScoreVisitante = findViewById(R.id.txtScoreVisitante);

        Bundle datos = getIntent().getExtras();
        ArrayList<String> partido = new ArrayList<>();
        partido.addAll(datos.getStringArrayList("Partido"));

        tvLocal.setText(partido.get(0));
        tvScoreLocal.setText(partido.get(1));
        tvScoreVisitante.setText(partido.get(2));
        tvVisitante.setText(partido.get(3));

    }
}