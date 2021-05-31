package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogActividad extends AppCompatActivity {

    private EditText txtMensaje;
    private Button bEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_actividad);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LogMensaje fragmento = new LogMensaje();

        txtMensaje = findViewById(R.id.txtMensaje);

        bEnviar = findViewById(R.id.btnEnviar);
        bEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("txt", txtMensaje.getText().toString());
                fragmento.setArguments(bundle);
                fragmentTransaction.add(R.id.fragmentMensajes, fragmento, null).commit();
            }
        });
    }
}

// https://www.tutorialspoint.com/how-to-pass-a-variable-from-activity-to-fragment-in-android