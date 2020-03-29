package com.estechvmg.esTechAppProyect;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BlogActivity extends AppCompatActivity {
    public TextView headerTittle,date,firstText,secondText,thirdText;
    public ImageView imageOne,imageTwo,imageHeader;
    public ImageButton blogExitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        blogExitButton=findViewById(R.id.blogExitButton);
        imageHeader=findViewById(R.id.blogHeader);
        imageOne=findViewById(R.id.firstImage);
        imageTwo=findViewById(R.id.secondImage);
        date=findViewById(R.id.dateTextView);
        headerTittle=findViewById(R.id.tittle_textView);
        firstText=findViewById(R.id.firstTextTextView);
        secondText=findViewById(R.id.secondTextTextView);
        thirdText=findViewById(R.id.thirdTextTextView);
        try {
            BlogPost blog=getIntent().getParcelableExtra("Blog");
            date.setText(getResources().getString(blog.date));
            firstText.setText(getResources().getString(blog.textOne));
            secondText.setText(getResources().getString(blog.textTwo));
            thirdText.setText(getResources().getString(blog.textThree));
        }catch (Exception e){
            Log.d("esTechApp","Unfixed Error");
            e.printStackTrace();
        }


    }
}