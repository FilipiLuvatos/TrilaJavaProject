package com.example.trilhaJava.service;

import com.example.trilhaJava.domain.AtualizaTransacaoDTO;
import com.example.trilhaJava.domain.TransacaoDTO;
import com.example.trilhaJava.enumeration.TypeTransacao;
import com.example.trilhaJava.model.pessoa.Transacao;
import com.example.trilhaJava.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


@Service
public class TransacaoContService {

    @Autowired
    private TransacaoRepository transacaoRepository;
    @Autowired
    private MoneyApiConverService moneyApiConverService;
    @Autowired
    private ValidaTransacaoService validaTransacaoService;

    public Transacao cadastraTransacao(TransacaoDTO transacao,  UriComponentsBuilder uriB){

        return transacaoRepository.save(new Transacao(moneyApiConverService.converteTransacao(transacao)));
    }

    public List<Transacao> listaTransacaoAll(){
        return transacaoRepository.findAll();
    }

    public List<Transacao> consultaAllTransaca(Integer numConta){
        return transacaoRepository.getTransacaoConta(numConta);
    }

    public List<Transacao>consultaTransacaoConta(Long numConta, LocalDate dt_inicio, TypeTransacao tipo){
        return transacaoRepository.getTransacao(numConta,dt_inicio, tipo);
    }

    public void excluirTransacao (Long id){
        transacaoRepository.deleteAllById(Collections.singleton(id));
    }

    public void atualizaDadosTransacao(AtualizaTransacaoDTO atualizaDados){
        var transacaoid = transacaoRepository.getReferenceById(atualizaDados.getId());
        transacaoid.AtualizaDados(atualizaDados);
    }

}
