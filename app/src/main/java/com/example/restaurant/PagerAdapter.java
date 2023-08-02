package com.example.restaurant;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ComentariosFragment();
            case 1:
                return new PlatilloMasVotadoFragment();
            case 2:
                return new UltimosComentariosFragment();
            case 3:
                return new UltimosPlatillosFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4; // Número total de secciones
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Títulos de las pestañas (opcional)
        switch (position) {
            case 0:
                return "Comentarios";
            case 1:
                return "Platillo Más Votado";
            case 2:
                return "Últimos Comentarios";
            case 3:
                return "Últimos Platillos";
            default:
                return null;
        }
    }
}
