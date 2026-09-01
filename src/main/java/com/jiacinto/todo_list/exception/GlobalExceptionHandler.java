package com.jiacinto.todo_list.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // inteercepte les erreurs de validation déclenchées par @Valid -> que nous appelons dans notre controller createTask
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        
        // Récupère le message associé à la première erreur de validation
        String message = ex.getBindingResult()
            .getFieldError()
            .getDefaultMessage();
        
        // Retourne une réponse HTTP 400 avec le message d'erreur
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
