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
    public String listPrenotazioni(@RequestParam("autoId") int id, Model model) {
        Auto auto = autoService.getAuto(id);
        List<Prenotazione> prenotazioneList = auto.getItems();
        model.addAttribute("prenotazioni", prenotazioneList);
        return "list-prenotazioni-auto";
    }

    @GetMapping("/")
    public String listAuto(Model model) {
        List<Auto> autoList = autoService.getAuto();
        model.addAttribute("autos", autoList);
        return "list-auto";
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {
        Auto auto = new Auto();
        model.addAttribute("auto", auto);
        return "auto-form";
    }

    @GetMapping("/updateForm")
    public String updateForm(@RequestParam("autoId") int id, Model model) {
        Auto auto = autoService.getAuto(id);
        model.addAttribute("auto", auto);
        return "auto-form";
    }

    @PostMapping("/deleteAuto")
    public String deleteAuto(@RequestParam("autoId") int id) {
        autoService.deleteAuto(id);
        return "redirect:/auto/";
    }

    @PostMapping("/saveAuto")
    public String saveAuto(@ModelAttribute("auto") Auto auto) {
        autoService.updateAuto(auto);
        return "redirect:/auto/";
    }

}
