package com.example.rentcarspring.controller;

import com.example.rentcarspring.dto.PrenotazioneDTO;
import com.example.rentcarspring.entity.Auto;
import com.example.rentcarspring.entity.Prenotazione;
import com.example.rentcarspring.entity.Utente;
import com.example.rentcarspring.mapper.PrenotazioneMapper;
import com.example.rentcarspring.mapper.UtenteMapper;
import com.example.rentcarspring.service.AutoService;
import com.example.rentcarspring.service.FilterDateService;
import com.example.rentcarspring.service.PrenotazioneService;
import com.example.rentcarspring.service.UtenteService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
@RequestMapping("/prenotazioni")

public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;
    private final FilterDateService filterDateService;
    private final AutoService autoService;

    private final UtenteService utenteService;

    public PrenotazioneController(PrenotazioneService prenotazioneService, FilterDateService filterDateService, AutoService autoService, UtenteService utenteService) {
        this.prenotazioneService = prenotazioneService;
        this.filterDateService = filterDateService;
        this.autoService = autoService;
        this.utenteService = utenteService;
    }

    @GetMapping("/listAuto")
    public String listAuto(Model model) {
        List<Auto> autoList = autoService.getAuto();
        model.addAttribute("auto", autoList);
        return "list-auto-prenotabili";
    }

    @GetMapping("/")
    public String listPrenotazioni(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Utente u = utenteService.getUserByEmail(email);
        List<Prenotazione> prenotazioneList = u.getPrenotazioniFromUtenteItems();
        model.addAttribute("prenotazioni", prenotazioneList);
        return "user";
    }


    @GetMapping("/showForm")
    public String showForm(Model model) {
        Prenotazione prenotazione = new Prenotazione();
        model.addAttribute("prenotazione", prenotazione);
        return "prenotazione-form";
    }

    @GetMapping("/updateForm")
    public String updateForm(@RequestParam int id, Model model) {
        Prenotazione prenotazione = prenotazioneService.getPrenotazione(id);
        model.addAttribute("prenotazione", prenotazione);
        return "edit-prenotazione-form";
    }

    @GetMapping("/deletePrenotazione")
    public String deletePrenotazione(@RequestParam int id) throws IOException {
        LocalDate dataInizio = prenotazioneService.getPrenotazione(id).getDataInizio();
        if (dataInizio.until(LocalDate.now(), ChronoUnit.DAYS) > 2) {
            prenotazioneService.deletePrenotazione(id);
        } else {
            throw new IOException("Errore, non è possibile cancellare entro due giorni dalla prenotazione");
        }
        return "redirect:/prenotazioni/";
    }

    @PostMapping(value = "/selectDate")
    public String getDataRange(@RequestParam("inizio") String inizio, @RequestParam("fine") String fine, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Utente u = utenteService.getUserByEmail(email);
        model.addAttribute("inizio", inizio);
        model.addAttribute("fine", fine);
        List<Auto> list = filterDateService.getDataRange(LocalDate.parse(inizio), LocalDate.parse(fine));
        model.addAttribute("listFiltered", list);
        model.addAttribute("utente", u);
        PrenotazioneDTO newPrenotazioneDTO = new PrenotazioneDTO();
        model.addAttribute("prenotazione", newPrenotazioneDTO);
        return "filtered-date";
    }

    @PostMapping("/savePrenotazione")
    public String savePrenotazione(@ModelAttribute("prenotazione") PrenotazioneDTO prenotazione) {
        if (prenotazione.getId() != 0) {
            prenotazioneService.updatePrenotazione(PrenotazioneMapper.fromDTOtoEntity(prenotazione));
        }
        prenotazioneService.updatePrenotazione(prenotazione);
        return "redirect:/prenotazioni/";
    }
}
