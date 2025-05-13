package com.iescm.ad.proyecto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iescm.ad.proyecto.entities.Publicacion;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {
    @Query("SELECT p FROM Publicacion p WHERE p.id = :id")
    List<Publicacion> listarPublicacionesPorId(@Param("id") int id);
    List<Publicacion> findByPerfilId(int perfilId);
}
