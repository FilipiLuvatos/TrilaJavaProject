package com.example.trilhaJava.controller;

import com.example.trilhaJava.domain.AtualizaPessoaDTO;
import com.example.trilhaJava.domain.PessoaDTO;
import com.example.trilhaJava.model.pessoa.Pessoa;
import com.example.trilhaJava.repository.PessoaRepository;
import com.example.trilhaJava.service.PessoaContService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaContService pessoaContService;

    @PostMapping("cadastro") //Cadastra Pessoa
    @Transactional
    public ResponseEntity cadastrarPessoa(@Valid @RequestBody PessoaDTO pessoa) {
        return ResponseEntity.ok(pessoaContService.cadastrarPessoa(pessoa));

    }
    @GetMapping("/consultaPessoa") // Consulta Pessoa
    public ResponseEntity consultaPessoa(@Valid @RequestParam("ad_pessoa") Long ad_pessoa) {
        return ResponseEntity.ok(pessoaContService.consultaPessoa(ad_pessoa));
    }
    @GetMapping("/consultaAll") //Consulta todas pessoas
    public ResponseEntity consultaAll() {
       return ResponseEntity.ok(pessoaContService.consultaAll());
    }

    @DeleteMapping("/delete/{ad_pessoa}")
    public ResponseEntity<String> excluirPessoa(@Valid @PathVariable("ad_pessoa") Long ad_pessoa) {
        pessoaContService.excluirPessoa(ad_pessoa);
        return ResponseEntity.noContent().build(); // Retorna 204, especifico para excluão
    }

    @PutMapping("/atualiza")
    @Transactional
    public ResponseEntity atualizaDadosPessoa(@Valid @RequestBody AtualizaPessoaDTO atualizaDados){
        return  ResponseEntity.ok(pessoaContService.atualizaDadosPessoa(atualizaDados));//200
    }




}

