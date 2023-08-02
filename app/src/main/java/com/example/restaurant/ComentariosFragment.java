package com.example.restaurant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ComentariosFragment extends Fragment {

    public ComentariosFragment() {
        // Constructor público vacío requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout para el fragmento desde activity_comentarios.xml
        return inflater.inflate(R.layout.activity_comentarios, container, false);
    }
}
