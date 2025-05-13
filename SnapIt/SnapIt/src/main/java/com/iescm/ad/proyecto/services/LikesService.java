package com.iescm.ad.proyecto.services;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.iescm.ad.proyecto.repositories.LikesRepository;
 
@Service
public class LikesService implements LikesServiceI{
    @Autowired
    private LikesRepository likesRepository;
    
    @Override
    public List<Integer> likesPorPublicacion() {
        return likesRepository.likesPorPublicacion().reversed();
    }
}