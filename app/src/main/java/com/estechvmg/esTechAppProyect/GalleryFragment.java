package com.estechvmg.esTechAppProyect;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    public ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gallery_fragment,container,false);
        viewPager=view.findViewById(R.id.viewPager);
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(R.drawable.escuela_1);
        lista.add(R.drawable.escuela_2);
        lista.add(R.drawable.escuela_3);
        lista.add(R.drawable.escuela_4);
        lista.add(R.drawable.escuela_6);
        lista.add(R.drawable.escuela_7);
        lista.add(R.drawable.escuela_8);
        GalleryAdapter adapterGallery = new GalleryAdapter(getContext(), lista);
        viewPager.setAdapter(adapterGallery);
        return view;
    }
}
