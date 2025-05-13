package com.iescm.ad.proyecto.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "seguidores")
public class Seguidores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_seguidor", nullable = false)
    private Perfil seguidor;

    @ManyToOne
    @JoinColumn(name = "id_seguido", nullable = false)
    private Perfil seguido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Perfil getSeguidor() {
        return seguidor;
    }

    public void setSeguidor(Perfil seguidor) {
        this.seguidor = seguidor;
    }

    public Perfil getSeguido() {
        return seguido;
    }

    public void setSeguido(Perfil seguido) {
        this.seguido = seguido;
    }
}