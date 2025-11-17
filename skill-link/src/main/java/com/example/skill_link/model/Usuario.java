package com.example.skill_link.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;

import java.time.LocalDate;


@Entity @Table(name = "usuarios") @AllArgsConstructor
public class Usuario {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY) private Long id;
    @NotBlank(message = "Nome não pode faltar") @Size(min = 2, max = 100) private String nome;
    @NotBlank @Email @Column(unique=true) private String email;
    @Column(name="area_atuacao") private String areaAtuacao;
    @Column(name="nivel_carreira") private String nivelCarreira;
    @Column(name="data_cadastro", nullable=false) private LocalDate dataCadastro;

    public Usuario() {}

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getAreaAtuacao() {
        return areaAtuacao;
    }
    public String getNivelCarreira() {
        return nivelCarreira;
    }
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }
    public void setNivelCarreira(String nivelCarreira) {
        this.nivelCarreira = nivelCarreira;
    }
    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
