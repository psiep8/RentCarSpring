package com.example.rentcarspring.controller;

import com.example.rentcarspring.dto.UtenteDTO;
import com.example.rentcarspring.entity.Prenotazione;
import com.example.rentcarspring.entity.Utente;
import com.example.rentcarspring.mapper.UtenteMapper;
import com.example.rentcarspring.service.FilterService;
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
    private final FilterService filterService;


    public UtenteController(UtenteService utenteService, FilterService filterService) {
        this.utenteService = utenteService;
        this.filterService = filterService;
    }


    @GetMapping("/listPrenotazioni")
    public String listPrenotazioni(@RequestParam int id, Model model) {
        Utente utente = utenteService.getUser(id);
        List<Prenotazione> prenotazioneList = utente.getPrenotazioniFromUtenteItems();
        model.addAttribute("prenotazioni", prenotazioneList);
        model.addAttribute("utente", utente);
        return "list-prenotazioni";
    }

    @PostMapping("/filter")
    public String filterName(@RequestParam("parametri") String campo, @RequestParam("text") String filter, Model model) {
        List<String> list = filterService.getColumn(campo, filter);
        model.addAttribute("utenti", list);
        return "admin";
    }

    @GetMapping("/")
    public String listUtenti(Model model) {
        List<Utente> utenteList = utenteService.getUtenti();
        model.addAttribute("utenti", utenteList);
        return "admin";
    }

    @GetMapping("/showForm")
    public String showForm(@RequestParam int id, Model model) {
        Utente utente = id == 0 ? new Utente() : utenteService.getUser(id);
        model.addAttribute("utente", utente);
        return "utente-form";
    }

    @GetMapping(value = "/deleteUtente")
    public String deleteUtente(@RequestParam int id) {
        utenteService.deleteUtente(id);
        return "redirect:/utenti/";
    }

    @PostMapping("/saveUtente")
    public String saveUtente(@ModelAttribute("utente") UtenteDTO utenteDTO) {
        utenteService.updateUtente(UtenteMapper.fromDTOtoEntity(utenteDTO));
        return "redirect:/utenti/";
    }

    @PostMapping("/approvata")
    public String approvata(@RequestParam("approved") String approvata, @RequestParam int id) {
        utenteService.approvaPrenotazione(approvata, id);
        return "redirect:/utenti/";
    }

}
