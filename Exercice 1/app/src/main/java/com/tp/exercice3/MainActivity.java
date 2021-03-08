package com.tp.exercice3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int id ;
    User user = new User();
    EditText prenom ;
    EditText nom ;
    EditText age ;
    EditText tel ;
    EditText pass ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prenom = (EditText) findViewById(R.id.user_prenom);
        nom = (EditText) findViewById(R.id.user_nom);
        age = (EditText) findViewById(R.id.user_age);
        tel = (EditText) findViewById(R.id.user_phone);
        pass = (EditText) findViewById(R.id.user_pass);

        TextView id_v = (TextView) findViewById(R.id.id);

        if ((savedInstanceState != null) &&(savedInstanceState.containsKey("id"))&&(savedInstanceState.containsKey("nom"))&&(savedInstanceState.containsKey("prenom")) &&(savedInstanceState.containsKey("age"))&&(savedInstanceState.containsKey("tel"))){
            id = savedInstanceState.getInt("id");
            prenom.setText(savedInstanceState.getString("prenom"));
            nom.setText(savedInstanceState.getString("nom"));
            age.setText(savedInstanceState.getString("age"));
            tel.setText(savedInstanceState.getString("tel"));
            id_v.setText("old id : "+id);
        }else{
            id = generateId();
            id_v.setText("new generated id :"+id);
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
}