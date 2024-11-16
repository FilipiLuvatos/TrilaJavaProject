package com.example.trilhaJava.service;

import com.example.trilhaJava.domain.AtualizaContaDTO;
import com.example.trilhaJava.domain.ContaDTO;
import com.example.trilhaJava.model.pessoa.Conta;
import com.example.trilhaJava.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ContaContService {
    @Autowired
    private ValidaContaService validaContaService;
    @Autowired
    private ContaRepository repositoryConta;

    public ContaDTO cadastrarConta(ContaDTO numConta){
        repositoryConta.save(new Conta(numConta));
        return numConta;
    }
    public List<Conta> consultaConta(Long numConta){
        return repositoryConta.getConsultaConta(numConta);
    }
    public List<Conta>listaAllConta(){
        return repositoryConta.findAll();
    }
    public AtualizaContaDTO atualizaDadosConta(AtualizaContaDTO atualizaDados){
        var conta = repositoryConta.getReferenceById(atualizaDados.getId());
        conta.atualizarInfosConta(atualizaDados);
        return atualizaDados;
    }
    public void excluiConta (Long id){
        repositoryConta.deleteAllById(Collections.singleton(id));
    }
}
