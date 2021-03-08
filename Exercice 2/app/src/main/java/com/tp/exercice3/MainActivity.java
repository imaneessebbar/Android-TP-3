package com.tp.exercice3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int id ;
    User user = new User();
    EditText prenom ;
    EditText nom ;
    EditText age ;
    TextView id_v;
    EditText tel ;
    EditText pass ;
    String x;
    String nom_;
    String prenom_;
    String age_;
    String tel_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prenom = (EditText) findViewById(R.id.user_prenom);
        nom = (EditText) findViewById(R.id.user_nom);
        age = (EditText) findViewById(R.id.user_age);
        tel = (EditText) findViewById(R.id.user_phone);
        pass = (EditText) findViewById(R.id.user_pass);

        id_v = (TextView) findViewById(R.id.id);

        if ((savedInstanceState != null) &&(savedInstanceState.containsKey("id"))&&(savedInstanceState.containsKey("nom"))&&(savedInstanceState.containsKey("prenom")) &&(savedInstanceState.containsKey("age"))&&(savedInstanceState.containsKey("tel"))){
            id = savedInstanceState.getInt("id");
            prenom_ = savedInstanceState.getString("prenom");
            prenom.setText(savedInstanceState.getString("prenom"));
            nom_ = savedInstanceState.getString("nom");
            nom.setText(savedInstanceState.getString("nom"));
            age_ = savedInstanceState.getString("age");
            age.setText(savedInstanceState.getString("age"));
            tel_ = savedInstanceState.getString("tel");
            tel.setText(savedInstanceState.getString("tel"));
            id_v.setText("old id : "+id);
        }else{
            id = generateId();
            id_v.setText("new generated id :"+id);
        }
        Button button = (Button) findViewById(R.id.valider_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nom.getText().toString()+ id ;
                save(name,MainActivity.this);
                try{Thread.sleep(5000);}catch(InterruptedException e){System.out.println(e);}
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
               // i.putExtra("id",id);
                i.putExtra("name",name);
                /*i.putExtra("nom",nom.getText().toString());
                i.putExtra("prenom",prenom.getText().toString());
                i.putExtra("age",age.getText().toString());
                i.putExtra("tel",tel.getText().toString());*/
                startActivity(i);

            }
        });
    }

    private void save(String name, Context context) {
        Button x = (Button) findViewById(R.id.valider_button);
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(name, Context.MODE_APPEND));
            nom_ = nom.getText().toString();
            prenom_ = prenom.getText().toString();
            age_ = age.getText().toString();
            tel_ = tel.getText().toString();
            outputStreamWriter.write(nom_+","+prenom_+","+age_+","+tel_);
            outputStreamWriter.close();
            /* Toast toast=Toast.makeText(this,"user saved" , Toast.LENGTH_LONG);
            toast.show();*/
            x.setText("saved");

        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
            /* Toast toast=Toast.makeText(this,"user not saved" , Toast.LENGTH_LONG);
            toast.show();*/
            x.setText("not saved");
        }
    }
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("id",id);
        savedInstanceState.putString("nom",nom.getText().toString());
        savedInstanceState.putString("prenom",prenom.getText().toString());
        savedInstanceState.putString("tel",tel.getText().toString());
        savedInstanceState.putString("age",age.getText().toString());

    }
    protected int generateId(){
        Random random = new Random();
        return random.nextInt();
    }
    /*void startIntent(){
        Intent intent = new Intent(this, OkActivity.class);
        intent.putExtra("id",id);
        intent.putExtra("nom",nom.getText().toString());
        intent.putExtra("prenom",prenom.getText().toString());
        intent.putExtra("age",age.getText().toString());
        intent.putExtra("tel",tel.getText().toString());
        startActivity(intent);

    }*/
}