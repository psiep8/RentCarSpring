package com.example.rentcarspring.service;

import com.example.rentcarspring.dao.UtenteDAO;
import com.example.rentcarspring.dto.UtenteDTO;
import com.example.rentcarspring.entity.Utente;
import com.example.rentcarspring.mapper.UtenteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteServiceImpl implements UtenteService {

    @Autowired
    UtenteDAO utenteDAO;

    @Override
    public void updateUtente(UtenteDTO utente) {
        utenteDAO.updateUtente(UtenteMapper.fromDTOtoEntity(utente));
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
    public Utente getUser(String nome) {
        return utenteDAO.getUser(nome);
    }
}
