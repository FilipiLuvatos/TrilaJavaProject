package com.example.trilhaJava.controller;


import com.example.trilhaJava.domain.UserDTO;
import com.example.trilhaJava.model.pessoa.Conta;
import com.example.trilhaJava.model.pessoa.Usuario;
import com.example.trilhaJava.repository.UsuarioRepository;
import com.example.trilhaJava.service.CriptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping("/cad")
    @Transactional
    public ResponseEntity cadastroUsuario(@RequestBody UserDTO usuario) {
        String senhaCriptografada = CriptoService.hashPassword(usuario.getPass());
        usuario.setPass(senhaCriptografada); // Define a senha criptografada no DTO
        usuarioRepository.save(new Usuario(usuario));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>>listaPessoaAll(){
        var lista = usuarioRepository.findAll();
        return ResponseEntity.ok(lista); //200
    }


    @GetMapping("/consulta")
    public ResponseEntity consultaUsuario(@RequestParam("ad_pessoa") Long ad_pessoa){
        var listaConsulta = usuarioRepository.getConsultaUsuario(ad_pessoa);

        if(listaConsulta.isEmpty()){
            String menssagemPessoa = "[Consulta não retornou dados]";
            return ResponseEntity.ok(menssagemPessoa);

        }else return ResponseEntity.ok(listaConsulta);
    }

    @DeleteMapping("/delete/{ad_pessoa}")
    @Transactional
    public ResponseEntity excluirPessoa(@PathVariable("ad_pessoa") Long ad_pessoa){

        if (!usuarioRepository.existsById(ad_pessoa)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("[Pessoa não encontrada.]");
        }
        usuarioRepository.deleteById(ad_pessoa);
        return ResponseEntity.noContent().build(); // Retorna 204, especifico para excluão
    }
}
