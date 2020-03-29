package com.estechvmg.esTechAppProyect;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ContactFragment extends Fragment {
    public RecyclerView rv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.contact_fragment,container,false);
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
}
