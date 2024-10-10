package com.example.trilhaJava.controller;

import com.example.trilhaJava.domain.AtualizaContaDTO;
import com.example.trilhaJava.domain.ContaDTO;
import com.example.trilhaJava.model.pessoa.Conta;
import com.example.trilhaJava.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {


    @Autowired
    private ContaRepository repositoryConta;
    @PostMapping
    @Transactional
    public void cadastrarConta(@RequestBody ContaDTO N_Conta) {
        repositoryConta.save(new Conta(N_Conta));
        System.out.println("Teste_Conta:" + N_Conta);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Conta>>listaPessoaAll(){
        var lista = repositoryConta.findAll();
        return ResponseEntity.ok(lista); //200
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizaDadosPessoa(@RequestBody AtualizaContaDTO atualizaDados){
        var conta = repositoryConta.getReferenceById(atualizaDados.getId());
        conta.atualizarInfosConta(atualizaDados);
        return  ResponseEntity.ok(atualizaDados);

    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirPessoa(@PathVariable Long id){

        repositoryConta.deleteAllById(Collections.singleton(id));
        return ResponseEntity.noContent().build(); // Retorna 204, especifico para excluão
    }

}
