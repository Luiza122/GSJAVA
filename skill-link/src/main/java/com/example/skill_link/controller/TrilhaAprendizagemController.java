package com.example.skill_link.controller;

import com.example.skill_link.model.TrilhaAprendizagem;
import com.example.skill_link.service.TrilhaAprendizagemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/api/trilhas")
public class TrilhaAprendizagemController {
    @Autowired
    private TrilhaAprendizagemService service;

    @GetMapping
    public ResponseEntity<List<TrilhaAprendizagem>> listar() {
        return ResponseEntity.ok(service.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TrilhaAprendizagem> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }
    @PostMapping
    public ResponseEntity<TrilhaAprendizagem> criar(@Valid @RequestBody TrilhaAprendizagem t) {
        TrilhaAprendizagem trilha = service.criar(t);
        return ResponseEntity.created(URI.create("/api/trilhas/"+trilha.getId())).body(trilha);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TrilhaAprendizagem> atualizar(@PathVariable Long id, @Valid @RequestBody TrilhaAprendizagem t) {
        return ResponseEntity.ok(service.atualizar(id, t));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
