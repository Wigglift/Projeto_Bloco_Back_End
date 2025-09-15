package br.com.infnet.ProjetoInfnet.controller;

import br.com.infnet.ProjetoInfnet.model.domain.LoginUsuario;
import br.com.infnet.ProjetoInfnet.model.service.LoginUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
public class LoginUsuarioController {

    @Autowired
    LoginUsuarioService loginUsuarioService;

    //Logar
    public void logar(Scanner scanner){
        System.out.println("Digite o email para logar:");
        String email = scanner.next();
        scanner.nextLine();

        System.out.println("Digite a senha do login");
        String senha = scanner.next();
        scanner.nextLine();

        String mensagem = loginUsuarioService.logar(email, senha);

        System.out.println(mensagem);
    }
}
