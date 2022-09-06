package com.example.rentcarspring.service;

import com.example.rentcarspring.dto.UtenteDTO;
import com.example.rentcarspring.entity.Utente;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UtenteService {
    void updateUtente(UtenteDTO utente);

    void deleteUtente(int id);

    List<Utente> getUtenti();

    Utente getUser(int id);

    Utente getUserByEmail(String email);

}
