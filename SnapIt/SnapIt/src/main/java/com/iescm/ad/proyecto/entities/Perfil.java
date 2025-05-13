package com.iescm.ad.proyecto.entities;

import java.util.Base64;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="perfil")
public class Perfil implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre_usuario", nullable = false, length = 50)
    private String nombreUsuario;

    @Lob
    @Column(name = "foto", nullable = false)
    private byte[] foto;

    @Column(name = "contrasena_hash", nullable = false, length = 50)
    private String contrasenaHash;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public String getFoto() {
        return Base64.getEncoder().encodeToString(foto);
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getContrasenaHash() {
        return contrasenaHash;
    }

    public void setContrasenaHash(String contrasenaHash) {
        this.contrasenaHash = contrasenaHash;
    }

    // Wrappers requeridos por UserDetails para la autenticación; NO USAR!!!
    @Override
    public String getUsername() {
        return getNombreUsuario();
    }
    
    @Override
    public String getPassword() {
        return getContrasenaHash();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }  
}
