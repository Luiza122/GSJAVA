package com.example.skill_link.service;

import com.example.skill_link.exception.NaoEncontradoException;
import com.example.skill_link.model.TrilhaAprendizagem;
import com.example.skill_link.repository.TrilhaAprendizagemRepository;
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
class TrilhaAprendizagemServiceTest {
    @Mock
    private TrilhaAprendizagemRepository repository;
    @InjectMocks
    private TrilhaAprendizagemService service;

    @Test
    void deveListarTrilhas() {
        when(repository.findAll()).thenReturn(List.of(new TrilhaAprendizagem()));
        assertEquals(1, service.listar().size());
    }

    @Test
    void deveBuscarTrilhaPorId() {
        TrilhaAprendizagem t = new TrilhaAprendizagem();
        t.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(t));

        assertEquals(1L, service.buscar(1L).getId());
    }

    @Test
    void deveLancarErroAoBuscarInexistente() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(NaoEncontradoException.class, () -> service.buscar(1L));
    }

    @Test
    void deveCriarTrilha() {
        TrilhaAprendizagem t = new TrilhaAprendizagem();
        when(repository.save(t)).thenReturn(t);

        assertEquals(t, service.criar(t));
    }

    @Test
    void deveAtualizarTrilha() {
        TrilhaAprendizagem existente = new TrilhaAprendizagem();
        existente.setNome("Antigo");

        TrilhaAprendizagem novo = new TrilhaAprendizagem();
        novo.setNome("Novo");

        when(repository.findById(1L)).thenReturn(Optional.of(existente));
        when(repository.save(existente)).thenReturn(existente);

        TrilhaAprendizagem atualizado = service.atualizar(1L, novo);

        assertEquals("Novo", atualizado.getNome());
    }

    @Test
    void deveDeletarTrilha() {
        doNothing().when(repository).deleteById(1L);
        service.deletar(1L);
        verify(repository).deleteById(1L);
    }
}
