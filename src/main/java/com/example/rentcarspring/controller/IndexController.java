package com.example.rentcarspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping(value = "/")
    public String getIndex(Model model) {
        model.addAttribute("intestazione", "Benvenuti nel sito RentCar - Noleggio Auto");
        model.addAttribute("saluti", "Seleziona le auto");

        return "index";
    }

    @RequestMapping
    public String getWelcome(Model model) {
        model.addAttribute("intestazione", "Benvenuti nel sito RentCar - Noleggio Auto");
        model.addAttribute("saluti", "Seleziona le auto");

        return "welcome";
    }
}
