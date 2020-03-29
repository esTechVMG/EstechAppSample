package com.estechvmg.esTechAppProyect;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TabFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(identifier,container,false);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }

    private int identifier;
    TabFragment(int id){
        switch (id){
            case 0:
                identifier=R.layout.home_fragment;
                break;
            case 1:
                identifier=R.layout.blog_fragment;
                break;
            case 2:
                identifier=R.layout.gallery_fragment;
                break;
            case 3:
                identifier=R.layout.contact_fragment;
                break;
        }
    }

}