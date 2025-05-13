package com.iescm.ad.proyecto.services;

import java.util.List;

import com.iescm.ad.proyecto.entities.Publicacion;

public interface PublicacionServiceI {
    public List<Publicacion> listarPublicaciones();
    public List<Publicacion> listarPublicacionesInvertidas();
    public Publicacion crearPublicacion(Publicacion publicacion);
    public void eliminarPublicacion(int id);
    public List<Publicacion> listarPublicacionesPorId(int id);
    public List<Publicacion> findByPerfilId(int perfilId);
}
