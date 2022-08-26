package com.example.rentcarspring.dao;

import com.example.rentcarspring.entity.Utente;

import java.util.List;

public interface UtenteDAO {
    void updateUtente(Utente utente);

    void deleteUtente(int id);

    List<Utente> getUtenti();

    Utente getUser(int id);

    Utente getUser(String nome);
}
