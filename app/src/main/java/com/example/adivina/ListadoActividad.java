package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoActividad extends AppCompatActivity {

    ListadoAdapter adapter;
    ArrayList<ArrayList<String>> info = new ArrayList<>();
    ArrayList<String> filas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_actividad);

        RecyclerView recyclerView = findViewById(R.id.listView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListadoAdapter(this);

        /*adapter.setClickListener(new U12000_Adaptador.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Toast.makeText(getApplicationContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
            }
        });*/

        recyclerView.setAdapter(adapter);

        cargarDatos(info, filas);

        adapter.addData(info);
    }

    private void cargarDatos(ArrayList<ArrayList<String>> info, ArrayList<String> filas) {
        filas.add("RMA");
        filas.add("0");
        filas.add("4");
        filas.add("FCB");
        info.add(filas);
        filas.removeAll(filas);
        filas.add("VAL");
        filas.add("1");
        filas.add("2");
        filas.add("SEV");
        info.add(filas);
    }
}