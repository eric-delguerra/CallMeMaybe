package com.example.callmemaybe;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;



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

    /* A appeler avec le bouton de la page Nouvelle lettre
    Recupère les données des input Titre et Contenu, créé un objet lettre avec les données et créé l'objet dans la Database
    Remplacer les variables titreinput et contenuinput par les vraies données des input
     */







}

