package com.example.rentcarspring.service;

import com.example.rentcarspring.dao.PrenotazioneDAO;
import com.example.rentcarspring.dto.PrenotazioneDTO;
import com.example.rentcarspring.entity.Prenotazione;
import com.example.rentcarspring.mapper.PrenotazioneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {
    @Autowired
    PrenotazioneDAO prenotazioneDAO;

    @Override
    public void updatePrenotazione(PrenotazioneDTO prenotazione) {
        prenotazioneDAO.updatePrenotazione(PrenotazioneMapper.fromDTOtoEntity(prenotazione));
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
