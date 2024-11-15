package com.example.trilhaJava.controller;

import com.example.trilhaJava.domain.*;
import com.example.trilhaJava.model.pessoa.Transacao;
import com.example.trilhaJava.repository.TransacaoRepository;
import com.example.trilhaJava.service.MoneyApiConverService;
import com.example.trilhaJava.service.RelatorioContaExcel;
import com.example.trilhaJava.service.ValidaTransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;
    @Autowired
    private MoneyApiConverService moneyApiConverService;
    @Autowired
    private ValidaTransacaoService validaTransacaoService;

    @GetMapping("/all")
    public ResponseEntity<List<Transacao>> listaTransacaoAll(){
        var listaPessoa = transacaoRepository.findAll();
        return ResponseEntity.ok(listaPessoa);//200
    }

    @PostMapping("/relatorio")
    public ResponseEntity<byte[]> listaTransacaoContaRelatorio(@RequestBody RelaTransDTO transacao) {
        System.out.println(transacao.getNumConta());
        var listaTransacao = transacaoRepository.getTransacaoConta(transacao.getNumConta());

        RelatorioContaExcel excelExportService = new RelatorioContaExcel();
        try {
            // Gerando o arquivo Excel
            byte[] excelFile = excelExportService.exportToExcel(listaTransacao);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=transacoes.xlsx");
            headers.add("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(excelFile);

        } catch (IOException e) {
            // Tratar exceção e retornar erro adequado
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(("Erro ao gerar o arquivo Excel: " + e.getMessage()).getBytes());
        }
    }


    @PostMapping("/lista") //get
    public ResponseEntity listaTransacaoConta(@RequestBody RelaTransDTO transacao) {
        System.out.println(transacao.getNumConta());
        var listaTransacao = transacaoRepository.getTransacaoConta(transacao.getNumConta());
        return ResponseEntity.ok(listaTransacao);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastraTransacao(@RequestBody TransacaoDTO transacao, UriComponentsBuilder uriB) {

        try{
            validaTransacaoService.validaTransacao(transacao);
            transacaoRepository.save(new Transacao(moneyApiConverService.converteTransacao(transacao)));
            var uri = uriB.path("/transacao/{id}").buildAndExpand(transacao.getId()).toUri();
            return ResponseEntity.created(uri).body(transacao);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }


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
