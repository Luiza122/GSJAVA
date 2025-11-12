package com.globalsolution2025.handler;
import org.springframework.web.bind.annotation.*; import org.springframework.http.*; import org.springframework.web.bind.MethodArgumentNotValidException;
import com.globalsolution2025.exception.*; import java.util.stream.Collectors;
@RestControllerAdvice public class GlobalExceptionHandler {
 @ExceptionHandler(UsuarioNaoEncontradoException.class) public ResponseEntity<String> h1(UsuarioNaoEncontradoException ex){ return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage()); }
 @ExceptionHandler(TrilhaNaoEncontradaException.class) public ResponseEntity<String> h2(TrilhaNaoEncontradaException ex){ return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage()); }
 @ExceptionHandler(MethodArgumentNotValidException.class) public ResponseEntity<String> h3(MethodArgumentNotValidException ex){
  String msg = ex.getBindingResult().getFieldErrors().stream().map(e-> e.getField()+": "+e.getDefaultMessage()).collect(Collectors.joining("; "));
  return ResponseEntity.badRequest().body(msg);
 }
 @ExceptionHandler(Exception.class) public ResponseEntity<String> h4(Exception ex){ return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado: "+ex.getMessage()); }
}
