package com.globalsolution2025.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import java.util.Set; import java.util.HashSet;
@Entity @Table(name="trilhas")
public class TrilhaDeAprendizagem {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @NotBlank @Size(min=3,max=150) private String nome; private String descricao;
  @NotBlank private String nivel;
  @Column(name="carga_horaria") @Min(1) private int cargaHoraria;
  @Column(name="foco_principal") private String focoPrincipal;
  @ManyToMany
  @JoinTable(
          name = "trilha_competencia",
          joinColumns = @JoinColumn(name = "trilha_id"),
          inverseJoinColumns = @JoinColumn(name = "competencia_id")
  )
  @JsonManagedReference
  private Set<Competencia> competencias = new HashSet<>();
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public String getNome(){return nome;} public void setNome(String nome){this.nome=nome;}
  public String getDescricao(){return descricao;} public void setDescricao(String d){this.descricao=d;}
  public String getNivel(){return nivel;} public void setNivel(String n){this.nivel=n;}
  public int getCargaHoraria(){return cargaHoraria;} public void setCargaHoraria(int c){this.cargaHoraria=c;}
  public String getFocoPrincipal(){return focoPrincipal;} public void setFocoPrincipal(String f){this.focoPrincipal=f;}
  public Set<Competencia> getCompetencias(){return competencias;} public void setCompetencias(Set<Competencia> c){this.competencias=c;}
}
