package com.example.trilhaJava.controller;


import com.example.trilhaJava.domain.AtualizaPessoaDTO;
import com.example.trilhaJava.domain.UserDTO;
import com.example.trilhaJava.model.pessoa.Conta;
import com.example.trilhaJava.model.pessoa.Usuario;
import com.example.trilhaJava.repository.UsuarioRepository;
import com.example.trilhaJava.service.CriptoService;
import com.example.trilhaJava.service.UsuarioContService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@SecurityRequirement(name = "bearer-key")
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioContService usuarioContService;


    @PostMapping("/cad")
    @Transactional
    public ResponseEntity cadastroUsuario(@RequestBody UserDTO usuario) {
        return ResponseEntity.ok(usuarioContService.cadastroUsuario(usuario));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>>listaPessoaAll(){
        var lista = usuarioRepository.findAll();
        return ResponseEntity.ok(lista); //200
    }


    @GetMapping("/consulta")
    public ResponseEntity consultaUsuario(@RequestParam("ad_pessoa") Long ad_pessoa){
        return ResponseEntity.ok(usuarioContService.consultaUsuario(ad_pessoa));
    }

    @DeleteMapping("/delete/{ad_pessoa}")
    @Transactional
    public ResponseEntity excluirPessoa(@PathVariable("ad_pessoa") Long ad_pessoa){
        usuarioContService.excluirPessoa(ad_pessoa);
        return ResponseEntity.noContent().build(); // Retorna 204, especifico para excluão
    }

    @PutMapping("/atualiza")
    @Transactional
    public ResponseEntity atualizaDadosPessoa(@Valid @RequestBody UserDTO usuario){
        return  ResponseEntity.ok(usuarioContService.atualizaDadosPessoa(usuario));//200
    }
}
