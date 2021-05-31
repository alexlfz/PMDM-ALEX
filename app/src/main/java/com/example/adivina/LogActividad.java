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
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    private final LogMensaje fragmento = new LogMensaje();
    private final Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_actividad);

        fragmentTransaction.add(R.id.fragmentMensajes, fragmento).commit();

        txtMensaje = findViewById(R.id.txtMensaje);

        Button bEnviar = findViewById(R.id.btnEnviar);
        bEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmento.updateText(txtMensaje.getText().toString());
            }
        });
    }
}

// https://www.tutorialspoint.com/how-to-pass-a-variable-from-activity-to-fragment-in-android