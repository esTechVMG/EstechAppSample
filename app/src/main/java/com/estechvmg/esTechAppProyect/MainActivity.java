package com.estechvmg.esTechAppProyect;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public int phoneNumber=953636000;
    private VMGAccountManager accounts=new VMGAccountManager(new VMGAccount[]{
            new VMGAccount("invitado","estech1234"),
            new VMGAccount("alumno","alumno1234"),
            new VMGAccount("profesor","profesor1234"),
    });
    public SharedPreferences preferences;
    public Button forgotButton,loginButton,callButton;
    public TextInputLayout userInput,passInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        forgotButton=findViewById(R.id.forgotButton);
        loginButton=findViewById(R.id.loginButton);
        callButton=findViewById(R.id.callButton);
        userInput=findViewById(R.id.userInputLayout);
        passInput=findViewById(R.id.passInputLayout);
        forgotButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);
        callButton.setOnClickListener(this);
        userInput.getEditText().setText(preferences.getString("LAST_USER",""));
    }

    @Override
    public void onClick(View v) {
        Log.d("EsTechApp","Touching Button");
        switch (v.getId()){
            case R.id.loginButton:
                String user=userInput.getEditText().getText().toString();
                String pass=passInput.getEditText().getText().toString();
                if(user.isEmpty()){
                    userInput.setError("El campo esta vacio");
                    break;
                }
                if(pass.isEmpty()){
                    passInput.setError("El campo esta vacio");
                    break;
                }
                if(verifyCredentials(user,pass)){
                    Log.d("esTechApp","Login credentials accepted");
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putString("LAST_USER",user);
                    editor.apply();
                    Intent i =new Intent(this,SecondActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Log.d("esTechApp","Login credentials rejected");
                    loginFailedDialog();
                }
                break;
            case R.id.callButton:
                Log.d("EsTechApp","Calling");
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
                break;
            case R.id.forgotButton:
                resetPasswordDialog();
        }
    }
    public boolean verifyCredentials(String user,String pass){
        return accounts.checkLoginCredentials(user,pass);
    }
    public void loginFailedDialog(){
        AlertDialog.Builder alert = DialogCreator.createBasicDialog(this,"Error","Usuario y contraseña incorrectos.\nVuelve a intentarlo");
        alert.setNeutralButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        alert.show();
    }
    public void resetPasswordDialog(){
        AlertDialog.Builder alert= DialogCreator.createBasicDialog(this,"Atención","Escribe tu correo electronico y te mandaremos tus credenciales");
        final TextInputLayout textInputLayout=new TextInputLayout(this);
        textInputLayout.addView(new TextInputEditText(this));
        textInputLayout.setHint("Correo electronico");
        textInputLayout.setPadding(32,0,32,0);
        alert.setView(textInputLayout);

        alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String email = textInputLayout.getEditText().getText().toString();
                DummyClass.requestPasswordMailReset(email);
                String out;
                if(email.isEmpty()){
                    out="No has introducido tu correo";
                }else{
                    out="Envidado a" + email;
                }
                Toast.makeText(MainActivity.this,out, Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("cancelar", new DialogInterface.OnClickListener() {public void onClick(DialogInterface dialog, int whichButton) {}});
        alert.show();
    }
}
