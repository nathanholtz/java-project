package com.example.demo.model;

public class Cliente {
    private int id;
    private String email,nome;

    
    public Cliente(){
        
    }
    
    public Cliente(int id, String email, String nome) {
        this.id = id;
        this.email = email;
        this.nome = nome;
    }

    public Cliente(String nome, String email){
        this.nome = nome;
        this.email = email;

    }
    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


}
