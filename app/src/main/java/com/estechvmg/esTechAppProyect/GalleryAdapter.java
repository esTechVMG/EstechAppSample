package com.estechvmg.esTechAppProyect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class GalleryAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<Integer> listaImagenes;
    public GalleryAdapter(Context context, ArrayList<Integer> listaImagenes) {
        this.context = context;
        this.listaImagenes = listaImagenes;
    }
    @Override
    public int getCount() {
        return listaImagenes.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return object.equals(view);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View v= LayoutInflater.from(context).inflate(R.layout.image_item,container,false);
        ImageView imageView=v.findViewById(R.id.imageItem);
        imageView.setImageResource(listaImagenes.get(position));
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
