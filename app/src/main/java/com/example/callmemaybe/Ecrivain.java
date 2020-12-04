package com.example.callmemaybe;

public class Ecrivain {

    public String id;
    public String mail;
    public String password;

    public Ecrivain(){

    }

    public Ecrivain(String identifiant, String email, String motdepasse){
        id=identifiant;
        mail=email;
        password=motdepasse;
    }

    public String getIdEcrivain(){
        return this.id;
    }

    public String getMail(){
        return this.mail;
    }

    public String getPassword(){
        return this.password;
    }

    public void setIDEcrivain(String i){
        this.id=i;
    }

    public void setMail(String m){
        this.mail=m;
    }

    public void setPassword(String p){
        this.password=p;
    }

}
