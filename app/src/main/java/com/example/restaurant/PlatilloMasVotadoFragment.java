package com.example.restaurant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PlatilloMasVotadoFragment extends Fragment {

    public PlatilloMasVotadoFragment() {
        // Constructor público vacío requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout para el fragmento desde activity_platillo_mas_votado.xml
        return inflater.inflate(R.layout.activity_platillo_mas_votado, container, false);
    }
}
