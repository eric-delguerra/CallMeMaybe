package com.example.callmemaybe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    Button bouton;
    CheckBox choix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bouton = findViewById(R.id.button1);
        choix = findViewById(R.id.choixRole);


        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                if(choix.isChecked() == false){
                       i = new Intent(MainActivity.this,MainActivityLecteur.class);
                    startActivity(i);
                }else{
                    i = new Intent(MainActivity.this,MainActivityEcrivain.class);
                    startActivity(i);
                }
            }
        });
    }
}

