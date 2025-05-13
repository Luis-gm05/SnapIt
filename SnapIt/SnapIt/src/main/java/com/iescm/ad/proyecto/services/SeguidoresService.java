package com.iescm.ad.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iescm.ad.proyecto.entities.Seguidores;
import com.iescm.ad.proyecto.repositories.SeguidoresRepository;

@Service
public class SeguidoresService implements SeguidoresServiceI{

    @Autowired
    private SeguidoresRepository seguidoresRepository;

    @Override
    public Seguidores crearSeguidor(Seguidores seguidores) {
        return seguidoresRepository.save(seguidores);

    }

    @Override
    public void eliminarSeguidor(int id){
        // TODO Auto-generated method stub
        //return seguidoresRepository.deleteById(id);
    }

    @Override
    public int contarSeguidores(int id) {
        return seguidoresRepository.contarSeguidores(id);
    }

    @Override
    public int contarSeguidos(int id) {
        return seguidoresRepository.contarSeguidos(id);
    }
    
}
