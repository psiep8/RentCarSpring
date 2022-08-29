package com.example.rentcarspring.service;

import com.example.rentcarspring.dto.PrenotazioneDTO;
import com.example.rentcarspring.entity.Prenotazione;

import java.util.List;

public interface PrenotazioneService {
    void updatePrenotazione(PrenotazioneDTO prenotazioneDTO);

    void deletePrenotazione(int id);

    List<Prenotazione> getPrenotazioni();

    Prenotazione getPrenotazione(int id);
}
