package com.example.trilhaJava.controller;

import com.example.trilhaJava.domain.AtualizaContaDTO;
import com.example.trilhaJava.domain.ContaDTO;
import com.example.trilhaJava.enumeration.TypeTransacao;
import com.example.trilhaJava.model.pessoa.Conta;
import com.example.trilhaJava.repository.ContaRepository;
import com.example.trilhaJava.service.ContaContService;
import com.example.trilhaJava.service.ValidaContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ValidaContaService validaContaService;
    @Autowired
    private ContaRepository repositoryConta;

    @Autowired
    private ContaContService contaContService;

    @PostMapping("/cadastra")
    @Transactional
    public ResponseEntity cadastrarConta(@RequestBody ContaDTO NumConta) {
            return ResponseEntity.ok(contaContService.cadastrarConta(NumConta));

    }

    @GetMapping("/consultaConta")
    public ResponseEntity consultaConta(@RequestParam("fkNumConta") Long numConta) {
        return ResponseEntity.ok(contaContService.consultaConta(numConta));
    }


    @GetMapping("/all")
    public ResponseEntity<List<Conta>>listaAllConta(){
        return ResponseEntity.ok(contaContService.listaAllConta()); //200
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizaDadosConta(@RequestBody AtualizaContaDTO atualizaDados){
            return  ResponseEntity.ok(contaContService.atualizaDadosConta(atualizaDados));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluiConta(@PathVariable Long id){
        contaContService.excluiConta(id);
        return ResponseEntity.noContent().build(); // Retorna 204, especifico para excluão
    }

}
