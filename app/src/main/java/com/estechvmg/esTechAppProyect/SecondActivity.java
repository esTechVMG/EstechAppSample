package com.estechvmg.esTechAppProyect;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class SecondActivity extends AppCompatActivity {
    public BottomNavigationView bottomNav;
    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bottomNav = findViewById(R.id.navigation);
        loadFragment(bottomNav.getSelectedItemId());
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                int t=item.getItemId();
                loadFragment(item.getItemId());
                return false;
            }
        });
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
    private TabFragment[] fragments=new TabFragment[]{
            new TabFragment(0),
            new TabFragment(1),
            new TabFragment(2),
            new TabFragment(3),
    };
    private void loadFragment(int id) {
        int fragmentNum;
        switch (id){
            case R.id.homeOption:
                Log.d("esTechApp","Selected Home");
                fragmentNum=0;
                break;
            case R.id.blogOption:
                Log.d("esTechApp","Selected Blog");
                fragmentNum=1;
                break;
            case R.id.galleryOption:
                fragmentNum=2;
                Log.d("esTechApp","Selected Gallery");
                break;
            case R.id.contactOption:
                fragmentNum=3;
                Log.d("esTechApp","Selected Contact");
                break;
            default:
                Log.d("esTechApp","Unrecognized");
                fragmentNum=4;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragments[fragmentNum]);
        fragmentTransaction.commit();
    }
}
