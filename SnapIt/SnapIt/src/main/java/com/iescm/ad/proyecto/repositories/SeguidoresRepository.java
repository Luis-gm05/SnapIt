package com.iescm.ad.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iescm.ad.proyecto.entities.Seguidores;

@Repository
public interface SeguidoresRepository extends JpaRepository<Seguidores, Integer>{
    @Query("SELECT COUNT(s) FROM Seguidores s WHERE s.seguido.id = :id")
    int contarSeguidores(int id);

    @Query("SELECT COUNT(s) FROM Seguidores s WHERE s.seguidor.id = :id")
    int contarSeguidos(int id);
}
