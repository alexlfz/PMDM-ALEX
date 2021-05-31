package com.example.adivina;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LogMensaje extends Fragment {

    TextView parrafo;
    String lineaTexto = "";

    public LogMensaje() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log_mensaje, container, false);

        parrafo = view.findViewById(R.id.txtParrafo);

        return view;
    }


    public void updateText(String text){
        parrafo.setText(parrafo.getText() + "\n " + text);

        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        parrafo.setBackgroundColor(color);
    }


}