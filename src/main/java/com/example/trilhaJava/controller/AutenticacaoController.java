package com.example.trilhaJava.controller;

import com.example.trilhaJava.domain.DadosAutenticaDTO;
import com.example.trilhaJava.domain.DadosTokenJWTDTO;
import com.example.trilhaJava.model.pessoa.Usuario;
import com.example.trilhaJava.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody DadosAutenticaDTO dados){

        var Autotoken = new UsernamePasswordAuthenticationToken(dados.login, dados.pass);
        var autenticado =  manager.authenticate(Autotoken); //Dispara o processo de autenticação
        var token = tokenService.geraToken((Usuario) autenticado.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWTDTO(token));
    }


}
