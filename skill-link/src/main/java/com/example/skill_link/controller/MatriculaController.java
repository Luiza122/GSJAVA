package com.example.skill_link.controller;

import com.example.skill_link.model.Competencia;
import com.example.skill_link.model.Matricula;
import com.example.skill_link.model.Usuario;
import com.example.skill_link.service.MatriculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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
