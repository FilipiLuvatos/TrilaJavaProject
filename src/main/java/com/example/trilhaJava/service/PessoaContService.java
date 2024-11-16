package com.example.trilhaJava.service;

import com.example.trilhaJava.domain.AtualizaPessoaDTO;
import com.example.trilhaJava.domain.PessoaDTO;
import com.example.trilhaJava.model.pessoa.Pessoa;
import com.example.trilhaJava.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaContService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDTO cadastrarPessoa(PessoaDTO pessoa){
        pessoaRepository.save(new Pessoa(pessoa));
        return pessoa;
    }

    public List<Pessoa>consultaPessoa(Long ad_pessoa){
        return pessoaRepository.getConsultaPessoa(ad_pessoa);
    }
    public List<Pessoa>consultaAll(){
        return pessoaRepository.findAll();
    }
    public void excluirPessoa(Long ad_pessoa){
        pessoaRepository.deleteById(ad_pessoa);
    }
    public Pessoa atualizaDadosPessoa(AtualizaPessoaDTO atualizaDados){
        var pessoa = pessoaRepository.getReferenceById(atualizaDados.getId());
        pessoa.atualizarInfos(atualizaDados);
        return pessoa;
    }

}
