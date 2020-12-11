package com.example.callmemaybe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivityLecteur extends AppCompatActivity {
    private DatabaseReference myDataBase ;
    EditText editText;
    ListView list2 ;
    RatingBar rating;
    ArrayAdapter adapter;
    String idActuelle;
    int indexGeneral;
    Lettre[] touteLesLettres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lecteur);
        editText = findViewById(R.id.editTextTextMultiLine2);
        list2 = findViewById(R.id.listeViewLecteur);
        rating = findViewById(R.id.ratingBar);

        myDataBase= FirebaseDatabase.getInstance().getReference();


        // On va chercher l'ensemble des données qui sont dans Lettre
        myDataBase.child("Lettre").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot ensembleDesLettres) {

                // On verifie si il y a des données
                if(ensembleDesLettres.exists()){

                    int nbr = (int) ensembleDesLettres.getChildrenCount();
                    String[] listLettre = new String[nbr];
                    int index = nbr - 1;
                    touteLesLettres = new Lettre[nbr];
                    String[] listId = new String[nbr];


                    // On va regarder chaque donnée par lettre
                    for (DataSnapshot dataSnapshot : ensembleDesLettres.getChildren()) {

                        Lettre lettre = dataSnapshot.getValue(Lettre.class);
                        listId[index] = dataSnapshot.getKey();
                        listLettre[index] = lettre.titre;
                        touteLesLettres[index] = lettre;
                        touteLesLettres[index].setId(dataSnapshot.getKey());

                       // set les visuels
                        editText.setText(lettre.contenu);
                        rating.setRating((float) lettre.note);
                        idActuelle = dataSnapshot.getKey();
                        indexGeneral = index;
                        index--;
                    }


                    adapter = new ArrayAdapter(MainActivityLecteur.this, android.R.layout.simple_list_item_1, android.R.id.text1, listLettre);
                    list2.setAdapter(adapter);

                    list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Toast.makeText(getApplicationContext(), touteLesLettres[i].contenu, Toast.LENGTH_LONG).show();
                            editText.setText(touteLesLettres[i].contenu);
                            indexGeneral = i;

                        }
                    });


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

               rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float note, boolean fromUser) {
//                Log.d("Test note", "La note actuelle est : " + note);
//                Log.d("Test IndexGeneral", "L'index général est : " + indexGeneral);
//                Log.d("Test objet", "L'objet lettre est le bon : " + touteLesLettres[indexGeneral]);
//                touteLesLettres[indexGeneral].setNote(note);
//                Log.d("Test ListId + " , touteLesLettres[indexGeneral].getId());
//                DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
//                DatabaseReference yourRef = rootRef.child("Lettre").child(touteLesLettres[indexGeneral].getId()).child("note");
//                yourRef.setValue(note);
                Toast.makeText(getApplicationContext(), "Votre note a bien été prise en compte", Toast.LENGTH_LONG).show();
            }
        });

    }
}