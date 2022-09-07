package com.example.rentcarspring.mapper;

import com.example.rentcarspring.controller.PrenotazioneController;
import com.example.rentcarspring.dao.AutoDAO;
import com.example.rentcarspring.dao.PrenotazioneDAO;
import com.example.rentcarspring.dao.UtenteDAO;
import com.example.rentcarspring.dao.impl.AutoDAOImpl;
import com.example.rentcarspring.dao.impl.UtenteDAOImpl;
import com.example.rentcarspring.dto.PrenotazioneDTO;
import com.example.rentcarspring.dto.UtenteDTO;
import com.example.rentcarspring.entity.Auto;
import com.example.rentcarspring.entity.Prenotazione;
import com.example.rentcarspring.entity.Utente;

import java.time.LocalDate;

public class PrenotazioneMapper {

    public static Prenotazione fromDTOtoEntity(PrenotazioneDTO prenotazioneDTO) {
        UtenteDAO u = new UtenteDAOImpl();
        AutoDAO a = new AutoDAOImpl();

        Utente utente = u.getUser(prenotazioneDTO.getIdUtente());
        Auto auto = a.getAuto(prenotazioneDTO.getIdAuto());
        return new Prenotazione(LocalDate.parse(prenotazioneDTO.getDataInizio()), LocalDate.parse(prenotazioneDTO.getDataFine()), prenotazioneDTO.isApprovata(), utente, auto);
    }

}
