package com.example.skill_link.service;

import com.example.skill_link.exception.NaoEncontradoException;
import com.example.skill_link.model.Usuario;
import com.example.skill_link.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {
    @Mock
    private UsuarioRepository repository;
    @InjectMocks
    private UsuarioService service;

    @Test
    void deveListarUsuarios() {
        when(repository.findAll()).thenReturn(List.of(new Usuario()));
        assertEquals(1, service.listar().size());
    }

    @Test
    void deveBuscarUsuarioPorId() {
        Usuario u = new Usuario();
        u.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(u));

        Usuario resultado = service.buscar(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
    }

    @Test
    void deveLancarExcecaoAoBuscarInexistente() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NaoEncontradoException.class, () -> service.buscar(1L));
    }

    @Test
    void deveCriarUsuario() {
        Usuario u = new Usuario();
        when(repository.save(u)).thenReturn(u);

        assertEquals(u, service.criar(u));
    }

    @Test
    void deveAtualizarUsuario() {
        Usuario existente = new Usuario();
        existente.setId(1L);
        existente.setNome("Antigo");

        Usuario novo = new Usuario();
        novo.setNome("Novo");

        when(repository.findById(1L)).thenReturn(Optional.of(existente));
        when(repository.save(existente)).thenReturn(existente);

        Usuario atualizado = service.atualizar(1L, novo);

        assertEquals("Novo", atualizado.getNome());
        verify(repository).save(existente);
    }

    @Test
    void deveDeletarUsuario() {
        doNothing().when(repository).deleteById(1L);

        service.deletar(1L);

        verify(repository).deleteById(1L);
    }
}
