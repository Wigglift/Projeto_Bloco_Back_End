package br.com.infnet.ProjetoInfnet.controller;

import br.com.infnet.ProjetoInfnet.model.domain.LoginUsuario;
import br.com.infnet.ProjetoInfnet.model.domain.entities.Usuario;
import br.com.infnet.ProjetoInfnet.model.service.LoginUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
public class LoginUsuarioController {

    @Autowired
    LoginUsuarioService loginUsuarioService;

    //Logar
    public ResponseEntity<Usuario> logar(String email, String senha){

        Usuario usuarioLogado = loginUsuarioService.logar(email, senha);

        if(usuarioLogado == null)return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);

        if(usuarioLogado.getSenha() == null ) return new ResponseEntity<Usuario>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<Usuario>(usuarioLogado, HttpStatus.OK);
    }
}
