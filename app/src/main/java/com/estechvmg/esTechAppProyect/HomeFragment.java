package com.estechvmg.esTechAppProyect;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    public SharedPreferences preferences;
    private TextView welcome;
    private ImageView imageView;
    int reward;
    public int rewardCounter=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home_fragment,container,false);
        preferences=getActivity().getSharedPreferences("preferences", Context.MODE_PRIVATE);
        if(!preferences.contains("REWARD_AVAILABLE")){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("REWARD_AVAILABLE",true);
            editor.apply();
        }
        imageView=view.findViewById(R.id.home_logo);
        welcome=view.findViewById(R.id.welcome);
        rewardCounter=0;
        welcome.setText("Bienvenido,\n" + preferences.getString("LAST_USER","Unknown User"));
        if(preferences.getBoolean("REWARD_AVAILABLE",false)){
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(++rewardCounter==10){
                        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setTitle("Choose an animal");// add a list
                        final String[] rewards = {"PS4", "Nintendo Switch", "PC Gaming"};
                        final String[] codes ={"93JD3","L3JM8","2NBW23"};
                        builder.setItems(rewards, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                builder.setCancelable(false);
                                switch (which) {
                                    case 0:
                                        reward=0;
                                    case 1:
                                        reward=1;
                                        break;
                                    case 2:
                                        reward=2;
                                        break;
                                }
                                AlertDialog.Builder builder2= DialogCreator.createBasicDialog(getContext(),"Atención","Has seleccionado el premio:\n" + rewards[reward] + ".Pasa por nuestra oficina con el codigo " + codes[reward] + " y te lo entregaremos.");
                                builder2.setCancelable(false);
                                builder2.setNeutralButton("cerrar", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        SharedPreferences.Editor editor= preferences.edit();
                                        editor.putBoolean("REWARD_AVAILABLE",false);
                                        editor.apply();
                                        imageView.setClickable(false);
                                    }
                                }).show();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                }
            });
        }
        return view;
    }

}