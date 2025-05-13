package com.iescm.ad.proyecto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iescm.ad.proyecto.entities.Perfil;
import com.iescm.ad.proyecto.repositories.PerfilRepository;
@Service
public class PerfilService implements PerfilServiceI{
    @Autowired
    private PerfilRepository perfilRepository;


    @Override
    public String obtenerNombreUsuario(int id) {
        return perfilRepository.obtenerNombreUsuarioPorId(id); // Llama al repositorio para obtener el nombre
    }

    @Override
    public Optional<Perfil> obtenerPerfilPorNombreUsuario(String nombreUsuario) {
        return perfilRepository.findByNombreUsuario(nombreUsuario);
    }

    @Override
    public Perfil obtenerPerfilPorId(int id) {
        return perfilRepository.obtenerPerfilPorId(id); // Llama al repositorio para obtener el perfil
    }
}
