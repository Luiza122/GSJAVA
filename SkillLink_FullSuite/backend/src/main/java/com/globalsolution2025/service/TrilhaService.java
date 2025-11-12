package com.globalsolution2025.service;
import org.springframework.stereotype.Service; import org.springframework.beans.factory.annotation.Autowired;
import com.globalsolution2025.repository.TrilhaRepository; import com.globalsolution2025.model.TrilhaDeAprendizagem; import com.globalsolution2025.exception.TrilhaNaoEncontradaException;
import java.util.List;
@Service public class TrilhaService {
 @Autowired private TrilhaRepository repo;
 public List<TrilhaDeAprendizagem> listar(){ return repo.findAll(); }
 public TrilhaDeAprendizagem buscar(Long id){ return repo.findById(id).orElseThrow(()-> new TrilhaNaoEncontradaException("Trilha não encontrada: "+id)); }
 public TrilhaDeAprendizagem criar(TrilhaDeAprendizagem t){ return repo.save(t); }
 public TrilhaDeAprendizagem atualizar(Long id, TrilhaDeAprendizagem d){ TrilhaDeAprendizagem t = buscar(id); t.setNome(d.getNome()); t.setDescricao(d.getDescricao()); t.setNivel(d.getNivel()); t.setCargaHoraria(d.getCargaHoraria()); t.setFocoPrincipal(d.getFocoPrincipal()); t.setCompetencias(d.getCompetencias()); return repo.save(t); }
 public void remover(Long id){ repo.delete(buscar(id)); }
}