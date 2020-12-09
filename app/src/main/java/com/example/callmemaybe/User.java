package com.example.callmemaybe;


import android.content.Context;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;


@IgnoreExtraProperties
public class User {

    public String id;
    public String mail;
    public String password;
    public boolean estLecteur;

    //IMPORTANT : bien laisser les attributs en public sinon Firebase peut pas y accéder


    public User() {

    }

    // IMPORTANT : bien laisser le constructeur vide pour Firebase

    public User(String email, String motdepasse) {

        mail = email;
        password = motdepasse;
        estLecteur = true;

    }

    public void saveUserDB(Context context){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("User").push().setValue(this,new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                Toast.makeText(context, "User added.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String getId() {
        return this.id;
    }

    public String getMail() {
        return this.mail;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean getEstLecteur() {
        return this.estLecteur;
    }

    public void setId(String i) {
        this.id = i;
    }

    public void setMail(String m) {
        this.mail = m;
    }

    public void setPassword(String p) {
        this.password = p;
    }

    public void setEstLecteur(boolean b) {
        this.estLecteur = b;
    }


}
