package com.example.rentcarspring.controller;

import com.example.rentcarspring.entity.Auto;
import com.example.rentcarspring.entity.Prenotazione;
import com.example.rentcarspring.service.AutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/auto")

public class AutoController {

    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping("/listPrenotazioni")
    public String listPrenotazioni(@RequestParam int id, Model model) {
        Auto auto = autoService.getAuto(id);
        List<Prenotazione> prenotazioneList = auto.getPrenotazioniFromAutoItems();
        model.addAttribute("prenotazioni", prenotazioneList);
        model.addAttribute("auto", auto);
        return "list-prenotazioni-auto";
    }

    @GetMapping("/")
    public String listAuto(Model model) {
        List<Auto> autoList = autoService.getAutoList();
        model.addAttribute("autos", autoList);
        return "list-auto";
    }

    @GetMapping("/showForm")
    public String showForm(@RequestParam int id, Model model) {
        Auto auto = id == 0 ? new Auto() : autoService.getAuto(id);
        model.addAttribute("auto", auto);
        return "auto-form";
    }

    @GetMapping("/deleteAuto")
    public String deleteAuto(@RequestParam int id) {
        autoService.deleteAuto(id);
        return "redirect:/auto/";
    }

    @PostMapping("/saveAuto")
    public String saveAuto(@ModelAttribute("auto") Auto auto) {
        autoService.updateAuto(auto);
        return "redirect:/auto/";
    }
}
