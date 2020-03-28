package com.estechvmg.esTechAppProyect;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class SecondActivity extends AppCompatActivity {
    public BottomNavigationView bottomNav;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bottomNav = findViewById(R.id.navigation);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder exitAlert= DialogCreator.createBasicDialog(this,"Atencíon","¿Desea salir de la aplicación?");
        exitAlert.setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        exitAlert.setPositiveButton("salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        exitAlert.show();
    }
}
