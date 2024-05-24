package com.test.model;


public class Prodotto {
    private int prodottoId;
    private String name;
    private String description;
    private double price;
    private int stock;
    private int utenteId;
    
    public int getUtenteId() {
        return utenteId;
    }

    public void setUtenteId(int utenteId) {
        this.utenteId = utenteId;
    }

    public Prodotto(int prodottoId, String description, String name, double price, int stock, int utenteId) {
        this.prodottoId = prodottoId;
        this.description = description;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.utenteId = utenteId;
    }

    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProdottoId() {
        return prodottoId;
    }
    public void setId(int prodottoId) {
        this.prodottoId = prodottoId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
   
    @Override
    public String toString() {
        return "Prodotto{" +
                "prodottoId=" + prodottoId +
                ", description='" + description + '\'' +
                ", nome='" + name + '\'' +
                ", price='" + price + '\'' +
                ", stock='" + stock + '\'' +
                ", utenteId='" + utenteId + '\'' +
                '}';
    }

    public String printProduct() {
        return  "Prodotto{" +
                " description='" + description + '\'' +
                ", nome='" + name + '\'' +
                ", price='" + price + '\'' +
                ", stock='" + stock + '\'' +
                ", utenteId='" + utenteId + '\'' +
                '}';
    }
}
