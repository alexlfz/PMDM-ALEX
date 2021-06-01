package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

public class GolActividad extends AppCompatActivity implements GolFragmento.FragmentAListener {

    private TextView tCelebracion;
    private GolFragmento fragmento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gol_actividad);

        tCelebracion = findViewById(R.id.txtCelebracion);
        fragmento = new GolFragmento();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentGol, fragmento)
                .commit();

    }

    @Override
    public void onInputASent(CharSequence input) {
        CharSequence mensaje = fragmento.enviarMensaje();
        tCelebracion.setText(mensaje);
    }
}

// https://www.youtube.com/watch?v=i22INe14JUc&ab_channel=CodinginFlowCodinginFlow