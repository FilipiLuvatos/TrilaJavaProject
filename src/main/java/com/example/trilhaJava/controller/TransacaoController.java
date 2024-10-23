package com.example.trilhaJava.controller;

import com.example.trilhaJava.domain.AtualizaContaDTO;
import com.example.trilhaJava.domain.AtualizaTransacaoDTO;
import com.example.trilhaJava.domain.PessoaFDTO;
import com.example.trilhaJava.domain.TransacaoDTO;
import com.example.trilhaJava.model.pessoa.PessoaF;
import com.example.trilhaJava.model.pessoa.Transacao;
import com.example.trilhaJava.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Transacao>> listaPessoaAll(){
        var listaPessoa = transacaoRepository.findAll();
        return ResponseEntity.ok(listaPessoa);//200
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastraTransacao(@RequestBody TransacaoDTO transacao, UriComponentsBuilder uriB) {
        transacaoRepository.save(new Transacao(transacao));
        var uri = uriB.path("/transacao/{id}").buildAndExpand(transacao.getId()).toUri();
        return ResponseEntity.created(uri).body(transacao);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirTransacao(@PathVariable Long id){

        transacaoRepository.deleteAllById(Collections.singleton(id));
        return ResponseEntity.noContent().build(); // Retorna 204, especifico para excluão
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizaDadosTransacao(@RequestBody AtualizaTransacaoDTO atualizaDados){
        var transacaoid = transacaoRepository.getReferenceById(atualizaDados.getId());
        transacaoid.AtualizaDados(atualizaDados);
        return  ResponseEntity.ok(atualizaDados);

    }

}
