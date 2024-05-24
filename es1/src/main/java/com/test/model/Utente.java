package com.test.model;

public class Utente {
    private int utenteId;
    private String nome;
    private String email;
    private String password;
    private double balance;

    public Utente(int utenteId, String nome, String email, String password, double balance) {
        this.utenteId = utenteId;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Getters and Setters
    public int getUtenteId() {
        return utenteId;
    }

    public void seUtentetId(int utenteId) {
        this.utenteId = utenteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "utenteId=" + utenteId +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
