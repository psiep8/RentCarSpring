package com.example.rentcarspring.controller;

import com.example.rentcarspring.entity.Prenotazione;
import com.example.rentcarspring.entity.Utente;
import com.example.rentcarspring.service.PrenotazioneService;
import com.example.rentcarspring.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;


    @GetMapping("/listPrenotazioni")
    public String listPrenotazioni(@RequestParam("utenteId") int id, Model model) {
        Utente utente = utenteService.getUser(id);
        List<Prenotazione> prenotazioneList = utente.getItems();
        model.addAttribute("prenotazioni", prenotazioneList);
        return "list-prenotazioni";
    }

    @GetMapping("/")
    public String listUtenti(Model model) {
        List<Utente> utenteList = utenteService.getUtenti();
        model.addAttribute("utenti", utenteList);
        return "admin";
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {
        Utente utente = new Utente();
        model.addAttribute("utente", utente);
        return "utente-form";
    }

    @GetMapping("/updateForm")
    public String updateForm(@RequestParam("utenteId") int id, Model model) {
        Utente utente = utenteService.getUser(id);
        model.addAttribute("utente", utente);
        return "utente-form";
    }

    @PostMapping(value = "/deleteUtente")
    public String deleteUtente(@RequestParam("utenteId") int id) {
        utenteService.deleteUtente(id);
        return "redirect:/utenti/";
    }

    @PostMapping("/saveUtente")
    public String saveUtente(@ModelAttribute("utente") Utente utente) {
        utenteService.updateUtente(utente);
        return "redirect:/utenti/";
    }


    /*public String approvata(@RequestParam("approvata") boolean approvata) {

    }*/


}
