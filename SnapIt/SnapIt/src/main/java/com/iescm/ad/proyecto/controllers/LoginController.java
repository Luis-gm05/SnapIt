package com.iescm.ad.proyecto.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
    
    @GetMapping("/")
    public String paginaPrincipal(Model model){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String iniciarSesion(Model model){
        return "login";
    }

    @GetMapping("/logout")
    public String cerrarSesion(Model model){
        return "redirect:/login?logout=true";
    }
}
