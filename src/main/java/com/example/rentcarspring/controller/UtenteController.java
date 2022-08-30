package com.example.rentcarspring.controller;

import com.example.rentcarspring.dto.UtenteDTO;
import com.example.rentcarspring.entity.Prenotazione;
import com.example.rentcarspring.entity.Utente;
import com.example.rentcarspring.service.PrenotazioneService;
import com.example.rentcarspring.service.UtenteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/utenti")
public class UtenteController {


    private final UtenteService utenteService;
    private final PrenotazioneService prenotazioneService;

    public UtenteController(UtenteService utenteService, PrenotazioneService prenotazioneService) {
        this.utenteService = utenteService;
        this.prenotazioneService = prenotazioneService;
    }


    @GetMapping("/listPrenotazioni")
    public String listPrenotazioni(@RequestParam int id, Model model) {
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
    public String updateForm(@RequestParam int id, Model model) {
        Utente utente = utenteService.getUser(id);
        model.addAttribute("utente", utente);
        return "edit-form";
    }

    @GetMapping(value = "/deleteUtente")
    public String deleteUtente(@RequestParam int id) {
        utenteService.deleteUtente(id);
        return "redirect:/utenti/";
    }

    @PostMapping("/saveUtente")
    public String saveUtente(@ModelAttribute("utente") UtenteDTO utenteDTO) {
        utenteService.updateUtente(utenteDTO);
        return "redirect:/utenti/";
    }


    /*public String approvata(@RequestParam boolean approvata, @RequestParam int id) {
        prenotazione = prenotazioneService.getPrenotazione(id);

    }*/


}
