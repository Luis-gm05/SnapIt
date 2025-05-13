package com.iescm.ad.proyecto.services;

import com.iescm.ad.proyecto.entities.Seguidores;

public interface SeguidoresServiceI {
    public Seguidores crearSeguidor(Seguidores seguidores);
    public void eliminarSeguidor(int id);
    int contarSeguidores(int id);
    int contarSeguidos(int id);
}
