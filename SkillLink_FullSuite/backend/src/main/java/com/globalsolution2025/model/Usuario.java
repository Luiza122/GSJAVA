package com.globalsolution2025.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import java.time.LocalDate;
@Entity @Table(name="usuarios")
public class Usuario {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @NotBlank @Size(min=2,max=100) private String nome;
  @NotBlank @Email @Column(unique=true) private String email;
  @Column(name="area_atuacao") private String areaAtuacao;
  @Column(name="nivel_carreira") private String nivelCarreira;
  @Column(name="data_cadastro", nullable=false) private LocalDate dataCadastro = LocalDate.now();
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public String getNome(){return nome;} public void setNome(String nome){this.nome=nome;}
  public String getEmail(){return email;} public void setEmail(String email){this.email=email;}
  public String getAreaAtuacao(){return areaAtuacao;} public void setAreaAtuacao(String a){this.areaAtuacao=a;}
  public String getNivelCarreira(){return nivelCarreira;} public void setNivelCarreira(String n){this.nivelCarreira=n;}
  public LocalDate getDataCadastro(){return dataCadastro;} public void setDataCadastro(LocalDate d){this.dataCadastro=d;}
}
