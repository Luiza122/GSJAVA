package com.globalsolution2025.controller;
import org.springframework.web.bind.annotation.*; import org.springframework.beans.factory.annotation.Autowired; import jakarta.validation.Valid; import java.util.List;
import com.globalsolution2025.model.TrilhaDeAprendizagem; import com.globalsolution2025.service.TrilhaService;
@RestController @RequestMapping("/api/trilhas")
public class TrilhaController {
 @Autowired private TrilhaService service;
 @GetMapping public List<TrilhaDeAprendizagem> listar(){ return service.listar(); }
 @GetMapping("/{id}") public TrilhaDeAprendizagem obter(@PathVariable Long id){ return service.buscar(id); }
 @PostMapping public TrilhaDeAprendizagem criar(@Valid @RequestBody TrilhaDeAprendizagem t){ return service.criar(t); }
 @PutMapping("/{id}") public TrilhaDeAprendizagem atualizar(@PathVariable Long id, @Valid @RequestBody TrilhaDeAprendizagem t){ return service.atualizar(id,t); }
 @DeleteMapping("/{id}") public void remover(@PathVariable Long id){ service.remover(id); }
}