package com.globalsolution2025.controller;
import org.springframework.web.bind.annotation.*; import org.springframework.beans.factory.annotation.Autowired; import jakarta.validation.Valid; import java.util.List;
import com.globalsolution2025.model.Usuario; import com.globalsolution2025.service.UsuarioService;
@RestController @RequestMapping("/api/usuarios")
public class UsuarioController {
 @Autowired private UsuarioService service;
 @GetMapping public List<Usuario> listar(){ return service.listar(); }
 @GetMapping("/{id}") public Usuario obter(@PathVariable Long id){ return service.buscar(id); }
 @PostMapping public Usuario criar(@Valid @RequestBody Usuario u){ return service.criar(u); }
 @PutMapping("/{id}") public Usuario atualizar(@PathVariable Long id, @Valid @RequestBody Usuario u){ return service.atualizar(id,u); }
 @DeleteMapping("/{id}") public void remover(@PathVariable Long id){ service.remover(id); }
}