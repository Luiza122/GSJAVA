package com.example.skill_link.service;

import com.example.skill_link.exception.NaoEncontradoException;
import com.example.skill_link.model.Matricula;
import com.example.skill_link.repository.MatriculaRepository;
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
class MatriculaServiceTest {
    @Mock
    private MatriculaRepository repository;
    @InjectMocks
    private MatriculaService service;

    @Test
    void deveListarMatriculas() {
        when(repository.findAll()).thenReturn(List.of(new Matricula()));
        assertEquals(1, service.listar().size());
    }

    @Test
    void deveBuscarMatricula() {
        Matricula m = new Matricula();
        m.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(m));

        assertEquals(1L, service.buscar(1L).getId());
    }

    @Test
    void deveLancarErroAoBuscarMatriculaInexistente() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NaoEncontradoException.class, () -> service.buscar(1L));
    }

    @Test
    void deveCriarMatricula() {
        Matricula m = new Matricula();
        when(repository.save(m)).thenReturn(m);

        assertEquals(m, service.criar(m));
    }

    @Test
    void deveAtualizarMatricula() {
        Matricula existente = new Matricula();
        existente.setStatus("Antigo");

        Matricula novo = new Matricula();
        novo.setStatus("Novo");

        when(repository.findById(1L)).thenReturn(Optional.of(existente));
        when(repository.save(existente)).thenReturn(existente);

        Matricula atualizado = service.atualizar(1L, novo);

        assertEquals("Novo", atualizado.getStatus());
    }

    @Test
    void deveDeletarMatricula() {
        doNothing().when(repository).deleteById(1L);
        service.deletar(1L);
        verify(repository).deleteById(1L);
    }
}
