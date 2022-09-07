package com.example.rentcarspring.mapper;

import com.example.rentcarspring.dao.UtenteDAO;
import com.example.rentcarspring.dao.impl.UtenteDAOImpl;
import com.example.rentcarspring.dto.UtenteDTO;
import com.example.rentcarspring.entity.Utente;
import com.example.rentcarspring.service.UtenteService;

import java.time.LocalDate;

public class UtenteMapper {
    public static Utente fromDTOtoEntity(UtenteDTO utenteDTO) {

        UtenteDAO ud = new UtenteDAOImpl();
        Utente u = ud.getUser(utenteDTO.getId());
        return new Utente(
                utenteDTO.getNome(), utenteDTO.getCognome(), utenteDTO.getPassword(), utenteDTO.getEmail(), utenteDTO.getTelefono(), LocalDate.parse(utenteDTO.getDataNascita()), utenteDTO.isCustomer(), u.getPrenotazioniFromUtenteItems());

    }
}
