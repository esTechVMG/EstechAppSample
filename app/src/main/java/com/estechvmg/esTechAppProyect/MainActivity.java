package com.estechvmg.esTechAppProyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public int phoneNumber=953636000;
    private VMGAccountManager accounts=new VMGAccountManager(new VMGAccount[]{
            new VMGAccount("invitado","estech1234"),
            new VMGAccount("alumno","alumno1234"),
            new VMGAccount("profesor","profesor1234"),
    });

    public Button forgotButton,loginButton,callButton;
    public TextInputLayout userInput,passInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        forgotButton=findViewById(R.id.forgotButton);
        loginButton=findViewById(R.id.loginButton);
        callButton=findViewById(R.id.callButton);
        userInput=findViewById(R.id.userInputLayout);
        passInput=findViewById(R.id.passInputLayout);
        forgotButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);
        callButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("EsTechApp","Touching Button");
        switch (v.getId()){
            case R.id.loginButton:
                if(verifyCredentials(userInput.getEditText().getText().toString(),passInput.getEditText().getText().toString())){
                    Log.d("esTechApp","Login credentials accepted");
                    Intent i =new Intent(this,SecondActivity.class);
                    startActivity(i);
                }else{
                    Log.d("esTechApp","Login credentials rejected");
                }
                break;
            case R.id.callButton:
                Log.d("EsTechApp","Calling");
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
                break;
            case R.id.forgotButton:


        }
    }
    public boolean verifyCredentials(String user,String pass){
        return accounts.checkLoginCredentials(user,pass);
    }
}
