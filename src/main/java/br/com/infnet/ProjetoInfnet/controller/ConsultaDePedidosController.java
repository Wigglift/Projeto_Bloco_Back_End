package br.com.infnet.ProjetoInfnet.controller;

import br.com.infnet.ProjetoInfnet.model.domain.entities.Pedido;
import br.com.infnet.ProjetoInfnet.model.service.ConsultaDePedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultaDePedidosController {

    @Autowired
    ConsultaDePedidosService consultaDePedidosService;

    public ResponseEntity<List<Pedido>> verPedidos(){
        try {
            List<Pedido> pedidos = consultaDePedidosService.pegarPedidos();

            return new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<List<Pedido>>(HttpStatus.NOT_FOUND);
        }
    }
}
