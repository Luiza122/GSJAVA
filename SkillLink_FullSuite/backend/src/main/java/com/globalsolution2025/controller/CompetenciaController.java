package com.globalsolution2025.controller;
import org.springframework.web.bind.annotation.*; import org.springframework.beans.factory.annotation.Autowired; import jakarta.validation.Valid; import java.util.List;
import com.globalsolution2025.model.Competencia; import com.globalsolution2025.service.CompetenciaService;
@RestController @RequestMapping("/api/competencias")
public class CompetenciaController {
 @Autowired private CompetenciaService service;
 @GetMapping public List<Competencia> listar(){ return service.listar(); }
 @GetMapping("/{id}") public Competencia obter(@PathVariable Long id){ return service.buscar(id); }
 @PostMapping public Competencia criar(@Valid @RequestBody Competencia c){ return service.criar(c); }
 @PutMapping("/{id}") public Competencia atualizar(@PathVariable Long id, @Valid @RequestBody Competencia c){ return service.atualizar(id,c); }
 @DeleteMapping("/{id}") public void remover(@PathVariable Long id){ service.remover(id); }
}