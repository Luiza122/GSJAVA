package com.globalsolution2025.service;
import com.globalsolution2025.exception.TrilhaNaoEncontradaException;
import org.springframework.stereotype.Service; import org.springframework.beans.factory.annotation.Autowired;
import com.globalsolution2025.repository.MatriculaRepository; import com.globalsolution2025.model.Matricula; import java.util.List;
@Service public class MatriculaService {
 @Autowired private MatriculaRepository repo;
 public List<Matricula> listar(){ return repo.findAll(); }
 public Matricula buscar(Long id){ return repo.findById(id).orElseThrow(() -> new TrilhaNaoEncontradaException("Não encontrada")); }
 public Matricula criar(Matricula m){ return repo.save(m); }
 public Matricula atualizar(Long id, Matricula d){ Matricula m = buscar(id); m.setStatus(d.getStatus()); m.setUsuario(d.getUsuario()); m.setTrilha(d.getTrilha()); m.setDataInscricao(d.getDataInscricao()); return repo.save(m); }
 public void remover(Long id){ repo.delete(buscar(id)); }
}