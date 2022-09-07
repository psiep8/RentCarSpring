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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "auto", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioniFromAutoItems;

    public Auto() {
    }

    public Auto(String marca, int cilindrata, String modello, List<Prenotazione> prenotazioniFromAutoItems) {

        this.marca = marca;
        this.cilindrata = cilindrata;
        this.modello = modello;
        this.prenotazioniFromAutoItems = prenotazioniFromAutoItems;
    }

    public Auto(int id, String marca, int cilindrata, String modello, List<Prenotazione> prenotazioniFromAutoItems) {
        this.id = id;
        this.marca = marca;
        this.cilindrata = cilindrata;
        this.modello = modello;
        this.prenotazioniFromAutoItems = prenotazioniFromAutoItems;
    }

    public List<Prenotazione> getPrenotazioniFromAutoItems() {
        return prenotazioniFromAutoItems;
    }

    public void setPrenotazioniFromAutoItems(List<Prenotazione> items) {
        this.prenotazioniFromAutoItems = items;
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
