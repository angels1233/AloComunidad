package com.example.comunidade;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Reclama extends AppCompatActivity {

    private CheckBox box_ent, box_fal, box_vaz, box_ou;
    private EditText descricao;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclama);

        box_ent = findViewById(R.id.check_ent);
        box_fal = findViewById(R.id.check_fal);
        box_vaz = findViewById(R.id.check_vaz);
        box_ou = findViewById(R.id.check_ou);
        descricao = findViewById(R.id.drescricao_txt);
        enviar = findViewById(R.id.enviar_bt);

        box_ent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    box_vaz.setClickable(false);
                    box_fal.setClickable(false);
                    box_ou.setClickable(false);
                } else if (isChecked == false) {
                    box_vaz.setClickable(true);
                    box_fal.setClickable(true);
                    box_ou.setClickable(true);
                }
            }});

        box_fal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    box_vaz.setClickable(false);
                    box_ent.setClickable(false);
                    box_ou.setClickable(false);
                } else if (isChecked == false) {
                    box_vaz.setClickable(true);
                    box_ent.setClickable(true);
                    box_ou.setClickable(true);
                }
            }
        });

        box_ou.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    box_vaz.setClickable(false);
                    box_fal.setClickable(false);
                    box_ent.setClickable(false);
                } else if (isChecked == false) {
                    box_vaz.setClickable(true);
                    box_fal.setClickable(true);
                    box_ent.setClickable(true);
                }
            }
        });

        box_vaz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    box_ent.setClickable(false);
                    box_fal.setClickable(false);
                    box_ou.setClickable(false);
                } else if (isChecked == false) {
                    box_ent.setClickable(true);
                    box_fal.setClickable(true);
                    box_ou.setClickable(true);
                }
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                String message = descricao.getText().toString().trim();
                String op = "";
                Location local;

                if (box_ent.isChecked()) {
                    op += "Entupimento ";

                } else if (box_fal.isChecked()) {
                    op += "Falta dágua ";

                } else if (box_vaz.isChecked()) {
                    op += "Vazamento ";

                } else if (box_ou.isChecked()) {
                    op += "Outros ";
                    if(TextUtils.isEmpty(message)){
                        Toast.makeText(Reclama.this,"Obrigado a descrição do problema!",Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                if(TextUtils.isEmpty(message)){
                    if(TextUtils.isEmpty(op)){
                        Toast.makeText(Reclama.this,"Preencha a Reclamação!",Toast.LENGTH_SHORT).show();
                        return;
                    }
                }else if(TextUtils.isEmpty(op)){
                    Toast.makeText(Reclama.this,"Selecione uma das opções!",Toast.LENGTH_SHORT).show();
                    return;
                }

                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference dbRef = db.getReference();
                FirebaseApp.initializeApp(Reclama.this);
                db = FirebaseDatabase.getInstance();
                dbRef = db.getReference();


                Reporte reporte = new Reporte();
                reporte.setId(UUID.randomUUID().toString());
                reporte.setRedacao(descricao.getText().toString());
                reporte.setTipo(op);

                dbRef.child("Reclamacao").child(reporte.getId()).setValue(reporte);
                Toast.makeText(Reclama.this,"Reclamação enviada com sucesso!",Toast.LENGTH_LONG).show();

            }


        });
    }
}