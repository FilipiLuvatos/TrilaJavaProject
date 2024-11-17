package com.example.trilhaJava.controller;

import com.example.trilhaJava.domain.*;
import com.example.trilhaJava.enumeration.TypeTransacao;
import com.example.trilhaJava.model.pessoa.Transacao;
import com.example.trilhaJava.repository.TransacaoRepository;
import com.example.trilhaJava.service.MoneyApiConverService;
import com.example.trilhaJava.service.RelatorioContaExcel;
import com.example.trilhaJava.service.TransacaoContService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;
    @Autowired
    private MoneyApiConverService moneyApiConverService;

    @Autowired
    private TransacaoContService transacaoContService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastraTransacao(@Valid @RequestBody TransacaoDTO transacao, UriComponentsBuilder uriB) {
        return ResponseEntity.ok(transacaoContService.cadastraTransacao(transacao,uriB));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Transacao>> listaTransacaoAll(){
        return ResponseEntity.ok(transacaoContService.listaTransacaoAll());//200
    }


    @GetMapping("/allTransacao")
    public ResponseEntity<List<Transacao>> consultaAllTransaca(@RequestParam("fkNumConta") Integer numConta){
        return ResponseEntity.ok(transacaoContService.consultaAllTransaca(numConta));//200
    }

    @PostMapping("/relatorio")
    public ResponseEntity<byte[]> listaTransacaoContaRelatorio(@Valid @RequestBody RelaTransDTO transacao) {
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
                    .body(("ErroPessoa ao gerar o arquivo Excel: " + e.getMessage()).getBytes());
        }
    }


    @GetMapping("/consultaTransacao")
    public ResponseEntity consultaTransacaoConta(@RequestParam("fkNumConta") Long numConta,
                                                 @RequestParam("dtInicio") LocalDate dt_inicio,
                                                 @RequestParam("Tipo") TypeTransacao tipo) {
        return ResponseEntity.ok(transacaoContService.consultaTransacaoConta(numConta,dt_inicio,tipo));
    }



    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirTransacao(@PathVariable Long id){
        transacaoContService.excluirTransacao(id);
        return ResponseEntity.noContent().build(); // Retorna 204, especifico para excluão
    }

    @PutMapping("/atualiza")
    @Transactional
    public ResponseEntity atualizaDadosTransacao(@Valid @RequestBody AtualizaTransacaoDTO atualizaDados){
        transacaoContService.atualizaDadosTransacao(atualizaDados);
        return  ResponseEntity.ok(atualizaDados);

    }

}
