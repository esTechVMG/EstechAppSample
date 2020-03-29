package com.estechvmg.esTechAppProyect;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;

public class ContactFragment extends Fragment {
    public TextInputLayout name,email,phone,message;
    public RecyclerView rv;
    public Button sendButton;
    public CheckBox checkForm;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.contact_fragment,container,false);
        sendButton=view.findViewById(R.id.formAccept);
        name=view.findViewById(R.id.formName);
        email=view.findViewById(R.id.formMail);
        phone=view.findViewById(R.id.formPhone);
        message=view.findViewById(R.id.formMessage);
        checkForm=view.findViewById(R.id.formTerms);
        checkForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendButton.setEnabled(checkForm.isChecked());
            }
        });
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formCheck();
            }
        });
        rv=view.findViewById(R.id.cardRecycler);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        VMGCardView[] cards=new VMGCardView[]{
                new VMGCardView(R.string.location,R.drawable.ic_location),
                new VMGCardView(R.string.mail_info,R.drawable.ic_mail),
                new VMGCardView(R.string.mail_secretaria,R.drawable.ic_mail),
                new VMGCardView(R.string.phone,R.drawable.ic_smartphone),
                new VMGCardView(R.string.whatsapp,R.drawable.ic_whatsapp)
        };
        rv.setAdapter(new CardAdapter(getContext(),cards));

        return view;
    }

    private void formCheck(){
        boolean e=true;
        final String formName=getTextFromTextLayout(name);
        if(formName.isEmpty()){
            name.setError("Rellena este campo");
            e=false;
        }
        final String formEmail=getTextFromTextLayout(email);
        if(formEmail.isEmpty()){
            email.setError("Rellena este campo");
            e=false;
        }
        final String formPhone=getTextFromTextLayout(phone);
        if(formPhone.isEmpty()){
            phone.setError("Rellena este campo");
            e=false;
        }
        final String formMessage=getTextFromTextLayout(message);
        if(formMessage.isEmpty()){
            message.setErrorEnabled(true);
            message.setError("Rellena este campo");
            e=false;
        }
        if(e){
            DialogCreator.createBasicDialog(getContext(),"Atención","Vas a enviar estos datos por correo electronico. ¿Estas seguro?")
                    .setPositiveButton("aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i=new Intent(Intent.ACTION_SENDTO);
                            i.putExtra(Intent.EXTRA_SUBJECT,"Formulario de Contacto");
                            i.putExtra(Intent.EXTRA_EMAIL,new String[]{"info@escuelaestech.es","secretaria@escuelaestech.es"});
                            i.putExtra(Intent.EXTRA_TEXT,"Nombre: " + formName + "\nTelefono:" + formPhone + "\nCorreo:" + formEmail + "\nMensaje:" + formMessage);
                            startActivity(Intent.createChooser(i, "Send Email"));
                        }
                    }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            }).setCancelable(false).show();
        }
    }
    private String getTextFromTextLayout(TextInputLayout in){
        return in.getEditText().getText().toString();
    }

}
