package com.example.rentcarspring.mapper;

import com.example.rentcarspring.dao.AutoDAO;
import com.example.rentcarspring.dao.UtenteDAO;
import com.example.rentcarspring.dao.impl.AutoDAOImpl;
import com.example.rentcarspring.dao.impl.UtenteDAOImpl;
import com.example.rentcarspring.dto.PrenotazioneDTO;
import com.example.rentcarspring.entity.Auto;
import com.example.rentcarspring.entity.Prenotazione;
import com.example.rentcarspring.entity.Utente;

import java.time.LocalDate;

public class PrenotazioneMapper {

    private static UtenteDAO u = new UtenteDAOImpl();
    private static AutoDAO a = new AutoDAOImpl();

    public PrenotazioneMapper(UtenteDAO u, AutoDAO a) {
        this.u = u;
        this.a = a;
    }

    public static Prenotazione fromDTOtoEntity(PrenotazioneDTO prenotazioneDTO) {
        Utente utente = u.getUser(prenotazioneDTO.getIdUtente());
        Auto auto = a.getAuto(prenotazioneDTO.getIdAuto());
        return new Prenotazione(
                prenotazioneDTO.getId(),
                LocalDate.parse(prenotazioneDTO.getDataInizio()),
                LocalDate.parse(prenotazioneDTO.getDataFine()),
                prenotazioneDTO.isApprovata(),
                utente,
                auto);
    }

}
