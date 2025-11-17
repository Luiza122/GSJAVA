package com.example.skill_link.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.skill_link.model.Matricula;
import com.example.skill_link.service.MatriculaService;

import jakarta.validation.Valid;

@RestController @RequestMapping("/api/matriculas")
public class MatriculaController {
    @Autowired
    private MatriculaService service;

    @GetMapping
    public ResponseEntity<List<Matricula>> listar() {
        return ResponseEntity.ok(service.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Matricula> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }
    @PostMapping
    public ResponseEntity<Matricula> criar(@Valid @RequestBody Matricula m) {
        Matricula matricula = service.criar(m);
        return ResponseEntity.created(URI.create("/api/matriculas/"+matricula.getId())).body(matricula);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Matricula> atualizar(@PathVariable Long id, @Valid @RequestBody Matricula m) {
        return ResponseEntity.ok(service.atualizar(id, m));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
