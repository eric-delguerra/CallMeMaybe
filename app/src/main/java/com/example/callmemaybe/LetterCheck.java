package com.example.callmemaybe;

public class LetterCheck {
    private String[] keywords = {"connard", "con", "pd", "pédé", "mort", "butter", "salop"};

    public LetterCheck(String letterContent){
        checkLetterContent(letterContent);
    }

    private void checkLetterContent(String content){
        String search  = "salop";

        if (content.toLowerCase().contains(search.toLowerCase())) {

            System.out.println("I found the keyword");

        } else {

            System.out.println("not found");

        }
    }


}