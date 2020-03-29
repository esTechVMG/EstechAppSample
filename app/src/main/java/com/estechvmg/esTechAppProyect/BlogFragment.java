package com.estechvmg.esTechAppProyect;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BlogFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.blog_fragment,container,false);
        RecyclerView rv = view.findViewById(R.id.recyclerView);
        GridLayoutManager glm = new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false);
        rv.setLayoutManager(glm);
        ArrayList<BlogPost> blogPosts=new ArrayList<>();
        blogPosts.add(new BlogPost(R.string.art1_title,R.drawable.noticia_1,R.string.art1_date,R.string.art1_desc1,R.string.art1_desc2,R.string.art1_desc3,R.drawable.noticia_1_image_1,R.drawable.noticia_1_image_2));
        blogPosts.add(new BlogPost(R.string.art2_title,R.drawable.noticia_2,R.string.art2_date,R.string.art2_desc1,R.string.art2_desc2,R.string.art2_desc3,R.drawable.noticia_2_image_1,R.drawable.noticia_2_image_2));
        blogPosts.add(new BlogPost(R.string.art3_title,R.drawable.noticia_3,R.string.art3_date,R.string.art3_desc1,R.string.art3_desc2,R.string.art3_desc3,R.drawable.noticia_3_image_1,R.drawable.noticia_3_image_2));
        blogPosts.add(new BlogPost(R.string.art4_title,R.drawable.noticia_4,R.string.art4_date,R.string.art4_desc1,R.string.art4_desc2,R.string.art4_desc3,R.drawable.noticia_4_image_1,R.drawable.noticia_4_image_2));
        blogPosts.add(new BlogPost(R.string.art5_title,R.drawable.noticia_5,R.string.art5_date,R.string.art5_desc1,R.string.art5_desc2,R.string.art5_desc3,R.drawable.noticia_5_image_1,R.drawable.noticia_5_image_2));
        blogPosts.add(new BlogPost(R.string.art6_title,R.drawable.noticia_6,R.string.art6_date,R.string.art6_desc1,R.string.art6_desc2,R.string.art6_desc3,R.drawable.noticia_6_image_1,R.drawable.noticia_6_image_2));
        BlogAdapter adapter=new BlogAdapter(getContext(),blogPosts);
        rv.setAdapter(adapter);
        return view;
    }
}
