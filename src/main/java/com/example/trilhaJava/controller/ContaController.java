package com.example.trilhaJava.controller;

import com.example.trilhaJava.domain.AtualizaContaDTO;
import com.example.trilhaJava.domain.ContaDTO;
import com.example.trilhaJava.enumeration.TypeTransacao;
import com.example.trilhaJava.model.pessoa.Conta;
import com.example.trilhaJava.repository.ContaRepository;
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

    @PostMapping("/cadastra")
    @Transactional
    public ResponseEntity cadastrarConta(@RequestBody ContaDTO N_Conta) {

            repositoryConta.save(new Conta(N_Conta));
            return ResponseEntity.ok(N_Conta);

    }

    @GetMapping("/consultaConta")
    public ResponseEntity consultaTransacao(@RequestParam("fkNumConta") Long numConta) {
        var listaTransacao = repositoryConta.getConsultaConta(numConta);
        return ResponseEntity.ok(listaTransacao);
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
