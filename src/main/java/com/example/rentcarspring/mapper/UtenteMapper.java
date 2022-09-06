package com.example.rentcarspring.mapper;

import com.example.rentcarspring.dto.UtenteDTO;
import com.example.rentcarspring.entity.Utente;

import java.time.LocalDate;

public class UtenteMapper {
    public static Utente fromDTOtoEntity(UtenteDTO utenteDTO) {
        return new Utente(
                utenteDTO.getNome(), utenteDTO.getCognome(), utenteDTO.getPassword(), utenteDTO.getEmail(), utenteDTO.getTelefono(), LocalDate.parse(utenteDTO.getDataNascita()), utenteDTO.isCustomer());

    }
}
