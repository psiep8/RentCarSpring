package com.example.rentcarspring.controller;

import com.example.rentcarspring.dao.AutoDAO;
import com.example.rentcarspring.entity.Auto;
import com.example.rentcarspring.entity.Prenotazione;
import com.example.rentcarspring.entity.Utente;
import com.example.rentcarspring.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/prenotazioni")

public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private AutoDAO autoDAO;

    @GetMapping("/listAuto")
    public String listAuto(Model model) {
        List<Auto> autoList = autoDAO.getAuto();
        model.addAttribute("auto", autoList);
        return "list-auto";
    }

    @GetMapping("/list")
    public String listPrenotazioni(Model model) {
        List<Prenotazione> prenotazioneList = prenotazioneService.getPrenotazioni();
        model.addAttribute("prenotazioni", prenotazioneList);
        return "home";
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {
        Prenotazione prenotazione = new Prenotazione();
        model.addAttribute("prenotazione", prenotazione);
        return "prenotazione-form";
    }

    @GetMapping("/updateForm")
    public String updateForm(@RequestParam("prenotazioneId") int id, Model model) {
        Prenotazione prenotazione = prenotazioneService.getPrenotazione(id);
        model.addAttribute("prenotazione", prenotazione);
        return "prenotazione-form";
    }

    @PostMapping("/deletePrenotazione")
    public String deletePrenotazione(@RequestParam("prenotazioneId") int id) {
        prenotazioneService.deletePrenotazione(id);
        return "redirect:/prenotazioni/list";
    }

    @PostMapping("/savePrenotazione")
    public String savePrenotazione(@ModelAttribute("prenotazione") Prenotazione prenotazione) {
        prenotazioneService.updatePrenotazione(prenotazione);
        return "redirect:/prenotazioni/list";
    }
}
