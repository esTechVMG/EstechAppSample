package com.estechvmg.esTechAppProyect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {
    Context context;
    VMGCardView[] list;
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
    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        itemText=itemView.findViewById(R.id.text_cardView);
        imageView=itemView.findViewById(R.id.icon_cardView);

    }
}
class VMGCardView {
    int text,icon;
    VMGCardView(int text,int icon){
        this.text=text;
        this.icon=icon;
    }
}
