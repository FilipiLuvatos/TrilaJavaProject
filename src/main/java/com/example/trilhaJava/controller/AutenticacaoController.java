package com.example.trilhaJava.controller;

import com.example.trilhaJava.domain.ContaDTO;
import com.example.trilhaJava.domain.DadosAutenticaDTO;
import com.example.trilhaJava.domain.DadosTokenJWTDTO;
import com.example.trilhaJava.domain.UserDTO;
import com.example.trilhaJava.model.pessoa.Conta;
import com.example.trilhaJava.model.pessoa.Usuario;
import com.example.trilhaJava.repository.UsuarioRepository;
import com.example.trilhaJava.service.CriptoService;
import com.example.trilhaJava.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody DadosAutenticaDTO dados){

        Usuario usuario = (Usuario) usuarioRepository.findByLogin(dados.login);

        if (!CriptoService.checkPassword(dados.pass, usuario.getPass())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Senha incorreta
        }

        try {
            var Autotoken = new UsernamePasswordAuthenticationToken(dados.login, usuario.getPass());
            var autenticado = manager.authenticate(Autotoken);
            var token = tokenService.geraToken((Usuario) autenticado.getPrincipal());
            return ResponseEntity.ok(new DadosTokenJWTDTO(token));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("[ErroPessoa ao gerar o Token!]");
        }

    }


}
