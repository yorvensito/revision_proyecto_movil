package com.example.restaurant;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class UltimosComentariosFragment extends Fragment {

    public UltimosComentariosFragment() {
        // Constructor público vacío requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout para el fragmento desde activity_ultimos_comentarios.xml
        return inflater.inflate(R.layout.activity_ultimos_comentarios, container, false);
    }
}
