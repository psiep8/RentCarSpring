package com.example.rentcarspring.service.impl;

import com.example.rentcarspring.dao.PrenotazioneDAO;
import com.example.rentcarspring.entity.Prenotazione;
import com.example.rentcarspring.service.PrenotazioneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {
    private final PrenotazioneDAO prenotazioneDAO;

    public PrenotazioneServiceImpl(PrenotazioneDAO prenotazioneDAO) {
        this.prenotazioneDAO = prenotazioneDAO;
    }

    @Override
    public void updatePrenotazione(Prenotazione prenotazione) {
        prenotazioneDAO.updatePrenotazione(prenotazione);
    }

    @Override
    public void deletePrenotazione(int id) {
        prenotazioneDAO.deletePrenotazione(id);
    }

    @Override
    public List<Prenotazione> getPrenotazioni() {
        return prenotazioneDAO.getPrenotazioni();
    }

    @Override
    public Prenotazione getPrenotazione(int id) {
        return prenotazioneDAO.getPrenotazione(id);
    }
}
