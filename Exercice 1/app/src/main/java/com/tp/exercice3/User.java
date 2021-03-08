package com.tp.exercice3;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;

public class User implements Parcelable {
    public int id;
    public String nom;
    public String prenom;
    public int age;
    public String tel;


    public User( ){
        this.nom = "";
        this.prenom = "";
        this.age = 0;
        this.tel = "";
    }

    public User( String nom, String prenom, int age, String tel){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.tel = tel;
    }

    protected User(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        prenom = in.readString();
        age = in.readInt();
        tel = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String toString(){
        return "user : @"+  this.id+"\n \t Nom: "+this.nom + "\n \t Prenom: "+this.prenom +"\n \t Age :"+this.age+"\n \t Telephone :"+this.tel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nom);
        dest.writeString(prenom);
        dest.writeInt(age);
        dest.writeString(tel);
    }
}

