package com.example.skill_link.controller;

import com.example.skill_link.model.Competencia;
import com.example.skill_link.service.CompetenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/api/competencias")
public class CompetenciaController {
    @Autowired
    private CompetenciaService service;

    @GetMapping
    public ResponseEntity<List<Competencia>> listar() {
        return ResponseEntity.ok(service.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Competencia> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }
    @PostMapping
    public ResponseEntity<Competencia> criar(@Valid @RequestBody Competencia c) {
        Competencia competencia = service.criar(c);
        return ResponseEntity.created(URI.create("/api/competencias/"+competencia.getId())).body(competencia);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Competencia> atualizar(@PathVariable Long id, @Valid @RequestBody Competencia c) {
        return ResponseEntity.ok(service.atualizar(id, c));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
