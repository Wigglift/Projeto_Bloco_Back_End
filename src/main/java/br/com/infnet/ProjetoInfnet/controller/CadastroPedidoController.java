package br.com.infnet.ProjetoInfnet.controller;

import br.com.infnet.ProjetoInfnet.model.domain.CarrinhoDeCompras;
import br.com.infnet.ProjetoInfnet.model.domain.LoginUsuario;
import br.com.infnet.ProjetoInfnet.model.domain.entities.Pedido;
import br.com.infnet.ProjetoInfnet.model.domain.enumerator.StatusPedido;
import br.com.infnet.ProjetoInfnet.model.domain.enumerator.TipoPagamentoPedido;
import br.com.infnet.ProjetoInfnet.model.service.CadastroPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastroPedidoController {

    @Autowired
    CadastroPedidoService cadastroPedidoService;

    public ResponseEntity<Pedido> criarPedido(Pedido pedido){

        Pedido novoPedido = cadastroPedidoService.criarPedido(pedido);

        return new ResponseEntity<Pedido>(novoPedido,HttpStatus.CREATED);
    }
}
