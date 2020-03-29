package com.estechvmg.esTechAppProyect;

import android.os.Bundle;
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
        blogExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        imageHeader=findViewById(R.id.blogHeader);
        imageOne=findViewById(R.id.firstImage);
        imageTwo=findViewById(R.id.secondImage);
        date=findViewById(R.id.dateTextView);
        headerTittle=findViewById(R.id.tittle_textView);
        firstText=findViewById(R.id.firstTextTextView);
        secondText=findViewById(R.id.secondTextTextView);
        thirdText=findViewById(R.id.thirdTextTextView);
        Bundle b=getIntent().getExtras();
        Log.d("esTechapp","" + b.getInt("header"));
        imageHeader.setImageDrawable(getDrawable(b.getInt("header")));
        imageOne.setImageResource(b.getInt("imageOne"));
        imageTwo.setImageResource(b.getInt("imageTwo"));
        date.setText(b.getInt("date"));
        firstText.setText(b.getInt("firstText"));
        secondText.setText(b.getInt("secondText"));
        thirdText.setText(b.getInt("thirdText"));



    }
}