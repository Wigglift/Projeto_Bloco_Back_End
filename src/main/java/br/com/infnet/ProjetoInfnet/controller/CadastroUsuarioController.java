package br.com.infnet.ProjetoInfnet.controller;

import br.com.infnet.ProjetoInfnet.model.domain.CadastroUsuario;
import br.com.infnet.ProjetoInfnet.model.domain.entities.Usuario;
import br.com.infnet.ProjetoInfnet.model.service.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;


@RestController
public class CadastroUsuarioController {

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;


    public ResponseEntity<Usuario> cadastrar(CadastroUsuario novoCadastro){

    Usuario usuario = cadastroUsuarioService.cadastrar(novoCadastro);

    if (usuario == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
}
}
