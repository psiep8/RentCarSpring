package com.example.rentcarspring.controller;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

@Controller
@RequestMapping("/login/form")
public class LoginController {
    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("intestazione", "Benvenuti nel sito RentCar - Noleggio Auto");
        return "login";
    }


}
