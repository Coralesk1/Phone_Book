package com.Coralesk1.Spring_Boot_Phone_Book.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new HashMap<>(); //armazena os erros
        List<String> errors =
                ex.getBindingResult().getFieldErrors().stream()
                .map(field -> field.getDefaultMessage())
                .collect(Collectors.toList());
                /*getBindingResult() Recupera o resultado da validação-
                 *getFieldErrors() - Obtém a lista de erros nos campos
                * stream() - transforma a lista em um stream (estrutura para processar dados de forma funcional).
                * .map(field -> field.getDefaultMessage()) - extrai a mensagem de erro personalizada de cada campo.
                * .collect(Collectors.toList()) -  transforma isso em uma lista de strings com os erros.*/
        response.put("message", "Validation failed");
        response.put("errors", errors);
        response.put("erro", 400);

        return ResponseEntity.badRequest().body(response);
    }
    /*ELE TA     "The first name cannot contain numbers or spaces"
    ] MODIFICA O REGEX SÓ PRA PEGA NUMEROS*/

}
