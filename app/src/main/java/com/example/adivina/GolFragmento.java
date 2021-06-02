package com.example.adivina;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

import java.util.Random;

public class GolFragmento extends Fragment {

    private FragmentAListener listener;
    private Button bJugada;
    private CharSequence input;

    public GolFragmento() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public interface FragmentAListener {
        void onInputASent(CharSequence input);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gol_fragmento, container, false);

        bJugada = v.findViewById(R.id.botonJugada);
        bJugada.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Random r = new Random();
                int numAleatorio = r.nextInt(6)+1;

                switch(numAleatorio){
                    case 1:
                        input = "Gol!";
                        break;
                    case 2:
                        input = "Penalti";
                        break;
                    case 3:
                        input = "Falta";
                        break;
                    default:
                        input = "Fuera...";
                        break;
                }
                listener.onInputASent(input);
            }
        });
        return v;
    }

    public CharSequence enviarMensaje(){
        return input;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentAListener) {
            listener = (FragmentAListener) context;
        }else{
           throw new RuntimeException(context.toString() + " debe implementar FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}