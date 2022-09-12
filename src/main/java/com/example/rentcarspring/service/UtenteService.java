package com.example.rentcarspring.service;

import com.example.rentcarspring.entity.Utente;

import java.util.List;

public interface UtenteService {
    void updateUtente(Utente utente);

    void deleteUtente(int id);

    List<Utente> getUtenti();

    Utente getUser(int id);

    Utente getUserByEmail(String email);

    void approvaPrenotazione(String string, int id);

}
