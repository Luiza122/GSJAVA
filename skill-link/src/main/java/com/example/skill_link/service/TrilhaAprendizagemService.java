package com.example.skill_link.service;

import com.example.skill_link.exception.NaoEncontradoException;
import com.example.skill_link.model.TrilhaAprendizagem;
import com.example.skill_link.repository.TrilhaAprendizagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TrilhaAprendizagemService {
    @Autowired
    private TrilhaAprendizagemRepository repository;

    public List<TrilhaAprendizagem> listar(){
        return repository.findAll();
    }
    public TrilhaAprendizagem buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Trilha de id - "+ id +" não encontrado"));
    }
    @Transactional
    public TrilhaAprendizagem criar(TrilhaAprendizagem t) {
        return repository.save(t);
    }
    @Transactional
    public TrilhaAprendizagem atualizar(Long id, TrilhaAprendizagem t) {
        TrilhaAprendizagem trilha = buscar(id);
        trilha.setNome(t.getNome());
        trilha.setDescricao(t.getDescricao());
        trilha.setNivel(t.getNivel());
        trilha.setCargaHoraria(t.getCargaHoraria());
        trilha.setFocoPrincipal(t.getFocoPrincipal());
        trilha.setCompetencias(t.getCompetencias());
        return repository.save(trilha);
    }
    @Transactional
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
