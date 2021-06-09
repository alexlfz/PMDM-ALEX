package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoActividad extends AppCompatActivity {

    ListadoAdapter adapter;
    ArrayList<ArrayList<String>> info = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_actividad);

        RecyclerView recyclerView = findViewById(R.id.listView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListadoAdapter(this);

        Intent i = new Intent(this, ListadoActividad2.class);
        adapter.setClickListener(new ListadoAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                i.putExtra("Partido", adapter.getItem(position));
                startActivity(i);
            }
        });

        recyclerView.setAdapter(adapter);

        cargarDatos(info);

        adapter.addData(info);
    }

    private void cargarDatos(ArrayList<ArrayList<String>> info) {

        ArrayList<String> fila1 = new ArrayList<>();
        ArrayList<String> fila2 = new ArrayList<>();
        ArrayList<String> fila3 = new ArrayList<>();
        ArrayList<String> fila4 = new ArrayList<>();
        ArrayList<String> fila5 = new ArrayList<>();

        fila1.add("RMA");
        fila1.add("0");
        fila1.add("4");
        fila1.add("FCB");
        info.add(fila1);

        fila2.add("VAL");
        fila2.add("1");
        fila2.add("2");
        fila2.add("SEV");
        info.add(fila2);

        fila3.add("ATM");
        fila3.add("3");
        fila3.add("1");
        fila3.add("MLG");
        info.add(fila3);

        fila4.add("VIL");
        fila4.add("0");
        fila4.add("3");
        fila4.add("ZGZ");
        info.add(fila4);

        fila5.add("CEL");
        fila5.add("5");
        fila5.add("1");
        fila5.add("DEP");
        info.add(fila5);
    }
}