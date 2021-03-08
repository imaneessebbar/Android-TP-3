package com.tp.exercice3;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondActivity extends Activity {
    String user ="";
    String nom_;
    String prenom_;
    String age_ ;
    String tel_ ;
    String cmp_;
    TextView sss ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Intent intznt = getIntent();
        sss = (TextView) findViewById(R.id.sss);
        String name = intznt.getStringExtra("name");
        cmp_ = intznt.getStringExtra("cmp");
        get(this , name);
        setthings();
        TextView nom = (TextView) findViewById(R.id.show_nom);
        nom.setText(nom_);
        TextView prenom = (TextView) findViewById(R.id.show_prenom);
        prenom.setText(prenom_);
        TextView age = (TextView) findViewById(R.id.show_age);
        age.setText(age_);
        TextView tel = (TextView) findViewById(R.id.show_phone);
        tel.setText(tel_);
        TextView cmp = (TextView) findViewById(R.id.show_cmp);
        cmp.setText(cmp_);

    }
    private void get(Context context, String name) {

        try {
            InputStream inputStream = context.openFileInput(name);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                user = bufferedReader.readLine();
                inputStream.close();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
    }
    void setthings(){
        String[] data = user.split(",");
        nom_= data[0];
        prenom_ = data[1];
        age_ = data[2];
        tel_ = data[3];

    }


}