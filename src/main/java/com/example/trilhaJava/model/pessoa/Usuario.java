package com.example.trilhaJava.model.pessoa;

import com.example.trilhaJava.domain.AtualizaPessoaDTO;
import com.example.trilhaJava.domain.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuario")
@Entity(name = "Usuario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ad_pessoa;
    private String login;
    private String pass;

    public Usuario(UserDTO usuario) {
        this.login = usuario.getLogin();
        this.pass = usuario.getPass();
        this.ad_pessoa = usuario.getAd_Pessoa();
    }

    public Usuario(Usuario pessoa) {
        this.id = pessoa.getId();
        this.ad_pessoa = pessoa.getAd_pessoa();
        this.login = pessoa.getLogin();
        this.pass  = pessoa.getPass();
    }

    public void atualizarInfos(UserDTO dados) {
        this.pass = dados.getPass();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
