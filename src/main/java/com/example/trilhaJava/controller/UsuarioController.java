package com.example.trilhaJava.controller;

import com.example.trilhaJava.domain.DadosListaOnePessoaDTO;
import com.example.trilhaJava.domain.UserDTO;
import com.example.trilhaJava.model.pessoa.Conta;
import com.example.trilhaJava.model.pessoa.Usuario;
import com.example.trilhaJava.repository.UsuarioRepository;
import com.example.trilhaJava.service.CriptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastroUsuario(@RequestBody UserDTO usuario) {

        String senhaCriptografada = CriptoService.hashPassword(usuario.getPass());
        usuario.setPass(senhaCriptografada); // Define a senha criptografada no DTO
        usuarioRepository.save(new Usuario(usuario));
        System.out.println("[Usuario cadastrado]:" + usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>>listaPessoaAll(){
        var lista = usuarioRepository.findAll();
        return ResponseEntity.ok(lista); //200
    }


    @GetMapping("/{id}")
    public ResponseEntity<Usuario>listaUsuarioOne(@PathVariable Long id){

        var pessoa = usuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new Usuario(pessoa));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirPessoa(@PathVariable Long id){

        usuarioRepository.deleteAllById(Collections.singleton(id));
        return ResponseEntity.noContent().build(); // Retorna 204, especifico para excluão
    }
}
