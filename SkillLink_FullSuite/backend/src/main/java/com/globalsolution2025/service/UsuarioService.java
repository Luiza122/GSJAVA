package com.globalsolution2025.service;
import org.springframework.stereotype.Service; import org.springframework.beans.factory.annotation.Autowired;
import com.globalsolution2025.repository.UsuarioRepository; import com.globalsolution2025.model.Usuario; import com.globalsolution2025.exception.UsuarioNaoEncontradoException;
import java.util.List;
@Service public class UsuarioService {
 @Autowired private UsuarioRepository repo;
 public List<Usuario> listar(){ return repo.findAll(); }
 public Usuario buscar(Long id){ return repo.findById(id).orElseThrow(()-> new UsuarioNaoEncontradoException("Usuário não encontrado: "+id)); }
 public Usuario criar(Usuario u){ return repo.save(u); }
 public Usuario atualizar(Long id, Usuario d){ Usuario u = buscar(id); u.setNome(d.getNome()); u.setEmail(d.getEmail()); u.setAreaAtuacao(d.getAreaAtuacao()); u.setNivelCarreira(d.getNivelCarreira()); u.setDataCadastro(d.getDataCadastro()); return repo.save(u); }
 public void remover(Long id){ repo.delete(buscar(id)); }
}