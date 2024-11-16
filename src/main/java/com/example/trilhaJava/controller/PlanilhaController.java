package com.example.trilhaJava.controller;

import com.example.trilhaJava.domain.UserDTO;
import com.example.trilhaJava.model.pessoa.Usuario;
import com.example.trilhaJava.repository.UsuarioRepository;
import com.example.trilhaJava.service.CriptoService;
import com.example.trilhaJava.service.PlanilhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/planilha")
public class PlanilhaController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PlanilhaService planilhaService;

    @PostMapping("/upload")
    public String uploadExcelFile(@RequestParam("file") MultipartFile file) {
        return planilhaService.readyPlanilha(file);
    }

    public ResponseEntity<String> cadastrarUsuario(UserDTO usuario) {
        String senhaCriptografada = CriptoService.hashPassword(usuario.getPass());
        usuario.setPass(senhaCriptografada); // Define a senha criptografada no DTO
        usuarioRepository.save(new Usuario(usuario));
        System.out.println("[Usuario cadastrado]:" + usuario);
        return ResponseEntity.ok().build();

    }


}
