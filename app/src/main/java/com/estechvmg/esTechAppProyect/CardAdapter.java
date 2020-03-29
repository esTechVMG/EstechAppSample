package com.estechvmg.esTechAppProyect;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.CheckedOutputStream;

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {
    Context context;
    VMGCardView[] list;
    int id=0;
    CardAdapter(Context context,VMGCardView[] list){
        this.list=list;
        this.context=context;
    }
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.cardview_item,parent,false);
        CardViewHolder holder= new CardViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        VMGCardView thisCard=list[position];
        holder.itemText.setText(thisCard.text);
        holder.imageView.setImageResource(thisCard.icon);

    }


    @Override
    public int getItemCount() {
        return list.length;
    }
}
class CardViewHolder extends RecyclerView.ViewHolder {
    AppCompatTextView itemText;
    ImageView imageView;
    CardView mainLayout;
    public CardViewHolder(@NonNull final View itemView) {
        super(itemView);
        itemText=itemView.findViewById(R.id.text_cardView);
        imageView=itemView.findViewById(R.id.icon_cardView);
        mainLayout=itemView.findViewById(R.id.mainCardView);
        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                switch (getLayoutPosition()){
                    case 0:
                        Log.d("esTechApp","Cardview 1");
                        i=new Intent(Intent.ACTION_SEND);
                        i.setData(Uri.parse("geo:8.0942316,-3.6332463"));
                        itemView.getContext().startActivity(Intent.createChooser(i, "Location"));
                        break;
                    case 1:
                        i=new Intent(Intent.CATEGORY_APP_EMAIL);
                        i.setType("text/html");
                        i.putExtra(Intent.EXTRA_EMAIL,"info@escuelaestech.es");
                        itemView.getContext().startActivity(Intent.createChooser(i, "Send Email"));
                        Log.d("esTechApp","Cardview 2");
                        break;
                    case 2:
                        Log.d("esTechApp","Cardview 1");
                        i=new Intent(Intent.CATEGORY_APP_EMAIL);
                        i.setType("text/html");
                        i.putExtra(Intent.EXTRA_EMAIL,"secretaria@escuelaestech.es");
                        itemView.getContext().startActivity(Intent.createChooser(i, "Send Email"));
                        Log.d("esTechApp","Cardview 3");
                        break;
                    case 3:
                        i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:953636000"));
                        itemView.getContext().startActivity(i);
                        Log.d("esTechApp","Cardview 4");
                        break;
                    case 4:
                        String url = "https://api.whatsapp.com/send?phone=+35-953-63-60-00";
                        i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        itemView.getContext().startActivity(i);
                        Log.d("esTechApp","Cardview 5");
                        break;
                }
            }
        });
    }
}
class VMGCardView {
    int text,icon;
    VMGCardView(int text,int icon){
        this.text=text;
        this.icon=icon;
    }
}
