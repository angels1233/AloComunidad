package com.example.comunidade;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

public class Reciclagem extends AppCompatActivity {
    TextView describe;
    Button bt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciclagem);

        bt = findViewById(R.id.bt);
        describe = findViewById(R.id.drescricao_txt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Registro.class));
            }
        });


    }

}