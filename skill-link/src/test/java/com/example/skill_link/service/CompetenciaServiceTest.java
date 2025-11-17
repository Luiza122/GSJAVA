package com.example.skill_link.service;

import com.example.skill_link.exception.NaoEncontradoException;
import com.example.skill_link.model.Competencia;
import com.example.skill_link.repository.CompetenciaRepository;
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
class CompetenciaServiceTest {
    @Mock
    private CompetenciaRepository repository;
    @InjectMocks
    private CompetenciaService service;

    @Test
    void deveListarCompetencias() {
        when(repository.findAll()).thenReturn(List.of(new Competencia()));
        assertEquals(1, service.listar().size());
    }

    @Test
    void deveBuscarCompetencia() {
        Competencia c = new Competencia();
        c.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(c));

        assertEquals(1L, service.buscar(1L).getId());
    }

    @Test
    void deveLancarErroAoBuscarInexistente() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(NaoEncontradoException.class, () -> service.buscar(1L));
    }

    @Test
    void deveCriarCompetencia() {
        Competencia c = new Competencia();
        when(repository.save(c)).thenReturn(c);

        assertEquals(c, service.criar(c));
    }

    @Test
    void deveAtualizarCompetencia() {
        Competencia existente = new Competencia();
        existente.setNome("Antigo");

        Competencia novo = new Competencia();
        novo.setNome("Novo");

        when(repository.findById(1L)).thenReturn(Optional.of(existente));
        when(repository.save(existente)).thenReturn(existente);

        Competencia atualizado = service.atualizar(1L, novo);

        assertEquals("Novo", atualizado.getNome());
    }

    @Test
    void deveDeletarCompetencia() {
        doNothing().when(repository).deleteById(1L);
        service.deletar(1L);

        verify(repository).deleteById(1L);
    }
}
