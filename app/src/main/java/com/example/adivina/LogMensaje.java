package com.example.adivina;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class LogMensaje extends Fragment {

    TextView parrafo;
    String lineaTexto = "";

    public LogMensaje() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null) {
            lineaTexto = getArguments().getString("txt", "");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_log_mensaje, container, false);
        parrafo = view.findViewById(R.id.txtParrafo);
        parrafo.setText(parrafo.getText() + "\n " + lineaTexto);

        return view;
    }

}