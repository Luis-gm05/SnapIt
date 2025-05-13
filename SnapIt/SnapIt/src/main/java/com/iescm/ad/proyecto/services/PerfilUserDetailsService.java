package com.iescm.ad.proyecto.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iescm.ad.proyecto.repositories.PerfilRepository;

@Service
public class PerfilUserDetailsService implements UserDetailsService {

    private final PerfilRepository perfilRepository;

    public PerfilUserDetailsService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return perfilRepository.findByNombreUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
    }
}
