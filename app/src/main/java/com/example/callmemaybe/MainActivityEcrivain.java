package com.example.callmemaybe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivityEcrivain extends AppCompatActivity {

    Button button2;
    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ecrivain);

        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tonEdit2 = (EditText)findViewById(R.id.editTextTextMultiLine3);
                String titreinput=tonEdit2.getText().toString();
                EditText tonEdit = (EditText)findViewById(R.id.editTextTextMultiLine2);
                String contenuinput=tonEdit.getText().toString();
                Lettre obj = new Lettre(titreinput,contenuinput);
                DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                DatabaseReference yourRef = rootRef.child("Lettre").push();
                yourRef.setValue(obj);
                obj.setId(yourRef.getKey());
                tonEdit.setText("");
                tonEdit2.setText("");
                Toast.makeText(MainActivityEcrivain.this, "Message envoyé", Toast.LENGTH_LONG).show();
            }
        });


    }

}