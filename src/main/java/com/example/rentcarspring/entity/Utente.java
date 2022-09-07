package com.example.rentcarspring.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "utente", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "dataNascita")
    private LocalDate dataNascita;

    @Column(name = "customer")
    private boolean customer;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "utente", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioniFromUtenteItems;

    public Utente() {
    }

    public Utente(int id, String nome, String cognome, String password, String email, String telefono, LocalDate dataNascita, boolean customer, List<Prenotazione> prenotazioniFromUtenteItems) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
        this.dataNascita = dataNascita;
        this.customer = customer;
        this.prenotazioniFromUtenteItems = prenotazioniFromUtenteItems;
    }

    public Utente(String nome, String cognome, String password, String email, String telefono, LocalDate dataNascita, boolean customer, List<Prenotazione> prenotazioniFromUtenteItems) {
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
        this.dataNascita = dataNascita;
        this.customer = customer;
        this.prenotazioniFromUtenteItems = prenotazioniFromUtenteItems;
    }

    public List<Prenotazione> getPrenotazioniFromUtenteItems() {
        return prenotazioniFromUtenteItems;
    }

    public void setPrenotazioniFromUtenteItems(List<Prenotazione> items) {
        this.prenotazioniFromUtenteItems = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public boolean isCustomer() {
        return customer;
    }

    public void setCustomer(boolean customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Utente{" + "id=" + id + ", nome='" + nome + '\'' + ", cognome='" + cognome + '\'' + ", password='" + password + '\'' + ", email='" + email + '\'' + ", telefono='" + telefono + '\'' + ", dataNascita=" + dataNascita + ", customer=" + customer + '}';
    }
}
