package com.iescm.ad.proyecto.entities;

import java.util.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Perfil perfil;

    @Lob
    @Column(name = "foto", nullable = false)
    private byte[] foto;

    @Column(name = "texto1", length = 50)
    private String texto1;

    @Column(name = "texto2", length = 50)
    private String texto2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getFoto() {
        if (foto != null) {
            return Base64.getEncoder().encodeToString(foto);
        } else {
            return null;
        }
    }

    /*
    public String getBase64Foto() {
        return Base64.getEncoder().encodeToString(foto);
    }*/

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getTexto1() {
        return texto1;
    }

    public void setTexto1(String texto1) {
        this.texto1 = texto1;
    }

    public String getTexto2() {
        return texto2;
    }

    public void setTexto2(String texto2) {
        this.texto2 = texto2;
    }
}
