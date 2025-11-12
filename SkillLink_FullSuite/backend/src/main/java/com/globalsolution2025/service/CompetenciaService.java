package com.globalsolution2025.service;
import com.globalsolution2025.exception.TrilhaNaoEncontradaException;
import org.springframework.stereotype.Service; import org.springframework.beans.factory.annotation.Autowired;
import com.globalsolution2025.repository.CompetenciaRepository; import com.globalsolution2025.model.Competencia; import java.util.List;
@Service public class CompetenciaService {
 @Autowired private CompetenciaRepository repo;
 public List<Competencia> listar(){ return repo.findAll(); }
 public Competencia buscar(Long id){ return repo.findById(id).orElseThrow(() -> new TrilhaNaoEncontradaException("Não encontrada")); }
 public Competencia criar(Competencia c){ return repo.save(c); }
 public Competencia atualizar(Long id, Competencia d){ Competencia c = buscar(id); c.setNome(d.getNome()); c.setCategoria(d.getCategoria()); c.setDescricao(d.getDescricao()); return repo.save(c); }
 public void remover(Long id){ repo.delete(buscar(id)); }
}