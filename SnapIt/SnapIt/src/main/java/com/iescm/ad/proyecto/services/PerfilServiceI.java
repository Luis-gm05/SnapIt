package com.iescm.ad.proyecto.services;

import java.util.Optional;

import com.iescm.ad.proyecto.entities.Perfil;

public interface PerfilServiceI {
    public String obtenerNombreUsuario(int id);
    public Perfil obtenerPerfilPorId(int id);
    public Optional<Perfil> obtenerPerfilPorNombreUsuario(String nombreUsuario);
}
