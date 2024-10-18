package com.example.trilhaJava.service;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var tokenJWT = recuperaToken(request);

        var subject = tokenService.getSubject(tokenJWT);
        System.out.println(subject);

        filterChain.doFilter(request, response); // Irá chamar os proximos filtros
    }

    private String recuperaToken(HttpServletRequest request) {
        var autorizaHeader = request.getHeader("Authorization");

        if ( autorizaHeader == null){
            throw new RuntimeException("[Token not FOUND]");
        }
        return autorizaHeader.replace("Bearer ","");

    }


}
