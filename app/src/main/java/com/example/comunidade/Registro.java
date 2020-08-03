package com.example.comunidade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Registro extends AppCompatActivity {
    EditText nome, email, senha;
    Button registro;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nome = findViewById(R.id.nome_ed_txt);
        email = findViewById(R.id.email_ed_txt);
        senha = findViewById(R.id.senha_ed_txt);
        registro = findViewById(R.id.registro_bt);
        login = findViewById(R.id.login_txt);
        progressBar = findViewById(R.id.progressBar2);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Email = email.getText().toString().trim();
                String password = senha.getText().toString().trim();
                final String name = nome.getText().toString().trim();
                // Teste de conteúdo das informações

                if (TextUtils.isEmpty(Email)) {
                    email.setError("Email está vazio!");
                    return;
                }
                if (TextUtils.isEmpty(name)) {
                    nome.setError("Email está vazio!");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    senha.setError("Senha está vazia!");
                    return;
                }
                if (password.length() < 6) {
                    senha.setError("Senha requer mais de 6 caracteres");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                // Registro efetico no FireBase

                fAuth.createUserWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            FirebaseDatabase db = FirebaseDatabase.getInstance();
                            DatabaseReference dbRef = db.getReference();
                            FirebaseApp.initializeApp(Registro.this);

                            User user = new User();
                            user.setId(UUID.randomUUID().toString());
                            user.setNome(name);
                            user.setEmail(Email);

                            dbRef.child("Usuario").child(user.getId()).setValue(user);

                            Toast.makeText(Registro.this,"Usuário criado com sucesso!", Toast.LENGTH_LONG).show();

                            startActivity(new Intent(getApplicationContext(),Login.class));
                        }else{
                            Toast.makeText(Registro.this,"Erro ao registrar usuário!",Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });

        /*login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }

        });*/
    }
}