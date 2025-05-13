package com.iescm.ad.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iescm.ad.proyecto.entities.Publicacion;
import com.iescm.ad.proyecto.repositories.PublicacionRepository;

@Service
public class PublicacionService implements PublicacionServiceI {

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Override
    public List<Publicacion> listarPublicaciones() {
        return publicacionRepository.findAll();
    }

    @Override
    public List<Publicacion> listarPublicacionesInvertidas() {
        return listarPublicaciones().reversed();
    }

    @Override
    public Publicacion crearPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    @Override
    public void eliminarPublicacion(int id) {
        publicacionRepository.deleteById(id);
    }

    @Override
    public List<Publicacion> listarPublicacionesPorId(int id) {
        return publicacionRepository.listarPublicacionesPorId(id);
    }

    @Override
    public List<Publicacion> findByPerfilId(int perfilId) {
        return publicacionRepository.findByPerfilId(perfilId);
    }
}
