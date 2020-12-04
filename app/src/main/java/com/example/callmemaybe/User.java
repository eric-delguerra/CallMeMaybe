package com.example.callmemaybe;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

@IgnoreExtraProperties
public class User {

    public String id;
    public String mail;
    public String password;
    public boolean estLecteur;

    User user = new User("-KdbKcU2ptfYF2xKb5aO", "exemple@gmail.com", "aqw123");
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    public User() {

    }

    public User(String identifiant, String email, String motdepasse) {
        id = identifiant;
        mail = email;
        password = motdepasse;
        estLecteur = true;
    }

    public String getIdUser() {
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

    public void setIDUser(String i) {
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
