package com.example.trilhaJava.service;

import com.example.trilhaJava.domain.UserDTO;
import com.example.trilhaJava.model.pessoa.Usuario;
import com.example.trilhaJava.repository.UsuarioRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PlanilhaService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RestTemplate restTemplate;

    public String readyPlanilha(MultipartFile file){
        StringBuilder resultado = new StringBuilder("Cadastro realizado com sucesso para os seguintes usuários:\n");

        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
                Sheet sheet = workbook.getSheetAt(0); // Lê a primeira aba

            for (Row row : sheet) {
                // Supondo que o login esteja na primeira coluna e a senha na segunda
                String login = row.getCell(0).getStringCellValue();
                String pass = row.getCell(1).getStringCellValue();

                // Criar o objeto UserDTO
                UserDTO usuario = new UserDTO();
                usuario.setLogin(login);
                usuario.setPass(pass);

                // Chamada para o endpoint de cadastro
                ResponseEntity<String> response = cadastrarUsuario(usuario, usuarioRepository);

                if (response.getStatusCode().is2xxSuccessful()) {
                    resultado.append("Usuário ").append(login).append(" cadastrado com sucesso.\n");
                } else {
                    resultado.append("Erro ao cadastrar usuário ").append(login).append(": ").append(response.getBody()).append("\n");
                }
            }
            return resultado.toString();
        } catch (
                IOException e) {
            e.printStackTrace(); // Trate o erro adequadamente
            return "[Erro ao processar o arquivo!]";
        }

    }

    public ResponseEntity<String> cadastrarUsuario(UserDTO usuario,  UsuarioRepository usuarioRepository) {

        String senhaCriptografada = CriptoService.hashPassword(usuario.getPass());
        usuario.setPass(senhaCriptografada); // Define a senha criptografada no DTO
        usuarioRepository.save(new Usuario(usuario));
        System.out.println("[Usuario cadastrado]:" + usuario);
        return ResponseEntity.ok().build();

    }


}
