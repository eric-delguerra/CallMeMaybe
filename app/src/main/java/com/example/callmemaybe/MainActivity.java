package com.example.callmemaybe;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User numero1 = new User("tom@tom.tom", "tomtom");
        numero1.saveUserDB(this);
    }

    /* A appeler avec le bouton de la page Nouvelle lettre
    Recupère les données des input Titre et Contenu, créé un objet lettre avec les données et créé l'objet dans la Database
    Remplacer les variables titreinput et contenuinput par les vraies données des input
     */
    public void onClickButtonLettre () {

        String titreinput=null;
        String contenuinput=null;
        Lettre obj = new Lettre(titreinput,contenuinput);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference lettreRef = database.getReference("https://jecrisdubonheur.firebaseio.com/").child("Lettre").push();




    }






}

