package br.com.infnet.ProjetoInfnet.controller;

import br.com.infnet.ProjetoInfnet.model.domain.entities.Pedido;
import br.com.infnet.ProjetoInfnet.model.service.CancelarPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
public class CancelarPedidoController {

    @Autowired
    CancelarPedidoService cancelarPedidoService;

    public ResponseEntity<Void> cancelarPedido(Scanner scanner){
        System.out.println("Qual o numero do pedido para cancelar?");
        int id = scanner.nextInt();

        cancelarPedidoService.cancelarPedido(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
