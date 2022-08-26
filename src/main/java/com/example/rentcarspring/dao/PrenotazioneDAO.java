package com.example.rentcarspring.dao;

import com.example.rentcarspring.entity.Prenotazione;

import java.util.List;

public interface PrenotazioneDAO {
    void updatePrenotazione(Prenotazione prenotazione);

    void deletePrenotazione(int id);

    List<Prenotazione> getPrenotazioni();

    Prenotazione getPrenotazione(int id);
}
