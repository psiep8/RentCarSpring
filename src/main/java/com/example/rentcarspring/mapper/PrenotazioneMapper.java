package com.example.rentcarspring.mapper;

import com.example.rentcarspring.dto.PrenotazioneDTO;
import com.example.rentcarspring.dto.UtenteDTO;
import com.example.rentcarspring.entity.Prenotazione;
import com.example.rentcarspring.entity.Utente;

import java.time.LocalDate;

public class PrenotazioneMapper {

    public static Prenotazione fromDTOtoEntity(PrenotazioneDTO prenotazioneDTO) {

        return new Prenotazione(LocalDate.parse(prenotazioneDTO.getDataInizio()), LocalDate.parse(prenotazioneDTO.getDataFine()), prenotazioneDTO.isApprovata());
    }

}
