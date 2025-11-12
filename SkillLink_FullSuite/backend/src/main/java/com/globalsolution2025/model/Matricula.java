package com.globalsolution2025.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import java.time.LocalDate;
@Entity @Table(name="matriculas")
public class Matricula {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @ManyToOne(optional=false) @JoinColumn(name="usuario_id") private Usuario usuario;
  @ManyToOne(optional=false) @JoinColumn(name="trilha_id") private TrilhaDeAprendizagem trilha;
  @Column(name="data_inscricao", nullable=false) private LocalDate dataInscricao = LocalDate.now();
  @NotBlank private String status;
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public Usuario getUsuario(){return usuario;} public void setUsuario(Usuario u){this.usuario=u;}
  public TrilhaDeAprendizagem getTrilha(){return trilha;} public void setTrilha(TrilhaDeAprendizagem t){this.trilha=t;}
  public LocalDate getDataInscricao(){return dataInscricao;} public void setDataInscricao(LocalDate d){this.dataInscricao=d;}
  public String getStatus(){return status;} public void setStatus(String s){this.status=s;}
}
