package com.estechvmg.esTechAppProyect;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {
    public RecyclerView recyclerView;
    public SharedPreferences preferences;
    private TextView welcome;
    public String reward="Dummy Reward";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home_fragment,container,false);
        preferences=getActivity().getSharedPreferences("preferences", Context.MODE_PRIVATE);
        welcome=view.findViewById(R.id.welcome);
        welcome.setText("Bienvenido,\n" + preferences.getString("LAST_USER","Unknown User"));
        return view;
    }

}