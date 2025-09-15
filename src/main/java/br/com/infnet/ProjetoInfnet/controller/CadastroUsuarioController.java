package br.com.infnet.ProjetoInfnet.controller;

import br.com.infnet.ProjetoInfnet.model.domain.CadastroUsuario;
import br.com.infnet.ProjetoInfnet.model.domain.entities.Usuario;
import br.com.infnet.ProjetoInfnet.model.service.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;


@RestController
public class CadastroUsuarioController {

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

//cadastrar
    public void cadastrar(Scanner scanner){
    System.out.println("Digite o email:");
    String email = scanner.next();
    scanner.nextLine();

    System.out.println("Digite a senha");
    String senha = scanner.next();
    scanner.nextLine();

    String mensagem = cadastroUsuarioService.cadastrar(email,senha);

    System.out.println(mensagem);
}

//emailValido

//senhaValida
}
