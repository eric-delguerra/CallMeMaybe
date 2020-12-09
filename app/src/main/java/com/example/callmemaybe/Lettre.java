package com.example.callmemaybe;

public class Lettre {

    public String id;
    public String titre;
    public String contenu;
    public int note;
    public String commentaire;
    public boolean valid;


    public Lettre(){

    }

    public Lettre(String title, String content){


        titre=title;
        contenu=content;
        note=0;
        commentaire=null;
        valid=true;
    }

    public String getId(){
        return this.id;
    }

    public String getTitre(){
        return this.titre;
    }

    public String getContenu(){
        return this.contenu;
    }

    public int getNote(){
        return this.note;
    }

    public String getCommentaire(){
        return this.commentaire;
    }

    public void setId(String i){
        this.id=i;
    }

    public void setTitre(String t){
        this.titre=t;
    }

    public void setContenu(String c){
        this.contenu=c;
    }

    public void setNote(int n){
        this.note=n;
    }

    public void setCommentaire(String com){
        this.commentaire=com;
    }
}
