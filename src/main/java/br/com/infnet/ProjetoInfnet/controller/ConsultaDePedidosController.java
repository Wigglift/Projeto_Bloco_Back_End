package br.com.infnet.ProjetoInfnet.controller;

import br.com.infnet.ProjetoInfnet.model.domain.entities.Pedido;
import br.com.infnet.ProjetoInfnet.model.service.ConsultaDePedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultaDePedidosController {

    @Autowired
    ConsultaDePedidosService consultaDePedidosService;

    public void verPedidos(){
        List<Pedido> pedidos = consultaDePedidosService.pegarPedidos();

        for(Pedido pedido : pedidos){
            System.out.println(pedido);
        }
    }
}
