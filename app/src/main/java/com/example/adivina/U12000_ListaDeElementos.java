package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class U12000_ListaDeElementos extends AppCompatActivity {

    U12000_Adaptador adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u12000_lista_de_elementos);

        // data to populate the RecyclerView with


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new U12000_Adaptador(this);
        adapter.setClickListener(new U12000_Adaptador.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);

        Button b = findViewById(R.id.bCarga);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> info = new ArrayList<>();
                info.add("Horse");
                info.add("Cow");
                info.add("Camel");
                info.add("Sheep");
                info.add("Goat");
                adapter.addData(info);
            }
        });

    }
}