package com.example.comunidade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Menu extends AppCompatActivity {
    FirebaseAnalytics mFirebaseAnalytics;
    FirebaseAuth mAuth;
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button recicle , solicita,informativo;




        mAuth = FirebaseAuth.getInstance();
        FirebaseDatabase.getInstance().getReference().child("");
        solicita = findViewById(R.id.reclama_bt);
        informativo = findViewById(R.id.informativo_bt);
        recicle = findViewById(R.id.recicla_bt);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString("message","Integração de FireBase Completa");
        mFirebaseAnalytics.logEvent("InitScreen",bundle);

        solicita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Reclama.class));
            }
        });

        informativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Informacao.class));
            }
        });

        recicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Reciclagem.class));
            }
        });

    }
}