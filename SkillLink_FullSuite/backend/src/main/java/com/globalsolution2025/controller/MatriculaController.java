package com.globalsolution2025.controller;
import org.springframework.web.bind.annotation.*; import org.springframework.beans.factory.annotation.Autowired; import jakarta.validation.Valid; import java.util.List;
import com.globalsolution2025.model.Matricula; import com.globalsolution2025.service.MatriculaService;
@RestController @RequestMapping("/api/matriculas")
public class MatriculaController {
 @Autowired private MatriculaService service;
 @GetMapping public List<Matricula> listar(){ return service.listar(); }
 @GetMapping("/{id}") public Matricula obter(@PathVariable Long id){ return service.buscar(id); }
 @PostMapping public Matricula criar(@Valid @RequestBody Matricula m){ return service.criar(m); }
 @PutMapping("/{id}") public Matricula atualizar(@PathVariable Long id, @Valid @RequestBody Matricula m){ return service.atualizar(id,m); }
 @DeleteMapping("/{id}") public void remover(@PathVariable Long id){ service.remover(id); }
}