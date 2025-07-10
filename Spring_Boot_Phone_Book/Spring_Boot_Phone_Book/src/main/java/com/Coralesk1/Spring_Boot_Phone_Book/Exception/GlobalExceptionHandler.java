package com.Coralesk1.Spring_Boot_Phone_Book.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> handleValidationExceptions(MethodArgumentNotValidException ex){
        String message = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        /*getBindingResult() Recupera o resultado da validação-
        * getFieldErrors() - Obtém a lista de erros nos campos
        * get(0) - Pega o primeiro erro da lista
        * getDefaultMessage() - Retorna a mensagem de erro padrão desse erro do @NotBlank*/
        ErroResponse erro = new ErroResponse(message,
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(ErroException.class) //captura exceções do tipo ErroException
    public ResponseEntity<ErroResponse> handleErrorException(ErroException e) {
        ErroResponse erro = new ErroResponse(
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

}
