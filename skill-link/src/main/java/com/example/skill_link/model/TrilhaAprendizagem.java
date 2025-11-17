package com.example.skill_link.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import java.util.*;

@Entity @Table(name = "trilhas") @AllArgsConstructor
public class TrilhaAprendizagem {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY) private Long id;
    @NotBlank @Size(min=3,max=150) private String nome;
    private String descricao;
    @NotBlank private String nivel;
    @Column(name="carga_horaria") @Min(1) private int cargaHoraria;
    @Column(name="foco_principal") private String focoPrincipal;
    @ManyToMany
    @JoinTable(
            name = "trilha_competencia",
            joinColumns = @JoinColumn(name = "trilha_id"),
            inverseJoinColumns = @JoinColumn(name = "competencia_id")
    )
    @JsonIgnore
    private Set<Competencia> competencias = new HashSet<>();

    public TrilhaAprendizagem() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNivel() {
        return nivel;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getFocoPrincipal() {
        return focoPrincipal;
    }
    public void setFocoPrincipal(String focoPrincipal) {
        this.focoPrincipal = focoPrincipal;
    }

    public Set<Competencia> getCompetencias() {
        return competencias;
    }
    public void setCompetencias(Set<Competencia> competencias) {
        this.competencias = competencias;
    }
}
