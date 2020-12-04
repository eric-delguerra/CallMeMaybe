package com.example.callmemaybe;

public class Lecteur {

    public String id;
    public String mail;
    public String password;

    public Lecteur(){

    }

    public Lecteur(String identifiant, String email, String motdepasse){
        id=identifiant;
        mail=email;
        password=motdepasse;
    }

    public String getIdLecteur(){
        return this.id;
    }

    public String getMail(){
        return this.mail;
    }

    public String getPassword(){
        return this.password;
    }

    public void setIDLecteur(String i){
        this.id=i;
    }

    public void setMail(String m){
        this.mail=m;
    }

    public void setPassword(String p){
        this.password=p;
    }

}

