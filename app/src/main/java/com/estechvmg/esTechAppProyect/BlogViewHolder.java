package com.estechvmg.esTechAppProyect;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


public class BlogViewHolder extends RecyclerView.ViewHolder {
    public ConstraintLayout layout;
    public TextView tTittle,tDate;
    public ImageView imageBackground;
    public BlogViewHolder(@NonNull final View itemView) {
        super(itemView);
        tTittle=itemView.findViewById(R.id.tittle_textView);
        tDate=itemView.findViewById(R.id.date_textView);
        imageBackground=itemView.findViewById(R.id.imageBackground);
        layout=itemView.findViewById(R.id.blog_item_layout);
    }
}
class BlogAdapter extends RecyclerView.Adapter<BlogViewHolder>{
    private BlogPost[] blogPosts;
    private Context context;
    BlogAdapter(Context context, BlogPost[] blogPosts){
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
    public void onBindViewHolder(@NonNull final BlogViewHolder holder, int position) {
        final BlogPost thisBlog=blogPosts[position];
        holder.imageBackground.setImageResource(thisBlog.image);
        holder.tDate.setText(thisBlog.date);
        holder.tTittle.setText(thisBlog.tittle);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(holder.layout.getContext(),BlogActivity.class);
                intent.putExtra("Blog",thisBlog);
                holder.layout.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return blogPosts.length;
    }
}
