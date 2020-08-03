package com.example.comunidade;

public class User {
    private String email;
    private String nome;
    private String id;

    public  User(){
    }
    public  User(String email, String nome, String id){
        this.email = email;
        this.nome = nome;

        this.id = id;
    }
    public  String getEmail(){
        return email;
    }
    public  String getNome(){
        return nome;
    }
    public  void setEmail(String email){
        this.email = email;
    }
    public  void setNome(String nome){
        this.nome = nome;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
