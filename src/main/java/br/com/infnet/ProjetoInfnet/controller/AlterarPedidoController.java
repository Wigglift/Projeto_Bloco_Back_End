package br.com.infnet.ProjetoInfnet.controller;

import br.com.infnet.ProjetoInfnet.model.domain.entities.Pedido;
import br.com.infnet.ProjetoInfnet.model.service.AlterarPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@RestController
public class AlterarPedidoController {

    @Autowired
    AlterarPedidoService alterarPedidoService;

    public ResponseEntity<Pedido> alterarEndereco(String[] infoAlterar){

        int id = Integer.parseInt(infoAlterar[0]);

        String endereco = infoAlterar[1];

        Pedido pedidoAlterado = alterarPedidoService.alterarEndereco(id,endereco);

        return new ResponseEntity<Pedido>(pedidoAlterado, HttpStatus.OK);
    }
}
