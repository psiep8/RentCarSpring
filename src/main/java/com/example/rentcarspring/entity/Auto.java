package com.example.rentcarspring.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "auto")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "cilindrata")
    private int cilindrata;

    @Column(name = "modello")
    private String modello;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "utente", cascade = CascadeType.ALL)
    private List<Prenotazione> items;

    public Auto() {
    }

    public Auto(String marca, int cilindrata, String modello) {

        this.marca = marca;
        this.cilindrata = cilindrata;
        this.modello = modello;
    }

    public Auto(int id, String marca, int cilindrata, String modello) {
        this.id = id;
        this.marca = marca;
        this.cilindrata = cilindrata;
        this.modello = modello;
    }

    public List<Prenotazione> getItems() {
        return items;
    }

    public void setItems(List<Prenotazione> items) {
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    @Override
    public String toString() {
        return "Auto{" + "id=" + id + ", marca='" + marca + '\'' + ", cilindrata=" + cilindrata + ", modello='" + modello + '\'' + '}';
    }
}
