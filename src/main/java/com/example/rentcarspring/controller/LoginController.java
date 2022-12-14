package com.example.rentcarspring.controller;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Controller
@RequestMapping
public class LoginController {
    @GetMapping("/login/form")
    public String getIndex(Model model) {
        model.addAttribute("intestazione", "Benvenuti nel sito RentCar - Noleggio Auto");
        return "login";
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SecurityContextHolder.clearContext();
        response.sendRedirect("login/form?logout");
    }
}
