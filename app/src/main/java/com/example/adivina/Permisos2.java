package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Permisos2 extends AppCompatActivity {

    private WebView paginaVillablanca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permisos2);

        paginaVillablanca = (WebView) findViewById(R.id.webVillablanca);
        paginaVillablanca.loadUrl("https://site.educa.madrid.org/ies.villablanca.madrid/");
    }
}