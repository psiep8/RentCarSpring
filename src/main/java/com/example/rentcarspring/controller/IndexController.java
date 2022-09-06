package com.example.rentcarspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login/form")
public class IndexController {
    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("intestazione", "Benvenuti nel sito RentCar - Noleggio Auto");
        return "login";
    }


}
