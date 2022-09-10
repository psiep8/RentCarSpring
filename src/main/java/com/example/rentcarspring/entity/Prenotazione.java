package com.example.rentcarspring.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prenotazione")
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "dataInizio")
    private LocalDate dataInizio;

    @Column(name = "dataFine")
    private LocalDate dataFine;

    @Column(name = "approvata")
    private boolean approvata;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auto_id")
    private Auto auto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "utente_id")
    private Utente utente;

    public Prenotazione() {
    }

    public Prenotazione(LocalDate dataInizio, LocalDate dataFine, boolean approvata, Utente utente, Auto auto) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.approvata = approvata;
        this.utente = utente;
        this.auto = auto;
    }

    public Prenotazione(int id, LocalDate dataInizio, LocalDate dataFine, boolean approvata, Utente utente, Auto auto) {
        this.id = id;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.approvata = approvata;
        this.utente = utente;
        this.auto = auto;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public boolean isApprovata() {
        return approvata;
    }

    public void setApprovata(boolean approvata) {
        this.approvata = approvata;
    }

    @Override
    public String toString() {
        return "Prenotazione{" + "id=" + id + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine + ", approvata=" + approvata + '}';
    }
}
