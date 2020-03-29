package com.estechvmg.esTechAppProyect;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class BlogPost implements Parcelable {
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

    protected BlogPost(Parcel in) {
        tittle = in.readInt();
        image = in.readInt();
        date = in.readInt();
        textOne = in.readInt();
        textTwo = in.readInt();
        textThree = in.readInt();
        imageOne = in.readInt();
        imageTwo = in.readInt();
    }

    public static final Creator<BlogPost> CREATOR = new Creator<BlogPost>() {
        @Override
        public BlogPost createFromParcel(Parcel in) {
            return new BlogPost(in);
        }

        @Override
        public BlogPost[] newArray(int size) {
            return new BlogPost[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(tittle);
        dest.writeInt(image);
        dest.writeInt(date);
        dest.writeInt(textOne);
        dest.writeInt(textTwo);
        dest.writeInt(textThree);
        dest.writeInt(imageOne);
        dest.writeInt(imageTwo);
    }
}