package com.example.comunidade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText email, senha;
    Button login;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
    TextView registro, senha_red;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email_ed_txt);
        login = findViewById(R.id.bt_entrar);
        senha = findViewById(R.id.senha_ed_txt);
        progressBar = findViewById(R.id.progressBar);
        registro = findViewById(R.id.criar_vi_txt);
        senha_red = findViewById(R.id.redefinir_vi_txt);
        fAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString().trim();
                String password = senha.getText().toString().trim();

                // Teste de conteúdo das informações

                if (TextUtils.isEmpty(Email)) {
                    email.setError("Email está vazio!");
                    return;
                } else if (TextUtils.isEmpty(password)) {
                    senha.setError("Senha está vazia!");
                    return;
                } else if (password.length() < 6) {
                    senha.setError("Senha requer mais de 6 caracteres");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(Email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show();
                            //Entra na área da aplicação
                            startActivity(new Intent(getApplicationContext(), Menu.class));
                            progressBar.setVisibility(View.GONE);
                        } else {
                            Toast.makeText(Login.this, "Falha na conexão!", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        /*registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Registro.class));
            }
        });*/

        /*senha_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText resetMail = new EditText(v.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Restaurar senha?");
                passwordResetDialog.setMessage("Entre com o email para receber o link para restaurar senha!");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Restaurar senha com o email
                        String email = resetMail.getText().toString();
                        fAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Login.this, "Link de restauração enviado!",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login.this,"Erro ao enviar o link!"+ e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                passwordResetDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //fecha o dialogo
                    }
                });
                passwordResetDialog.create().show();
            }
        });*/

    }
}

