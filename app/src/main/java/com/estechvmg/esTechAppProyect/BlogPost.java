package com.estechvmg.esTechAppProyect;

import android.util.Log;

public class BlogPost {
    public int tittle,image,date,textOne,textTwo,textThree,imageOne,imageTwo;
    BlogPost(int tittle,int image,int date,int textOne,int textTwo,int textThree,int imageOne,int imageTwo){
        Log.d("esTechApp",image + "/" + imageOne + "/"+ imageTwo + "/" + textOne + "/" + textTwo + "/" + textThree);
        this.tittle=tittle;
        this.image=image;
        this.date=date;
        this.textOne=textOne;
        this.textTwo=textTwo;
        this.textThree=textThree;
        this.imageOne=imageOne;
        this.imageTwo=imageTwo;
        Log.d("esTechApp",this.image + "/" + this.imageOne + "/"+ this.imageTwo + "/" + this.textOne + "/" + this.textTwo + "/" + this.textThree);
    }
}