package com.iescm.ad.proyecto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iescm.ad.proyecto.entities.Perfil;
import com.iescm.ad.proyecto.entities.Publicacion;
import com.iescm.ad.proyecto.services.PerfilService;
import com.iescm.ad.proyecto.services.PublicacionService;
import com.iescm.ad.proyecto.services.SeguidoresService;

@Controller
@RequestMapping("/profile")
public class PerfilController {
    @Autowired
    private PublicacionService publicacionService;
    @Autowired
    private SeguidoresService seguidoresService;
    @Autowired
    private PerfilService perfilService;
    
    @GetMapping("/search/{nombreUsuario}")
    public String buscarPerfil(@PathVariable("nombreUsuario") String nombreUsuario, Model model) {
        Optional<Perfil> perfilUsuario = perfilService.obtenerPerfilPorNombreUsuario(nombreUsuario);
        if (perfilUsuario.isPresent()) {
            return "redirect:/profile/%d".formatted(perfilUsuario.get().getId());
        } else {
            return "redirect:/feed";
        }
    }

    @GetMapping("/{id}")
    public String obtenerPerfil(@AuthenticationPrincipal Perfil usuario, @PathVariable("id") int id, Model model) {
        Perfil perfil = perfilService.obtenerPerfilPorId(id);
        List<Publicacion> publicaciones = publicacionService.findByPerfilId(id);
        int seguidores = seguidoresService.contarSeguidores(id);
        int seguidos = seguidoresService.contarSeguidos(id);
        
        model.addAttribute("usuario", usuario);
        model.addAttribute("nombre", perfil.getNombreUsuario());
        model.addAttribute("foto", perfil.getFoto());
        model.addAttribute("publicaciones", publicaciones);
        model.addAttribute("seguidores", seguidores);  
        model.addAttribute("seguidos", seguidos);
        return "profile";
    }
}
