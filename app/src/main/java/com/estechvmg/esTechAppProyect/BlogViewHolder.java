package com.estechvmg.esTechAppProyect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BlogViewHolder extends RecyclerView.ViewHolder {
    TextView tTittle,tDate;
    ConstraintLayout imageBack;
    public BlogViewHolder(@NonNull View itemView) {
        super(itemView);
        tTittle=itemView.findViewById(R.id.tittle_textView);
        tDate=itemView.findViewById(R.id.date_textView);
        imageBack=itemView.findViewById(R.id.imageBackground);
    }
}
class BlogAdapter extends RecyclerView.Adapter<BlogViewHolder>{
    private List<BlogPost> blogPosts;
    private Context context;
    BlogAdapter(Context context, List<BlogPost> blogPosts){
        this.blogPosts=blogPosts;
        this.context=context;
    }
    @NonNull
    @Override
    public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.blogpost_item,parent,false);
        BlogViewHolder holder=new BlogViewHolder(v);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull BlogViewHolder holder, int position) {
        BlogPost thisBlog=blogPosts.get(position);
        holder.imageBack.setBackgroundResource(thisBlog.image);
        holder.tDate.setText(thisBlog.date);
        holder.tTittle.setText(thisBlog.tittle);
    }

    @Override
    public int getItemCount() {
        return blogPosts.size();
    }
}
