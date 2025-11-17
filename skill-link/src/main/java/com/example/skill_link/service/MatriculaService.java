package com.example.skill_link.service;

import com.example.skill_link.exception.NaoEncontradoException;
import com.example.skill_link.model.Matricula;
import com.example.skill_link.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MatriculaService {
    @Autowired
    private MatriculaRepository repository;

    public List<Matricula> listar(){
        return repository.findAll();
    }
    public Matricula buscar(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Matrículaa de id - "+ id +" não encontrado"));
    }
    @Transactional
    public Matricula criar(Matricula m){
        return repository.save(m);
    }
    @Transactional
    public Matricula atualizar(Long id, Matricula m){
        Matricula matricula = buscar(id);
        matricula.setStatus(m.getStatus());
        matricula.setUsuario(m.getUsuario());
        matricula.setTrilha(m.getTrilha());
        matricula.setDataInscricao(m.getDataInscricao());
        return repository.save(matricula);
    }
    @Transactional
    public void deletar(Long id){
        repository.deleteById(id);
    }
}
