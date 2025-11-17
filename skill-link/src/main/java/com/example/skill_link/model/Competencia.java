package com.example.skill_link.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;

import java.util.*;

@Entity @Table(name = "competencias") @AllArgsConstructor
public class Competencia {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @NotBlank @Size(min=2,max=100) @Column(nullable=false) private String nome;
    private String categoria;
    private String descricao;
    @ManyToMany(mappedBy = "competencias") @JsonIgnore
    private Set<TrilhaAprendizagem> trilhas = new HashSet<>();

    public Competencia() {}

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

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<TrilhaAprendizagem> getTrilhas() {
        return trilhas;
    }
    public void setTrilhas(Set<TrilhaAprendizagem> trilhas) {
        this.trilhas = trilhas;
    }
}
