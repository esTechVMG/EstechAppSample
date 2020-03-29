package com.estechvmg.esTechAppProyect;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class SecondActivity extends AppCompatActivity {
    public BottomNavigationView bottomNav;
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bottomNav = findViewById(R.id.navigation);
        loadFragment(fragments[0]);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                int t=item.getItemId();
                int selectedFragment=0;
                switch (item.getItemId()){
                    case R.id.homeOption:
                        selectedFragment=0;
                        setTitle("Escuela Estech");
                        break;
                    case R.id.blogOption:
                        selectedFragment=1;
                        setTitle("Blog");
                        break;
                    case R.id.galleryOption:
                        selectedFragment=2;
                        setTitle("Galería");
                        break;
                    case R.id.contactOption:
                        selectedFragment=3;
                        setTitle("Contacto");
                        break;
                }
                loadFragment(fragments[selectedFragment]);
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
    private Fragment[] fragments=new Fragment[]{
            new HomeFragment(),
            new BlogFragment(),
            new GalleryFragment(),
            new ContactFragment()
    };
    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }
}
