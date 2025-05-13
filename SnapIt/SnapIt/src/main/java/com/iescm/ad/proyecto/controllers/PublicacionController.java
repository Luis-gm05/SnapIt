package com.iescm.ad.proyecto.controllers;
 
import java.io.IOException;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
 
import com.iescm.ad.proyecto.entities.Perfil;
import com.iescm.ad.proyecto.entities.Publicacion;
import com.iescm.ad.proyecto.services.LikesService;
import com.iescm.ad.proyecto.services.PerfilService;
import com.iescm.ad.proyecto.services.PublicacionService;
 
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 
 
 
@Controller
@RequestMapping
public class PublicacionController {
 
    @Autowired
    private PublicacionService publicacionService;
    @Autowired
    private PerfilService perfilService;
    @Autowired
    private LikesService likesService;
 
    @GetMapping("/feed")
    public String listarPublicaciones(@AuthenticationPrincipal Perfil usuario, Model model) {
        List<Publicacion> publicaciones=publicacionService.listarPublicacionesInvertidas();
        List<Integer> likes=likesService.likesPorPublicacion();
        model.addAttribute("usuario", usuario);
        model.addAttribute("publicaciones", publicaciones);
        model.addAttribute("nuevaPublicacion", new Publicacion());
        model.addAttribute("likes", likes);
        return "feed";
    }
 
    @PostMapping("/publicar")
    public String crearPublicacion(@ModelAttribute Publicacion nuevaPublicacion, Model model, @RequestParam("fotoFile") MultipartFile foto) throws IOException {
        nuevaPublicacion.setPerfil(perfilService.obtenerPerfilPorId(1));
        nuevaPublicacion.setFoto(foto.getBytes());
        publicacionService.crearPublicacion(nuevaPublicacion);
        model.addAttribute("nuevaPublicacion", new Publicacion());
        return "redirect:/feed";
    }
 
    @DeleteMapping("/eliminar/{publicacionId}")
    public String eliminarPublicacion(@AuthenticationPrincipal Perfil usuario, @PathVariable("publicacionId") int publicacionId, Model model) {
        // Evitamos que se intente usar la ruta desde el server
        if (usuario.getId() == publicacionService.listarPublicacionesPorId(publicacionId).get(0).getPerfil().getId()) {
            publicacionService.eliminarPublicacion(publicacionId);
            return "redirect:/feed";
        }
        return null;
    }
 
}
 