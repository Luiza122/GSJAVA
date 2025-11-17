package com.example.skill_link.controller;

import com.example.skill_link.model.Usuario;
import com.example.skill_link.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(service.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }
    @PostMapping
    public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario u) {
        Usuario usuario = service.criar(u);
        return ResponseEntity.created(URI.create("/api/usuarios/"+usuario.getId())).body(usuario);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario u) {
        return ResponseEntity.ok(service.atualizar(id, u));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
