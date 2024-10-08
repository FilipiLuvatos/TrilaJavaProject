package com.example.trilhaJava.controller;

import com.example.trilhaJava.domain.AtualizaPessoaDTO;
import com.example.trilhaJava.domain.DadosListaOnePessoaDTO;
import com.example.trilhaJava.domain.PessoaFDTO;
import com.example.trilhaJava.pessoa.PessoaF;
import com.example.trilhaJava.repository.PessoaFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaFRepository pessoaRepository;

    @PostMapping
    @Transactional
    public void cadastrarPessoa(@RequestBody PessoaFDTO pessoaF) {
        pessoaRepository.save(new PessoaF(pessoaF));

    }

    @GetMapping("/all")
    public ResponseEntity<List<PessoaF>>listaPessoaAll(){
        var listaPessoa = pessoaRepository.findAll();
        return ResponseEntity.ok(listaPessoa);//200
    }


    @GetMapping("/one")
    public List<DadosListaOnePessoaDTO>listaPessoaOne(){
        return pessoaRepository.findAll().stream().map(DadosListaOnePessoaDTO:: new).toList();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizaDadosPessoa(@RequestBody AtualizaPessoaDTO atualizaDados){
        var pessoa = pessoaRepository.getReferenceById(atualizaDados.getId());
        pessoa.atualizarInfos(atualizaDados);

        return  ResponseEntity.ok(pessoa);//200
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirPessoa(@PathVariable Long id){

        pessoaRepository.deleteAllById(Collections.singleton(id));
        return ResponseEntity.noContent().build(); // Retorna 204, especifico para excluão
    }

}
