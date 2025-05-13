package com.iescm.ad.proyecto.repositories;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 
import com.iescm.ad.proyecto.entities.Likes;
 
@Repository
public interface LikesRepository extends JpaRepository<Likes, Integer> {
    // Obtiene los likes de una publicación a partir de su ID
    @Query("SELECT COUNT(l) FROM Likes l GROUP BY l.publicacion.id")
    List<Integer> likesPorPublicacion();
}