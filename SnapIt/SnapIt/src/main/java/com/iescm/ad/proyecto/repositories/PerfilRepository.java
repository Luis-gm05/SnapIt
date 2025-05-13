package com.iescm.ad.proyecto.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iescm.ad.proyecto.entities.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

    // Consulta JPQL para obtener solo el nombre del usuario por su ID
    @Query("SELECT p.nombreUsuario FROM Perfil p WHERE p.id = :id")
    String obtenerNombreUsuarioPorId(int id);

    // Devuelve un perfil a partir de su nombre de usuario
    Optional<Perfil> findByNombreUsuario(String nombreUsuario);

    // También puedes realizar una consulta para obtener todo el perfil si lo necesitas
    @Query("SELECT p FROM Perfil p WHERE p.id = :id")
    Perfil obtenerPerfilPorId(int id);
}
