package com.example.skill_link.service;

import com.example.skill_link.exception.NaoEncontradoException;
import com.example.skill_link.model.Usuario;
import com.example.skill_link.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listar(){
        return repository.findAll();
    }
    public Usuario buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Usuário de id - "+ id +" não encontrado"));
    }
    @Transactional
    public Usuario criar(Usuario u) {
        return repository.save(u);
    }
    @Transactional
    public Usuario atualizar(Long id, Usuario u) {
        Usuario usuario = buscar(id);
        usuario.setNome(u.getNome());
        usuario.setEmail(u.getEmail());
        usuario.setAreaAtuacao(u.getAreaAtuacao());
        usuario.setNivelCarreira(u.getNivelCarreira());
        usuario.setDataCadastro(u.getDataCadastro());
        return repository.save(usuario);
    }
    @Transactional
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
