package com.example.trilhaJava.service;

import com.example.trilhaJava.domain.UserDTO;
import com.example.trilhaJava.model.pessoa.Usuario;
import com.example.trilhaJava.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioContService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UserDTO cadastroUsuario (UserDTO usuario){
        String senhaCriptografada = CriptoService.hashPassword(usuario.getPass());

        String senhaTratada = trataSenha(senhaCriptografada);

        usuario.setPass(senhaTratada); // Define a senha criptografada no DTO
        usuarioRepository.save(new Usuario(usuario));
        return usuario;
    }
    public List<Usuario>consultaUsuario(Long ad_pessoa){
        return usuarioRepository.getConsultaUsuario(ad_pessoa);
    }
    public void excluirPessoa(Long ad_pessoa){
        usuarioRepository.deleteById(ad_pessoa);
    }

    public List<Usuario> atualizaDadosPessoa (UserDTO usuario){
        var pessoa = usuarioRepository.getReferenceById(usuario.getId());
        String senhaCriptografada = CriptoService.hashPassword(usuario.getPass());
        String senhaTratada = trataSenha(senhaCriptografada);
        usuario.setPass(senhaTratada); // Define a senha criptografada no DTO
        pessoa.atualizarInfos(usuario);

        var user = usuarioRepository.getConsultaUsuario(usuario.getAd_Pessoa());
        return user;
    }
    public String trataSenha(String senha){
        return senha.replaceFirst("^\\$2a\\$10\\$", "");
    }

}
