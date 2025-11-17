package com.example.skill_link.service;

import com.example.skill_link.exception.NaoEncontradoException;
import com.example.skill_link.model.Competencia;
import com.example.skill_link.repository.CompetenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompetenciaService {
    @Autowired
    private CompetenciaRepository repository;

    public List<Competencia> listar(){
        return repository.findAll();
    }
    public Competencia buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Competência de id - "+ id +" não encontrado"));
    }
    @Transactional
    public Competencia criar(Competencia c) {
        return repository.save(c);
    }
    @Transactional
    public Competencia atualizar(Long id, Competencia c) {
        Competencia competencia = buscar(id);
        competencia.setNome(c.getNome());
        competencia.setCategoria(c.getCategoria());
        competencia.setDescricao(c.getDescricao());
        return repository.save(competencia);
    }
    @Transactional
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
