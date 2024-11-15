package com.example.trilhaJava.controller;

import com.example.trilhaJava.domain.AtualizaPessoaDTO;
import com.example.trilhaJava.domain.PessoaDTO;
import com.example.trilhaJava.model.pessoa.Pessoa;
import com.example.trilhaJava.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/pessoa2")
public class Pessoa2Controller {

    @Autowired
    private PessoaRepository pessoaRepository;


    @PostMapping("cadastro") //Cadastra Pessoa
    @Transactional
    public ResponseEntity cadastrarPessoa(@RequestBody PessoaDTO pessoa) {
        pessoaRepository.save(new Pessoa(pessoa));
        return ResponseEntity.ok(pessoa);

    }
    @GetMapping("/consultaPessoa") // Consulta Pessoa
    public ResponseEntity consultaPessoa(@RequestParam("ad_pessoa") Long ad_pessoa) {
        var listaConsulta = pessoaRepository.getConsultaPessoa(ad_pessoa);

        if(listaConsulta.isEmpty()){
            String menssagemPessoa = "[Consulta não retornou dados]";
            return ResponseEntity.ok(menssagemPessoa);

        }else return ResponseEntity.ok(listaConsulta);

    }
    @GetMapping("/consultaAll") //Consulta todas pessoas
    public ResponseEntity consultaAll() {
        var listaConsulta = pessoaRepository.findAll();

        if(listaConsulta.isEmpty()){
            String menssagemPessoa = "[Consulta não retornou dados]";
            return ResponseEntity.ok(menssagemPessoa);

        }else return ResponseEntity.ok(listaConsulta);

    }

    @DeleteMapping("/delete/{ad_pessoa}")
    public ResponseEntity<String> excluirPessoa(@PathVariable("ad_pessoa") Long ad_pessoa) {

        if (!pessoaRepository.existsById(ad_pessoa)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("[Pessoa não encontrada.]");
        }
        pessoaRepository.deleteById(ad_pessoa);
        return ResponseEntity.noContent().build(); // Retorna 204, especifico para excluão
    }

    @PutMapping("/atualiza")
    @Transactional
    public ResponseEntity atualizaDadosPessoa(@RequestBody AtualizaPessoaDTO atualizaDados){
        var pessoa = pessoaRepository.getReferenceById(atualizaDados.getId());
        pessoa.atualizarInfos(atualizaDados);

        return  ResponseEntity.ok(pessoa);//200
    }




}

