package com.example.trilhaJava.exception;

import com.example.trilhaJava.domain.DadosListaOnePessoaDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TrataErroEnd {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity trata404(){

        return ResponseEntity.notFound().build();

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity trata400(MethodArgumentNotValidException ex){

        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(ErroDTO::new).toList());//stream.map

    }

    private record ErroDTO(String campo, String mensagem){

        public ErroDTO(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }



    }



}