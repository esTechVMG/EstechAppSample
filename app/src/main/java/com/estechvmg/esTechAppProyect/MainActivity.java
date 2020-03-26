package com.estechvmg.esTechAppProyect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button forgotButton,loginButton,callButton;
    public TextInputLayout userInput,passInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        forgotButton=findViewById(R.id.forgotButton);
        loginButton=findViewById(R.id.loginButton);
        callButton=findViewById(R.id.callButton);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginButton:

                break;
            case R.id.callButton:

                break;
            case R.id.forgotButton:

                break;
        }
    }
}
