package com.globalsolution2025.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import java.util.Set; import java.util.HashSet;
@Entity @Table(name="competencias")
public class Competencia {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @NotBlank @Size(min=2,max=100) @Column(nullable=false) private String nome;
  private String categoria; private String descricao;
  @ManyToMany(mappedBy = "competencias") @JsonBackReference private Set<TrilhaDeAprendizagem> trilhas = new HashSet<>();
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public String getNome(){return nome;} public void setNome(String nome){this.nome=nome;}
  public String getCategoria(){return categoria;} public void setCategoria(String c){this.categoria=c;}
  public String getDescricao(){return descricao;} public void setDescricao(String d){this.descricao=d;}
  public Set<TrilhaDeAprendizagem> getTrilhas(){return trilhas;} public void setTrilhas(Set<TrilhaDeAprendizagem> t){this.trilhas=t;}
}
