package com.example.rentcarspring.service.impl;

import com.example.rentcarspring.dao.PrenotazioneDAO;
import com.example.rentcarspring.dao.UtenteDAO;
import com.example.rentcarspring.entity.Prenotazione;
import com.example.rentcarspring.entity.Utente;
import com.example.rentcarspring.service.UtenteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteServiceImpl implements UtenteService {

    private final UtenteDAO utenteDAO;
    private final PrenotazioneDAO prenotazioneDAO;

    public UtenteServiceImpl(UtenteDAO utenteDAO, PrenotazioneDAO prenotazioneDAO) {
        this.utenteDAO = utenteDAO;
        this.prenotazioneDAO = prenotazioneDAO;
    }

    @Override
    public void updateUtente(Utente utente) {
        utenteDAO.updateUtente(utente);
    }

    @Override
    public void deleteUtente(int id) {
        utenteDAO.deleteUtente(id);
    }

    @Override
    public List<Utente> getUtenti() {
        return utenteDAO.getUtenti();
    }

    @Override
    public Utente getUser(int id) {
        return utenteDAO.getUser(id);
    }

    @Override
    public Utente getUserByEmail(String email) {
        return utenteDAO.getUserByEmail(email);
    }

    @Override
    public void approvaPrenotazione(String string, int id) {
        Prenotazione prenotazione = prenotazioneDAO.getPrenotazione(id);
        prenotazione.setApprovata(string.equals("Si"));
        prenotazioneDAO.updatePrenotazione(prenotazione);
    }


}
