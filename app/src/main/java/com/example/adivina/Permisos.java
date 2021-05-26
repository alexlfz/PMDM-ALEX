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
    private final int PERMISO_LLAMADA = 255;
    private final int PERMISO_SMS = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permisos);

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
                if(ContextCompat.checkSelfPermission(Permisos.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(Permisos.this, new String[]{Manifest.permission.CALL_PHONE},PERMISO_LLAMADA);
                }else{
                    llamar();
                }
            }
        };

        View.OnClickListener elQueManeja3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ContextCompat.checkSelfPermission(Permisos.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(Permisos.this, new String[]{Manifest.permission.SEND_SMS},PERMISO_SMS);
                }else{
                    enviarMensaje();
                }
            }
        };

        bWeb = findViewById(R.id.bWeb);
        bWeb.setOnClickListener(elQueManeja);

        bLlamar = findViewById(R.id.bLlamar);
        bLlamar.setOnClickListener(elQueManeja2);

        bMensaje = findViewById(R.id.bMensaje);
        bMensaje.setOnClickListener(elQueManeja3);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISO_LLAMADA: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    llamar();
                } else {
                    Toast.makeText(getApplicationContext(), "No tiene permisos de llamada", Toast.LENGTH_LONG).show();
                }
                return;
            }

            case PERMISO_SMS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    enviarMensaje();
                } else {
                    Toast.makeText(getApplicationContext(), "No tiene permisos de SMS", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }

    public void llamar(){
        Intent i2 = new Intent(Intent.ACTION_CALL);
        i2.setData(Uri.parse("tel:666666666"));
        startActivity(i2);
    }

    public void enviarMensaje(){
        Intent i3 = new Intent(Intent.ACTION_SENDTO);
        i3.setData(Uri.parse("smsto:66666666"));
        i3.putExtra("sms_body", "Felicidades!!!");
        startActivity(i3);
    }


}