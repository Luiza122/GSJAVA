package com.example.skill_link.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity @Table(name = "matriculas") @AllArgsConstructor
public class Matricula {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @ManyToOne(optional=false) @JoinColumn(name="usuario_id") private Usuario usuario;
    @ManyToOne(optional=false) @JoinColumn(name="trilha_id") private TrilhaAprendizagem trilha;
    @Column(name="data_inscricao", nullable=false) private LocalDate dataInscricao;
    @NotBlank private String status;

    public Matricula() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TrilhaAprendizagem getTrilha() {
        return trilha;
    }
    public void setTrilha(TrilhaAprendizagem trilha) {
        this.trilha = trilha;
    }

    public LocalDate getDataInscricao() {
        return dataInscricao;
    }
    public void setDataInscricao(LocalDate dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
