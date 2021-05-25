package com.example.adivina;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Permisos extends AppCompatActivity {

    private Button bWeb, bLlamar, bMensaje;
    final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permisos);

        bLlamar = findViewById(R.id.bLlamar);
        bMensaje = findViewById(R.id.bMensaje);

        Intent i = new Intent(this, Permisos2.class);

        View.OnClickListener elQueManeja = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        };


        View.OnClickListener elQueManeja2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permiso = ContextCompat.checkSelfPermission(Permisos.this, Manifest.permission.CALL_PHONE);
                if(permiso != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getApplicationContext(), "No tiene permisos de llamada", Toast.LENGTH_LONG).show();
                    ActivityCompat.requestPermissions(Permisos.this, new String[]{Manifest.permission.CALL_PHONE},255);
                }else{
                    Intent i2 = new Intent(Intent.ACTION_CALL);
                    i2.setData(Uri.parse("tel:691641671"));
                    startActivity(i2);
                }
            }
        };

        bWeb = findViewById(R.id.bWeb);
        bWeb.setOnClickListener(elQueManeja);

        bLlamar = findViewById(R.id.bLlamar);
        bLlamar.setOnClickListener(elQueManeja2);

    }


}